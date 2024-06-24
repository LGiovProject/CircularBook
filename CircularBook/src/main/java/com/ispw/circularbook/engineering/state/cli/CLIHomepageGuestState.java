package com.ispw.circularbook.engineering.state.cli;

import com.ispw.circularbook.controller.graficcontroller.cli.*;
import com.ispw.circularbook.engineering.utils.MessageSupport;
import com.ispw.circularbook.view.cli.CLIHomepageUserView;



public class CLIHomepageGuestState implements CLIHomepageState{

    private CLIHomepageController context;

    private CLIHomepageUserView cliHomepageUserView;


    public CLIHomepageGuestState(CLIHomepageController context)
    {
        this.context= context;
        CLIHomepageUserView cliHomepageUserView = new CLIHomepageUserView();
    }

    @Override
    public int startHomepage(){

        return cliHomepageUserView.start();
    }

    public void insertBook()
    {
        MessageSupport.cliExceptionSMessage("Serve aver fatto il login per eseguire questa operazione!");
        context.start();
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
        MessageSupport.cliExceptionSMessage("Serve aver fatto il login per eseguire questa operazione!");
        context.start();
    }

    @Override
    public void setting()
    {
        MessageSupport.cliExceptionSMessage("Serve aver fatto il login per eseguire questa operazione!");
        context.start();
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
                this.searchBook();
                break;
            case 3:
                this.searchSales();
                break;
            case 4:
                this.manageOwn();
                break;
            case 5:
                this.setting();
                break;
            case 6:
                this.logOut();
                break;
            default:
                break;
        }
    }
}
