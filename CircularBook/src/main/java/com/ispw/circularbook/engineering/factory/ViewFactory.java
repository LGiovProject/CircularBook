package com.ispw.circularbook.engineering.factory;

import javafx.fxml.FXMLLoader;

public interface ViewFactory {

    FXMLLoader createFxmlLoader();
    Object createController();
}
