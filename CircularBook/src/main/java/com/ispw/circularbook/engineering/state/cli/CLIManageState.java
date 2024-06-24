package com.ispw.circularbook.engineering.state.cli;

import com.ispw.circularbook.controller.graficcontroller.cli.CLIManageController;

public interface CLIManageState {

    int start();
    void command(int i);
    void manageMyAvailableBook();
    void manageBookIGive();
}
