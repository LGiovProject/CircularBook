package com.ispw.circularbook.engineering.factory;

import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.bean.ElementBookBean;
import javafx.scene.layout.Pane;

import java.io.IOException;

public interface ViewFactory {

    Pane createPane(ElementBookBean elementBookBean) throws IOException;
    Object createController();
}
