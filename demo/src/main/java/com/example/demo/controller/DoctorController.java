package com.example.demo.controller;

import com.example.demo.HelloApplication;
import com.example.demo.model.Paciente;
import com.example.demo.model.TipoDocumento;
import com.example.demo.util.MensajeUtil;
import com.example.demo.util.TextFormatterUtil;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static com.example.demo.controller.AppController.INSTANCE;

public class DoctorController {
    @FXML
    private TextField tfNombre;
    @FXML
    private TextField tfApellido;
    @FXML
    private TextField tfDoc;
    @FXML
    private TextField tfMedi;
    @FXML
    private TextArea taDiaIni;
    @FXML
    private TextArea taDiaFin;
    @FXML
    private ComboBox<TipoDocumento> cbDoc;
    @FXML
    private DatePicker dfFecha;
    @FXML
    private TableView<Paciente> tblPacientes;
    @FXML
    private TableColumn<Paciente, String> colNombre;
    @FXML
    private TableColumn<Paciente, String> colApellido;
    @FXML
    private TableColumn<Paciente, String> colDocumento;
    @FXML
    private TableColumn<Paciente, LocalDate> colFecha;
    @FXML
    private Button btnVolver;
    @FXML
    private Button btnRegistrar;
    @FXML
    private Button btnRemover;
    @FXML
    private Button btnBuscar;
    @FXML
    private Button btnCancelar;
    public static Paciente pacienteSeleccionado;

    @FXML
    public void initialize(){
        llenarTablaPacientes(INSTANCE.getDoctor().buscar(null, null, null, null));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        colDocumento.setCellValueFactory(new PropertyValueFactory<>("documento"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        cbDoc.setItems(FXCollections.observableArrayList(TipoDocumento.values()));

        this.tfDoc.setTextFormatter(new TextFormatter<>(TextFormatterUtil::integerFormat));

        tblPacientes.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> llenarCamposPaciente(newValue));
        pacienteSeleccionado = null;
    }
    public void regresar(ActionEvent actionEvent) throws IOException {
        cambiarVentana("hello-view.fxml","Transacciones", btnVolver);
    }

    private void cambiarVentana(String fxml, String nombre, Button btn) throws IOException {
        Parent parent = FXMLLoader.load(HelloApplication.class.getResource(fxml));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setTitle(nombre);
        stage.setScene(scene);
        stage.initOwner(btn.getScene().getWindow());
        btn.getScene().getWindow().hide();
        stage.show();
    }

    public void registrar(ActionEvent actionEvent) {
        if(INSTANCE.getDoctor().buscarPacientePorDocumento(tfDoc.getText()).isPresent()){
            MensajeUtil.mensajeAlerta("El paciente ya se encuentra registrado");
        }else{
            try{
                Paciente paciente = new Paciente(tfNombre.getText(), tfApellido.getText(), tfDoc.getText(), dfFecha.getValue(), cbDoc.getValue());
                INSTANCE.getDoctor().getListaPacientes().add(paciente);
                llenarTablaPacientes(INSTANCE.getDoctor().buscar(null, null, null, null));
                limpiarCampos();
                MensajeUtil.mensajeInformacion("El paciente ha sido creado");
            }catch(Exception e){
                MensajeUtil.mensajeAlerta(e.getMessage());
            }
        }
    }

    public void remover(ActionEvent actionEvent) {
        try{
            INSTANCE.getDoctor().removerPaciente(tfDoc.getText());
            llenarTablaPacientes(INSTANCE.getDoctor().buscar(null, null, null, null));
            limpiarCampos();
            MensajeUtil.mensajeInformacion("El CLiente ha sido Eliminado");
        }catch(Exception e){
            MensajeUtil.mensajeAlerta(e.getMessage());
        }
    }

    public void buscar(ActionEvent actionEvent) {
        llenarTablaPacientes(INSTANCE.getDoctor().buscar(tfNombre.getText(), tfApellido.getText(), tfDoc.getText(), dfFecha.getValue()));
    }

    public void cancelar(ActionEvent actionEvent) {
        limpiarCampos();
        tblPacientes.getSelectionModel().clearSelection();
    }

    private void llenarTablaPacientes(List<Paciente> clientes){
        tblPacientes.setItems(FXCollections.observableArrayList(clientes));
        tblPacientes.refresh();
    }

    private void limpiarCampos(){
        tfNombre.setText("");
        tfApellido.setText("");
        tfDoc.setText("");
        tfMedi.setText("");
        taDiaIni.setText("");
        taDiaFin.setText("");
        cbDoc.setValue(null);
        dfFecha.setValue(null);
    }
    private void llenarCamposPaciente(Paciente paciente){
        pacienteSeleccionado = paciente;
        if(paciente != null){
            tfNombre.setText(paciente.getNombre());
            tfApellido.setText(paciente.getApellido());
            tfDoc.setText(paciente.getNumero_documento());
            tfMedi.setText(paciente.getMedicamentos());
            taDiaIni.setText(paciente.getDiag_inicial());
            taDiaFin.setText(paciente.getDiag_final());
            cbDoc.setValue(paciente.getTipo_documento());
            dfFecha.setValue(paciente.getFecha_atencion());
        }
    }
}
