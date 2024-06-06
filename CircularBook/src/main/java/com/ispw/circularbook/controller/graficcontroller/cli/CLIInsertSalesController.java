package com.ispw.circularbook.controller.graficcontroller.cli;

import com.ispw.circularbook.view.cli.CLIInsertSalesView;

public class CLIInsertSalesController {
    CLIInsertSalesView cliInsertSalesView;

    public void start()
    {
        cliInsertSalesView = new CLIInsertSalesView();
        cliInsertSalesView.start();
        insertData();
    }

    public void insertData()
    {
        cliInsertSalesView.insertTitle();
        cliInsertSalesView.insertTypeOfSales();
        cliInsertSalesView.insertDescription();
        cliInsertSalesView.insertDateStart();
        cliInsertSalesView.insertDateFinish();
    }

    public void command(int i)
    {
        switch (i)
        {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;

        }
    }

    public void checkInput
}
