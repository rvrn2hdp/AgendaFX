module com.analistas.agendafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.analistas.agendafx to javafx.fxml;
    exports com.analistas.agendafx;
    
    opens com.analistas.agendafx.controller to javafx.fxml;
    exports com.analistas.agendafx.controller;
}
