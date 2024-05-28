package com.ispw.circularbook.engineering.factory;

import com.ispw.circularbook.engineering.bean.ElementBean;
import javafx.scene.layout.Pane;

import java.io.IOException;

public interface ViewFactory {

    Pane createPane(ElementBean elementBean) throws IOException;
    Object createController();
}
