package com.ispw.circularbook.engineering.state.cli;

import com.ispw.circularbook.controller.graficcontroller.cli.*;
import com.ispw.circularbook.view.cli.CLIHomepageUserView;



public class CLIHomepageGuestState implements CLIHomepageState{private CLIHomepageController context;

    @Override
    public int startHomepage(CLIHomepageController context){
        this.context= context;
        CLIHomepageUserView cliHomepageUserView = new CLIHomepageUserView();
        return cliHomepageUserView.start();
    }

    public void insertLenderBook()
    {
        System.out.println("Serve aver fatto il login per eseguire questa operazione!");
        context.start();
    }

    public void insertGiftBook()
    {
        System.out.println("Serve aver fatto il login per eseguire questa operazione!");
        context.start();
    }

    public void insertBook()
    {
        System.out.println("Serve aver fatto il login per eseguire questa operazione!");
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
        System.out.println("Serve aver fatto il login per eseguire questa operazione!");
        context.start();
    }

    @Override
    public void setting()
    {
        System.out.println("Serve aver fatto il login per eseguire questa operazione!");
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
