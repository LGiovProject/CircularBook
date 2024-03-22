module ispw.circularbook.circularbook {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens ispw.circularbook.circularbook to javafx.fxml;
    exports ispw.circularbook.circularbook;
}