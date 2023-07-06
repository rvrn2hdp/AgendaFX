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

    //Instancia del repositorio de contactos:
    static ContactoRepository repo = new ContactoRepository();

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarDatos();
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

    void cargarDatos() {
        tbvContactos.getItems().clear();
        tbvContactos.getItems().addAll(repo.getContactos());
    }

    @FXML
    private void nuevo_OnAction(ActionEvent event) {

        Window ventanaPadre = btnNuevo.getScene().getWindow();
        String archivoFXML = "contactos-form-view";
        String titulo = "Nuevo Contacto";

        Stage stage = VentanaUtil.abrirDialogo(ventanaPadre, archivoFXML, titulo, Modality.WINDOW_MODAL);
        stage.showAndWait();

        cargarDatos();
    }

    @FXML
    private void editar_OnAction(ActionEvent event) {

        Window ventanaPadre = btnNuevo.getScene().getWindow();
        String archivoFXML = "contactos-form-view";
        String titulo = "Editar Contacto";

        if (tbvContactos.getSelectionModel().getSelectedItems().size() > 0) {
            Contacto contactoSeleccionado = tbvContactos.getSelectionModel().getSelectedItem();
            //mensaje (instancia de contacto) enviado al controlador del formulario
            ContactosFormViewController.contactoActual = contactoSeleccionado;

            Stage stage = VentanaUtil.abrirDialogo(ventanaPadre, archivoFXML, titulo, Modality.WINDOW_MODAL);
            stage.showAndWait();
        } else {
            VentanaUtil.mostrarError("No hay ningún contacto Seleccionado.");
        }

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

    @FXML
    private void buscar_OnAction(ActionEvent event) {
//        tbvContactos.getItems().clear();
//        tbvContactos.getItems().addAll(repo.getContactos(txfBuscar.getText().trim()));
//        tbvContactos.getSelectionModel().selectFirst();
        

        // Otra forma: buscar en la tabla...
        String criterio = txfBuscar.getText().toUpperCase().trim();
        for (Contacto c : tbvContactos.getItems()) {
            if(c.getApellido().toUpperCase().contains(criterio) || c.getNombre().toUpperCase().contains(criterio)) {
                tbvContactos.getSelectionModel().select(c);
            }
        }
    }

}
