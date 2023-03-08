package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Button btnDoctor;
    @FXML
    private Button btnPaciente;

    public void mostrarDoctor(ActionEvent actionEvent) throws IOException {
        cambiarVentana("doctor.fxml","Transacciones",702,462, btnDoctor);
    }

    public void mostrarPaciente(ActionEvent actionEvent) throws IOException {
        cambiarVentana("paciente.fxml","Transacciones",702,462, btnPaciente);
    }

    private void cambiarVentana(String fxml, String nombre, int ancho, int largo, Button btn) throws IOException {
        Parent parent = FXMLLoader.load(HelloApplication.class.getResource(fxml));
        Scene scene = new Scene(parent, ancho, largo);
        Stage stage = new Stage();
        stage.setTitle(nombre);
        stage.setScene(scene);
        stage.initOwner(btn.getScene().getWindow());
        btn.getScene().getWindow().hide();
        stage.show();
    }
}