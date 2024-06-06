package com.ispw.circularbook.engineering.state.cli;

import com.ispw.circularbook.controller.graficcontroller.cli.CLIHomepageController;

import java.io.IOException;

public interface CLIHomepageState {
    int startHomepage(CLIHomepageController context);
    void setting() throws IOException ;
    void logOut();
    void command(int i);
}
