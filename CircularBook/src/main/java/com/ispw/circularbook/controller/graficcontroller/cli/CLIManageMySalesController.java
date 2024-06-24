package com.ispw.circularbook.controller.graficcontroller.cli;

import com.ispw.circularbook.controller.appcontroller.InsertSalesController;
import com.ispw.circularbook.engineering.bean.SalesBean;
import com.ispw.circularbook.view.cli.CLIManageMySalesView;

public class CLIManageMySalesController {

    private CLIManageMySalesView cliManageMySalesView;
    private CLIManageController cliManageController;


    public CLIManageMySalesController(CLIManageController cliManageController)
    {
        cliManageMySalesView = new CLIManageMySalesView();
        this.cliManageController= cliManageController;
    }

    public void start()
    {
        command(cliManageMySalesView.start());
    }

    private void command(int i)
    {
        switch (i)
        {
            case 1:
                modifySales();
                break;
            case 2:
                deleteSales();
                break;
            case 3:
                goBack();
                break;
        }
    }

    private void modifySales()
    {
        int id = cliManageMySalesView.modifySales();
        CLIModifySalesController cliModifySalesController = new CLIModifySalesController(this);
        cliModifySalesController.start(id);
    }

    private void deleteSales()
    {
        int id = cliManageMySalesView.deleteSales();
        InsertSalesController insertSalesController =new InsertSalesController();
        SalesBean salesBean = new SalesBean();
        salesBean.setId(id);
        insertSalesController.removeSales(salesBean);
    }

    private void goBack()
    {
        cliManageController.start();
    }
}
