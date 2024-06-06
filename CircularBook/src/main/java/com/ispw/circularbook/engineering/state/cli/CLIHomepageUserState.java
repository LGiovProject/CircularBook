package com.ispw.circularbook.engineering.state.cli;

import com.ispw.circularbook.controller.graficcontroller.cli.*;
import com.ispw.circularbook.view.cli.CLIHomepageUserView;

public class CLIHomepageUserState implements CLIHomepageState{

    private CLIHomepageController context;

    @Override
    public int startHomepage(CLIHomepageController context){
        this.context= context;
        CLIHomepageUserView cliHomepageUserView = new CLIHomepageUserView();
        return cliHomepageUserView.start();
    }

    public void insertLenderBook()
    {
        context.insertLenderBook();
    }

    public void insertGiftBook()
    {
        context.insertGiftBook();
    }

    public void searchBook()
    {
        CLISearchBookController cliSearchBookController = new CLISearchBookController(context);
        cliSearchBookController.start();
    }

    public void searchSales()
    {
        CLISearchSalesController cliSearchSalesController = new CLISearchSalesController(context);
        cliSearchSalesController.start();
    }

    public void manageOwn()
    {
        CLIManageUserController cliManageUserController = new CLIManageUserController();
        cliManageUserController.start();
    }

    @Override
    public void setting()
    {
        CLISettingUserController cliSettingUserController = new CLISettingUserController(context);
        cliSettingUserController.start();
    }
    @Override
    public void logOut() {
        context.logOut();
    }

    @Override
    public void command(int i) {
        switch (i)
        {
            case 1:
                this.insertLenderBook();
                break;
            case 2:
                this.insertGiftBook();
                break;
            case 3:
                this.searchBook();
                break;
            case 4:
                this.searchSales();
                break;
            case 5:
                this.manageOwn();
                break;
            case 6:
                this.setting();
                break;
            case 7:
                this.logOut();
                break;
            default:
                break;
        }
    }
}
