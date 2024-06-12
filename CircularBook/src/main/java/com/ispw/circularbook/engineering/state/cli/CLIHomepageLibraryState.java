package com.ispw.circularbook.engineering.state.cli;

import com.ispw.circularbook.controller.graficcontroller.cli.*;
import com.ispw.circularbook.view.cli.CLIHomepageLibraryView;

public class CLIHomepageLibraryState implements CLIHomepageState{

    private CLIHomepageController context;

    @Override
    public int startHomepage(CLIHomepageController context) {
        this.context=context;

        CLIHomepageLibraryView cliHomepageLibraryView = new CLIHomepageLibraryView();
        return cliHomepageLibraryView.start();

    }

    public void insertBook(){context.insertBook();}


    public void insertSales()
    {
        CLIInsertSalesController cliInsertSalesController = new CLIInsertSalesController(context);
        cliInsertSalesController.start();
    }

    public void manageOwn()
    {
        CLIManageLibraryController cliManageLibraryController = new CLIManageLibraryController(context);
        cliManageLibraryController.start();
    }

    @Override
    public void setting(){

        CLISettingLibraryController cliSettingLibraryController = new CLISettingLibraryController(context);
        cliSettingLibraryController.start();
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
                this.insertBook();
                break;
            case 2:
                this.insertSales();
                break;
            case 3:
                this.manageOwn();
                break;
            case 4:
                this.setting();
                break;
            case 5:
                this.logOut();
                break;
            default:
                break;
        }

    }
}
