package com.ispw.circularbook.engineering.state;

import com.ispw.circularbook.controller.graficcontroller.gui.GUIHomepageController;

import java.io.IOException;

public interface HomepageState {
    void startHomepage(GUIHomepageController context) throws IOException;
    void setting(GUIHomepageController context) throws IOException ;
}
