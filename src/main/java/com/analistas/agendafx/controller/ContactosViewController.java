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
import javafx.scene.control.TextField;
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
    private TextField txfBuscar;
    @FXML
    private Button btnBuscar;
    @FXML
    private Button btnNuevo;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnBorrar;
    @FXML
    private TableView<Contacto> tbvContactos;

    // Instancia del repositorio de contactos:
    static ContactoRepository repo = new ContactoRepository();

    /**
     * Initializes the controller class.
     *
     * @param url The URL of the resource being loaded.
     * @param rb  The ResourceBundle of the resource being loaded.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Load the data
        cargarDatos();
        /**
         * Cannot invoke "com.analistas.agendafx.model.Contacto.getApellido()" because
         * "objActual" is null
         * cuando se intenta crear otro contacto, o se intenta editar otro contacto.
         */
        // Set up listener for selected item change in the table view
        tbvContactos.getSelectionModel().selectedItemProperty().addListener(
                ((obs, objAnterior, objActual) -> {
                    // Update the labels with the selected contact's information
                    lblApellido.setText(objActual.getApellido());
                    lblNombre.setText(objActual.getNombre());
                    lblTelefono.setText(objActual.getTelefono());
                    lblDireccion.setText(objActual.getDireccion() + " - " + objActual.getCiudad());
                    lblFechaDeNacimiento.setText(objActual.getFechaNacimiento().toString());
                    lblObs.setText(objActual.getObservaciones());
                }));
    }

    /**
     * Load data into the table view.
     */
    void cargarDatos() {
        // Clear the items in the table view
        tbvContactos.getItems().clear();

        // Add all the contacts from the repository to the table view
        tbvContactos.getItems().addAll(repo.getContactos());
    }

    /**
     * Opens a new contact form dialog and refreshes the data afterwards.
     */
    @FXML
    private void nuevo_OnAction(ActionEvent event) {
        // Get the parent window
        Window ventanaPadre = btnNuevo.getScene().getWindow();

        // Specify the FXML file and dialog title
        String archivoFXML = "contactos-form-view";
        String titulo = "Nuevo Contacto";

        // Open the dialog and wait for it to close
        Stage stage = VentanaUtil.abrirDialogo(ventanaPadre, archivoFXML, titulo, Modality.WINDOW_MODAL);
        stage.showAndWait();

        // Refresh the data
        cargarDatos();
    }

    /**
     * Handles the action when the "editar" button is clicked.
     * Opens a dialog to edit a contact.
     *
     * @param event The action event
     */
    @FXML
    private void editar_OnAction(ActionEvent event) {

        // Get the parent window
        Window ventanaPadre = btnNuevo.getScene().getWindow();

        // Set the filename of the FXML file
        String archivoFXML = "contactos-form-view";

        // Set the title of the dialog
        String titulo = "Editar Contacto";

        // Check if a contact is selected
        if (tbvContactos.getSelectionModel().getSelectedItems().size() > 0) {

            // Get the selected contact
            Contacto contactoSeleccionado = tbvContactos.getSelectionModel().getSelectedItem();

            // Set the selected contact in the controller of the form
            ContactosFormViewController.contactoActual = contactoSeleccionado;

            // Open the dialog and wait for it to close
            Stage stage = VentanaUtil.abrirDialogo(ventanaPadre, archivoFXML, titulo, Modality.WINDOW_MODAL);
            stage.showAndWait();
        } else {
            // Show an error message if no contact is selected
            VentanaUtil.mostrarError("No hay ningún contacto Seleccionado.");
        }
    }

    /**
     * Delete the selected contact from the table view.
     *
     * @param event the action event that triggers the method
     * @return no return value
     */
    @FXML
    private void borrar_OnAction(ActionEvent event) {

        if (tbvContactos.getSelectionModel().getSelectedItems().size() > 0) {
            Boolean result = VentanaUtil.mostrarAdvertencia("Esta operación no se puede deshacer. ¿Desea continuar?");

            if (Boolean.TRUE.equals(result)) {
                Contacto contactoSeleccionado = tbvContactos.getSelectionModel().getSelectedItem();
                tbvContactos.getItems().remove(contactoSeleccionado);
            }

        } else {
            VentanaUtil.mostrarError("No hay ningún contacto Seleccionado.");
        }

    }

    /**
     * Executes a search action.
     *
     * @param event the action event that triggered the search
     */
    @FXML
    private void buscar_OnAction(ActionEvent event) {
        // tbvContactos.getItems().clear();
        // tbvContactos.getItems().addAll(repo.getContactos(txfBuscar.getText().trim()));
        // tbvContactos.getSelectionModel().selectFirst();

        // Otra forma: buscar en la tabla...
        String criterio = txfBuscar.getText().toUpperCase().trim();
        for (Contacto c : tbvContactos.getItems()) {
            if (c.getApellido().toUpperCase().contains(criterio) || c.getNombre().toUpperCase().contains(criterio)) {
                tbvContactos.getSelectionModel().select(c);
            }
        }
    }

}
