module com.ispw.circularbook {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.ispw.circularbook to javafx.fxml;
    exports com.ispw.circularbook;
    opens com.ispw.circularbook.controller.graficontroller.gui to javafx.fxml;
    exports com.ispw.circularbook.controller.graficontroller.gui;

}