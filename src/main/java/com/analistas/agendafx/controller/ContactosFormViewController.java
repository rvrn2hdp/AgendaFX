/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.analistas.agendafx.controller;

import com.analistas.agendafx.model.Ciudad;
import com.analistas.agendafx.repository.CiudadRepository;
import com.analistas.agendafx.util.VentanaUtil;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author RVRN2
 */
public class ContactosFormViewController implements Initializable {

    @FXML
    private TextField txfApellido;
    @FXML
    private TextField txfNombre;
    @FXML
    private TextField txfDireccion;
    @FXML
    private TextField txfTelefono;
    @FXML
    private DatePicker dtpFechaNacimiento;
    @FXML
    private TextArea txaObservaciones;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnCancelar;
    @FXML
    private ComboBox<Ciudad> cmbLocalidades;

    CiudadRepository ciudadRepo = new CiudadRepository();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cmbLocalidades.getItems().addAll(ciudadRepo.getCiudades());
    }

    @FXML
    private void guardar_OnAction(ActionEvent event) {
        VentanaUtil.mostrarInfo("Guardando Contacto...");
    }

    @FXML
    private void cancelar_OnAction(ActionEvent event) {

        if (VentanaUtil.pedirConfirmacion("¿Desea cancelar la operación?")) {
            Stage stage = (Stage) btnCancelar.getScene().getWindow();
            stage.close();
        }

    }

}
