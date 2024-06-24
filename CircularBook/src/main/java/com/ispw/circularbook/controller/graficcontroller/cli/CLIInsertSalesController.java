package com.ispw.circularbook.controller.graficcontroller.cli;

import com.ispw.circularbook.controller.appcontroller.InsertSalesController;
import com.ispw.circularbook.engineering.bean.SalesBean;
import com.ispw.circularbook.engineering.exception.WrongDataFormatException;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.utils.MessageSupport;
import com.ispw.circularbook.view.cli.CLIInsertSalesView;

import java.util.zip.DataFormatException;

public class CLIInsertSalesController {

    CLIInsertSalesView cliInsertSalesView;
    SalesBean salesBean;
    CLIHomepageController cliHomepageController;

    public CLIInsertSalesController(CLIHomepageController cliHomepageController)
    {
        this.cliHomepageController= cliHomepageController;
        cliInsertSalesView = new CLIInsertSalesView();
        salesBean = new SalesBean();
    }

    public void start()
    {
        cliInsertSalesView.start();
        insertData();
    }

    public void insertData()
    {
        insertTitle();
        insertTypeOfSales();
        insertDescription();
        insertDateStart();
        insertDateFinish();
        finishCommand(cliInsertSalesView.finish());
    }

    public void command(int i)
    {
        switch (i)
        {
            case 1:
                insertData();
                break;
            case 2:
                cliHomepageController.start();
                break;


        }
    }

    public void finishCommand(int i)
    {
        switch (i)
        {
            case 1:
                registrationData();
                break;
            case 2:
                cliHomepageController.start();
                break;
        }
    }

    public void registrationData()
    {
        InsertSalesController insertSalesController = new InsertSalesController();
        salesBean.setEmail(Session.getCurrentSession().getLibrary().getEmail());
        insertSalesController.insertSales(salesBean);
        MessageSupport.cliSuccessMessage("Registrazione avvenuta con successo");
        start();
    }

    public void insertTitle()
    {
        String value;
        value=cliInsertSalesView.insertTitle();
        checkInput(value);
        salesBean.setTitlePromotion(value);
    }

    public void insertTypeOfSales()
    {
        int value;
        value=cliInsertSalesView.insertTypeOfSales();
        checkInput(String.valueOf(value));
        salesBean.setTypeOfSales(value);
    }

    public void insertDescription()
    {
        String value;
        value=cliInsertSalesView.insertDescription();
        checkInput(value);
        salesBean.setDescription(value);
    }

    public void insertDateStart()
    {
        String value;
        value= cliInsertSalesView.insertDateStart();
        checkInput(value);
        try {
            salesBean.setDateStart(value);
        } catch (WrongDataFormatException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
        }

    }

    public void insertDateFinish()
    {
        String value;
        value= cliInsertSalesView.insertDateFinish();
        checkInput(value);
        salesBean.setDateFinish(value);
    }

    private void checkInput(String value)
    {
        try {
            int command = Integer.parseInt(value);
            if (command == -1)
                this.command(2);
        } catch (NumberFormatException e) {
            // Non è un comando numerico, prosegui normalmente
        }
    }

}
