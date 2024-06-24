package com.ispw.circularbook.engineering.state.cli;

import com.ispw.circularbook.controller.graficcontroller.cli.*;
import com.ispw.circularbook.view.cli.CLIHomepageLibraryView;

public class CLIHomepageLibraryState implements CLIHomepageState{

    private CLIHomepageController context;
    private CLIHomepageLibraryView cliHomepageLibraryView;

    public CLIHomepageLibraryState(CLIHomepageController context)
    {
        this.context=context;
        cliHomepageLibraryView = new CLIHomepageLibraryView();
    }

    @Override
    public int startHomepage() {



        return cliHomepageLibraryView.start();

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


    public void insertBook(){context.insertBook();}


    public void insertSales()
    {
        CLIInsertSalesController cliInsertSalesController = new CLIInsertSalesController(context);
        cliInsertSalesController.start();
    }

    public void manageOwn()
    {
        CLIManageController cliManageController = new CLIManageController(context);
        cliManageController.startManage(2);
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

}
