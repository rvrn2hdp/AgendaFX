/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.analistas.agendafx.controller;

import com.analistas.agendafx.model.Contacto;
import com.analistas.agendafx.repository.ContactoRepository;
import com.analistas.agendafx.util.VentanaUtil;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
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
    private Label lblApellido;
    @FXML
    private Label lblNombre;
    @FXML
    private Label lblDireccion;
    @FXML
    private Label lblTelefono;
    @FXML
    private Label lblFechaDeNacimiento;
    @FXML
    private Label lblObs;
    @FXML
    private Button btnNuevo;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnBorrar;
    @FXML
    private TableView<Contacto> tbvContactos;

    //Instancia del repositorio de contactos:
    ContactoRepository contactoRepo = new ContactoRepository();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tbvContactos.getItems().addAll(contactoRepo.getContactos());
        tbvContactos.getSelectionModel().selectedItemProperty().addListener(
                ((obs, objAnterior, objActual) -> {
                    lblApellido.setText(objActual.getApellido());
                    lblNombre.setText(objActual.getNombre());
                    lblTelefono.setText(objActual.getTelefono());
                    lblDireccion.setText(objActual.getDireccion() + " - " + objActual.getCiudad());
                    lblFechaDeNacimiento.setText(objActual.getFechaNacimiento().toString());
                    lblObs.setText(objActual.getObservaciones());
                })
        );
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
        
        Window ventanaPadre = btnNuevo.getScene().getWindow();
        String archivoFXML = "contactos-form-view";
        String titulo = "Editar Contacto";
        
        Contacto contactoSeleccionado = tbvContactos.getSelectionModel().getSelectedItem();
        ContactosFormViewController.contactoActual = contactoSeleccionado;
        
        Stage stage = VentanaUtil.abrirDialogo(ventanaPadre, archivoFXML, titulo, Modality.WINDOW_MODAL);
        stage.showAndWait();
        
    }

    @FXML
    private void borrar_OnAction(ActionEvent event) {
        
        if (tbvContactos.getSelectionModel().getSelectedItems().size() > 0) {
            Boolean result = VentanaUtil.mostrarAdvertencia("Esta operación no se puede deshacer. ¿Desea continuar?");
            
            if (result) {
                Contacto contactoSeleccionado = tbvContactos.getSelectionModel().getSelectedItem();
                tbvContactos.getItems().remove(contactoSeleccionado);
            }
            
        } else {
            VentanaUtil.mostrarError("No hay ningún contacto Seleccionado.");
        }
        
        
        
    }

}
