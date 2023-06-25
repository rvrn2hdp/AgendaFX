/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.analistas.agendafx.util;

import java.io.IOException;
import java.util.Optional;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

public class VentanaUtil {

    /**
     * Returns a JavaFX Stage object with a scene loaded from the specified FXML
     * file.
     *
     * @param ventanaPadre the parent window for the dialog
     * @param archivoFXML the name of the FXML file to load
     * @param titulo the title of the dialog
     * @param modalidad the modality of the dialog
     * @return a JavaFX Stage object representing the dialog
     */
    public static Stage abrirDialogo(Window ventanaPadre, String archivoFXML, String titulo, Modality modalidad) {
        try {
            FXMLLoader loader = new FXMLLoader(com.analistas.agendafx.App.class.getResource(archivoFXML + ".fxml"));
            AnchorPane panel = loader.load();

            Scene scene = new Scene(panel);
            Stage stage = new Stage();

            stage.setTitle(titulo);
            stage.setResizable(false);
            stage.initModality(modalidad);
            stage.initOwner(ventanaPadre);
            stage.centerOnScreen();
            stage.setScene(scene);

            return stage;
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
            return null;
        }
    }

    public static void mostrarInfo(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION, mensaje, ButtonType.OK);
        alerta.showAndWait();
    }

    public static void mostrarError(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR, mensaje, ButtonType.OK);
        alerta.showAndWait();
    }

    public static Boolean mostrarAdvertencia(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.WARNING, mensaje, ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> botonPulsado = alerta.showAndWait();

        return botonPulsado.get() == ButtonType.YES;
    }

    public static Boolean pedirConfirmacion(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION, mensaje, ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> botonPulsado = alerta.showAndWait();

        return botonPulsado.get() == ButtonType.YES;
    }

}
