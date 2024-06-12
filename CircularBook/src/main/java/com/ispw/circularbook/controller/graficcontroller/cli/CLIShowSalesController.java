package com.ispw.circularbook.controller.graficcontroller.cli;

import com.ispw.circularbook.engineering.bean.SalesBean;
import com.ispw.circularbook.view.cli.CLIShowSalesView;

import java.util.List;

public class CLIShowSalesController {

    CLIShowSalesView cliShowSalesView;

    public CLIShowSalesController()
    {
        cliShowSalesView = new CLIShowSalesView();
    }

    public void showSales(List<SalesBean> salesBeanList)
    {

        for(SalesBean salesBean : salesBeanList)
        {
              cliShowSalesView.showInsertion(salesBean);
        }
    }
}
