module com.ispw.circularbook {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;
    requires mysql.connector.j;


    opens com.ispw.circularbook to javafx.fxml;
    exports com.ispw.circularbook;
    exports com.ispw.circularbook.controller.graficcontroller.gui to javafx.fxml;
    opens com.ispw.circularbook.controller.graficcontroller.gui to javafx.fxml;
}