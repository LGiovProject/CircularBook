package com.ispw.circularbook.engineering.facade;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class SceneFacade {

    private AnchorPane anchorPaneB; // Riferimento al tuo AnchorPane B

    public SceneFacade(AnchorPane anchorPaneB) {
        this.anchorPaneB = anchorPaneB;
    }

    public void loadScene(Pane pane)
    {
            loadFXML(pane);
    }


    private void loadFXML(Pane pane) {
        try {
            anchorPaneB.getChildren().clear(); // Rimuovi eventuali nodi precedenti
            anchorPaneB.getChildren().add(pane);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
