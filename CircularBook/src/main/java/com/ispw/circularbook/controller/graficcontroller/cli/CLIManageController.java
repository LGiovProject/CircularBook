package com.ispw.circularbook.controller.graficcontroller.cli;

import com.ispw.circularbook.engineering.state.cli.CLIManageLibraryState;
import com.ispw.circularbook.engineering.state.cli.CLIManageState;
import com.ispw.circularbook.engineering.state.cli.CLIManageUserState;

public class CLIManageController {

    private CLIManageState currentState;

    private  CLIHomepageController cliHomepageController;

    public CLIManageController(CLIHomepageController cliHomepageController){this.cliHomepageController=cliHomepageController;}

    public void setState(CLIManageState cliManageState){this.currentState = cliManageState;}

    public void startManage(int type)
    {
        if(type==1)
        {
            this.setState(new CLIManageUserState(this));
        } else if (type==2) {
            this.setState(new CLIManageLibraryState(this));
        }
        start();
    }

    public void start()
    {
        command(currentState.start());
    }

    public void command(int i)
    {
        currentState.command(i);
    }

    public void goBack()
    {
        cliHomepageController.start();
    }
}
