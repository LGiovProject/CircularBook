package com.ispw.circularbook.controller.graficcontroller.cli;

import com.ispw.circularbook.controller.appcontroller.SearchSalesController;
import com.ispw.circularbook.engineering.bean.SalesBean;
import com.ispw.circularbook.engineering.bean.SearchSalesBean;
import com.ispw.circularbook.engineering.enums.Month;
import com.ispw.circularbook.engineering.enums.TypeOfSales;
import com.ispw.circularbook.model.SalesModel;
import com.ispw.circularbook.view.cli.CLISearchSalesView;

import java.util.ArrayList;
import java.util.List;

public class CLISearchSalesController {

    public CLISearchSalesController(CLIHomepageController cliHomepageController) {
        this.cliHomepageController = cliHomepageController;
    }

    public CLIHomepageController cliHomepageController;
    public SearchSalesBean searchSalesBean;
    public CLISearchSalesView cliSearchSalesView;

    public void start()
    {
        cliSearchSalesView = new CLISearchSalesView(this);
        searchSalesBean = new SearchSalesBean("", Month.Cerca_in_tutti_i_mesi, TypeOfSales.Any);
        this.command(cliSearchSalesView.start());

    }

    public void command(int i)
    {
        switch (i)
        {
            case 1:
                this.insertLibraryName();
                break;
            case 2:
                this.insertMonth();
                break;
            case 3:
                this.insertTypologyInsertion();
                break;
            case 4:
                searchSales();
                break;
            case 5:
                goBack();
                break;
        }
    }

    public void insertLibraryName()
    {
        searchSalesBean.setNameLib(cliSearchSalesView.insertLibraryName());
        cliSearchSalesView.start();
    }

    public void insertMonth()
    {
        searchSalesBean.setMonth(cliSearchSalesView.insertMonth());
        cliSearchSalesView.start();
    }

    public void insertTypologyInsertion()
    {
        searchSalesBean.setTypeOfSales(cliSearchSalesView.insertTypologyInsertion());
        cliSearchSalesView.start();
    }

    public void searchSales()
    {
        List<SalesModel> salesModelList;
        CLIShowSalesController cliShowSalesController = new CLIShowSalesController();
        SearchSalesController searchSalesController = new SearchSalesController();
        try {
            salesModelList=searchSalesController.searchSales(searchSalesBean);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        cliShowSalesController.showSales(getSalesBeanList(salesModelList));
    }

    private List<SalesBean> getSalesBeanList(List<SalesModel> salesModelList)
    {
        List<SalesBean> salesBeanList = new ArrayList<>();
        for(SalesModel salesModel : salesModelList)
        {
            SalesBean salesBean = new SalesBean();
            salesBean.setTitlePromotion(salesModel.getTitle());
            salesBean.setTypeOfSales(salesModel.getTypeOfSalesInt());
            salesBean.setNameLib(salesModel.getNameLib());
            salesBean.setDateStart(salesModel.getDateStart());
            salesBean.setDateFinish(salesModel.getDateFinish());
            salesBean.setDescription(salesModel.getDescription());
            salesBeanList.add(salesBean);
        }
        return salesBeanList;
    }

    private void goBack()
    {
        cliHomepageController.start();
    }


}
