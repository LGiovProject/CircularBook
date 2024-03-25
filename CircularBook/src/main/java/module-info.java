module ispw.circularbook.circularbook {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens ispw.circularbook.circularbook to javafx.fxml;
    exports ispw.circularbook.circularbook;
    opens ispw.circularbook.circularbook.controller.graficontroller.gui to javafx.fxml;
    exports ispw.circularbook.circularbook.controller.graficontroller.gui;

}