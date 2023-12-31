module com.analistas.agendafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.analistas.agendafx to javafx.fxml;
    exports com.analistas.agendafx;
    
    opens com.analistas.agendafx.controller to javafx.fxml;
    exports com.analistas.agendafx.controller;
    
    opens com.analistas.agendafx.model to javafx.fxml;
    exports com.analistas.agendafx.model;
    
    opens com.analistas.agendafx.repository to javafx.fxml;
    exports com.analistas.agendafx.repository;
    
}
