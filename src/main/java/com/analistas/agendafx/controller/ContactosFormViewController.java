package com.analistas.agendafx.controller;

import com.analistas.agendafx.model.Ciudad;
import com.analistas.agendafx.model.Contacto;
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

    static Contacto contactoActual;

    /**
     * Initializes the controller class.
     *
     * @param url the URL of the location used to resolve relative paths for the
     *            root object,
     *            or null if the location is not known.
     * @param rb  the resources used to localize the root object,
     *            or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Populate the items of cmbLocalidades with the list of cities from ciudadRepo
        cmbLocalidades.getItems().addAll(ciudadRepo.getCiudades());

        if (contactoActual != null) {
            // If contactoActual is not null, it means it is a modification, so load the
            // data into the fields
            cargarDatosEnCampos();
        } else {
            // Otherwise, it is a new contact, so do nothing
        }
    }

    /**
     * Sets the values from the current contact to the corresponding GUI fields.
     */
    private void cargarDatosEnCampos() {
        txfApellido.setText(contactoActual.getApellido());
        txfNombre.setText(contactoActual.getNombre());
        txfDireccion.setText(contactoActual.getDireccion());
        txfTelefono.setText(contactoActual.getTelefono());
        dtpFechaNacimiento.setValue(contactoActual.getFechaNacimiento());
        cmbLocalidades.getSelectionModel().select(contactoActual.getCiudad());
        txaObservaciones.setText(contactoActual.getObservaciones());
    }

    /**
     * Checks if all the fields in the form are valid.
     *
     * @return true if all fields are valid, false otherwise
     */
    private boolean sonCamposValidos() {

        boolean result = false;

        if (txfApellido.getText().isBlank()) {
            VentanaUtil.mostrarError("El apellido es requerido...");
        } else if (txfNombre.getText().isBlank()) {
            VentanaUtil.mostrarError("El nombre es requerido...");
        } else if (txfDireccion.getText().isBlank()) {
            VentanaUtil.mostrarError("La direccion es requerida...");
        } else if (txfTelefono.getText().isBlank()) {
            VentanaUtil.mostrarError("El telefono es requerido...");
        } else if (dtpFechaNacimiento.getValue() == null) {
            VentanaUtil.mostrarError("El cumpleaños es requerido...");
        } else if (cmbLocalidades.getSelectionModel().isEmpty()) {
            VentanaUtil.mostrarError("La ciudad Es requerida...");
        } else if (txaObservaciones.getText().isBlank()) {
            VentanaUtil.mostrarError("La Observacion es requerida...");
        } else {
            result = true;
        }
        return result;
    }

    /**
     * Returns the Stage window associated with the btnCancelar button.
     *
     * @return the Stage window associated with the btnCancelar button
     */
    Stage obtenerVentana() {
        return (Stage) btnCancelar.getScene().getWindow();
    }

    @FXML
    private void guardar_OnAction(ActionEvent event) {

        String mensaje;

        if (sonCamposValidos()) {

            if (obtenerVentana().getTitle().contains("Nuevo")) {
                // Es Alta...

                // Crear nuevo contacto...
                contactoActual = new Contacto(ContactosViewController.repo.getContactos().size() + 1,
                        txfApellido.getText().trim(),
                        txfNombre.getText().trim(),
                        txfDireccion.getText().trim(),
                        txfTelefono.getText().trim(),
                        dtpFechaNacimiento.getValue(),
                        txaObservaciones.getText().trim(),
                        cmbLocalidades.getSelectionModel().getSelectedItem());

                // Guardsar en el repo...
                ContactosViewController.repo.addContacto(contactoActual);

                mensaje = "Contacto" + contactoActual + " añadido.";
            } else {
                // Es modificacion...
                contactoActual.setApellido(txfApellido.getText().trim());
                contactoActual.setNombre(txfNombre.getText().trim());
                contactoActual.setTelefono(txfTelefono.getText().trim());
                contactoActual.setDireccion(txfDireccion.getText().trim());
                contactoActual.setCiudad(cmbLocalidades.getSelectionModel().getSelectedItem());
                contactoActual.setFechaNacimiento(dtpFechaNacimiento.getValue());
                contactoActual.setObservaciones(txaObservaciones.getText().trim());

                // Modificar en el repo...
                ContactosViewController.repo.editContacto(contactoActual);
                mensaje = "Contacto " + contactoActual + " modificado.";
            }

            VentanaUtil.mostrarInfo(mensaje);
            obtenerVentana().close();
        }
    }

    /**
     * Cancels the operation when the cancel button is pressed.
     *
     * @param event the action event
     */
    @FXML
    private void cancelar_OnAction(ActionEvent event) {

        // Prompt for user confirmation
        if (VentanaUtil.pedirConfirmacion("¿Desea cancelar la operación?")) {
            // Close the current stage
            Stage stage = (Stage) btnCancelar.getScene().getWindow();
            stage.close();
        }

    }

}
