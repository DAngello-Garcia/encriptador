package com.example.demo.controller;

import com.example.demo.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class PacienteController {

    @FXML
    private Button btnVolver;
    public void regresar(ActionEvent actionEvent)  throws IOException {
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
}
