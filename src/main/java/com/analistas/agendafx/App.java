package com.analistas.agendafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * JavaFX App
 */
public class App extends Application {

    private Stage primaryStage;

    private BorderPane rootLayout;

    /**
     * Initializes the JavaFX primary stage and displays the contact list.
     * Overrides the start method of the Stage class.
     *
     * @param stage the primary stage for the JavaFX application
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void start(Stage stage) throws IOException {
        // Set the primary stage
        this.primaryStage = stage;

        // Set the title of the primary stage
        this.primaryStage.setTitle("Agenda de Contactos");

        // Initialize the root layout for the JavaFX application
        initRootLayout();

        // Display the contact list
        mostrarContactos();
    }

    // Inicializar el layout raiz:
    public void initRootLayout() {
        try {

            // Cargar el archivo fxml del layout:
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("layout-view.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Mostrar el scene conteniendo el layout:
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
    }

    public void mostrarContactos() {
        try {
            // Cargar contactos-view
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("contactos-view.fxml"));
            AnchorPane contactosView = (AnchorPane) loader.load();

            // Asignar contactos view centrado en el layout:
            rootLayout.setCenter(contactosView);

        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
    }

    public static void main(String[] args) {
        launch();
    }

}
