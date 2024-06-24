package com.ispw.circularbook.controller.graficcontroller.cli;

import com.ispw.circularbook.controller.appcontroller.InsertSalesController;
import com.ispw.circularbook.engineering.bean.SalesBean;
import com.ispw.circularbook.engineering.exception.NoSalesFoundException;
import com.ispw.circularbook.engineering.exception.WrongDataFormatException;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.utils.MessageSupport;
import com.ispw.circularbook.model.SalesModel;
import com.ispw.circularbook.view.cli.CLIModifySalesView;

import java.util.List;
import java.util.zip.DataFormatException;

public class CLIModifySalesController {

    private CLIManageMySalesController cliManageMySalesController;
    private CLIModifySalesView cliModifySalesView;
    private SalesBean salesBean;

    public CLIModifySalesController(CLIManageMySalesController cliManageMySalesController)
    {
        this.cliManageMySalesController= cliManageMySalesController;
        this.cliModifySalesView = new CLIModifySalesView();
        salesBean = new SalesBean();

    }

    public void start(int id)
    {
        List <SalesModel> salesModelList = Session.getCurrentSession().getLibrary().getSalesModelList();
        try {
            salesBean= getSalesBean(salesModelList,id);
            command(cliModifySalesView.start(salesBean));
        } catch (NoSalesFoundException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            cliManageMySalesController.start();
        }
    }

    private void startModify()
    {
        command(cliModifySalesView.start(salesBean));
    }

    public void command(int i)
    {
        switch (i) {
            case 1:
                insertTitle();
                break;
            case 2:
                insertType();
                break;
            case 3:
                insertDateStart();
                break;
            case 4:
                insertDateFinish();
                break;
            case 5:
                insertDescription();
                break;
            case 6:
                saveUpdate();
                break;
            case 7:
                goBack();
                break;
        }
    }

    private void insertTitle()
    {
        String value = cliModifySalesView.insertTitle();
        checkData(value);
        salesBean.setTitlePromotion(value);
        startModify();
    }

    private void insertType()
    {
        int value = cliModifySalesView.insertTypeOfSales();
        checkData(String.valueOf(value));
        salesBean.setTypeOfSales(value);
        startModify();
    }

    private void insertDescription()
    {
        String value = cliModifySalesView.insertDescription();
        checkData(value);
        salesBean.setDescription(cliModifySalesView.insertDescription());
        startModify();
    }

    private void insertDateStart()
    {
        String value = cliModifySalesView.insertDateStart();
        checkData(value);
        try {
            salesBean.setDateStart(cliModifySalesView.insertDateStart());
        } catch (WrongDataFormatException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
        }
        startModify();
    }

    private void insertDateFinish()
    {
        String value = cliModifySalesView.insertDateFinish();
        checkData(value);
        salesBean.setDateFinish(cliModifySalesView.insertDateFinish());
        startModify();
    }

    private void saveUpdate()
    {
        salesBean.setEmail(Session.getCurrentSession().getLibrary().getEmail());
        InsertSalesController insertSalesController = new InsertSalesController();
        insertSalesController.updateSales(salesBean);
    }

    private void checkData(String i)
    {
        try {
            int command = Integer.parseInt(i);
            if (command == -1)
                this.command(2);
        } catch (NumberFormatException e) {
            // Non è un comando numerico, prosegui normalmente
        }
    }

    private void goBack()
    {
        cliManageMySalesController.start();
    }

    private SalesBean getSalesBean(List <SalesModel> salesModelList, int id) throws NoSalesFoundException {
        SalesBean salesBean = new SalesBean();
        for(SalesModel salesModel : salesModelList)
        {
            if(salesModel.getId()==id)
            {
                salesBean.setId(salesModel.getId());
                salesBean.setTypeOfSales(salesModel.getTypeOfSalesInt());
                salesBean.setDescription(salesModel.getDescription());
                salesBean.setDateStart(salesModel.getDateStart());
                salesBean.setDateFinish(salesModel.getDateFinish());
                return salesBean;
            }
        }
        throw new NoSalesFoundException();
    }
}
