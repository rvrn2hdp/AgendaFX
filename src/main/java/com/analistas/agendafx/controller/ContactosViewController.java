/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.analistas.agendafx.controller;

import com.analistas.agendafx.util.VentanaUtil;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
/**
 * FXML Controller class
 *
 * @author RVRN2
 */
public class ContactosViewController implements Initializable {


    @FXML
    private Button btnNuevo;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnBorrar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void nuevo_OnAction(ActionEvent event) {
        
        Window ventanaPadre = btnNuevo.getScene().getWindow();
        String archivoFXML = "contactos-form-view";
        String titulo = "Nuevo Contacto";
        
        Stage stage = VentanaUtil.abrirDialogo(ventanaPadre, archivoFXML, titulo, Modality.WINDOW_MODAL);
        stage.showAndWait();
        
    }

    @FXML
    private void editar_OnAction(ActionEvent event) {
    }

    @FXML
    private void borrar_OnAction(ActionEvent event) {
    }

}
