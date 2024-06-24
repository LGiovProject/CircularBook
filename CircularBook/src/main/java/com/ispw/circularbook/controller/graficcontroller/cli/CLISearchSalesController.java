package com.ispw.circularbook.controller.graficcontroller.cli;

import com.ispw.circularbook.controller.appcontroller.SearchSalesController;
import com.ispw.circularbook.engineering.bean.SalesBean;
import com.ispw.circularbook.engineering.bean.SearchSalesBean;
import com.ispw.circularbook.engineering.enums.Month;
import com.ispw.circularbook.engineering.enums.TypeOfSales;
import com.ispw.circularbook.engineering.exception.NoSalesFoundException;
import com.ispw.circularbook.engineering.exception.WrongDataFormatException;
import com.ispw.circularbook.engineering.utils.MessageSupport;
import com.ispw.circularbook.model.SalesModel;
import com.ispw.circularbook.view.cli.CLISearchSalesView;

import java.util.ArrayList;
import java.util.List;

public class CLISearchSalesController {

    private CLIHomepageController cliHomepageController;
    private SearchSalesBean searchSalesBean;
    private CLISearchSalesView cliSearchSalesView;


    public CLISearchSalesController(CLIHomepageController cliHomepageController) {
        this.cliHomepageController = cliHomepageController;
        cliSearchSalesView = new CLISearchSalesView(this);
        searchSalesBean = new SearchSalesBean("", Month.Cerca_in_tutti_i_mesi, TypeOfSales.Any);
    }

    public void start()
    {
        this.command(cliSearchSalesView.start(searchSalesBean));
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
                cleanParameters();
                break;
            case 6:
                goBack();
                break;
        }
    }

    public void insertLibraryName()
    {
        searchSalesBean.setNameLib(cliSearchSalesView.insertLibraryName());
        start();
    }

    public void insertMonth()
    {
        searchSalesBean.setMonth(cliSearchSalesView.insertMonth());
        start();
    }

    public void insertTypologyInsertion()
    {
        searchSalesBean.setTypeOfSales(cliSearchSalesView.insertTypologyInsertion());
        start();
    }

    public void searchSales()
    {
        List<SalesModel> salesModelList;
        CLIShowSalesController cliShowSalesController = new CLIShowSalesController();
        SearchSalesController searchSalesController = new SearchSalesController();
        try {
            salesModelList=searchSalesController.searchSales(searchSalesBean);
            cliShowSalesController.showSales(getSalesBeanList(salesModelList));
            start();
        } catch (WrongDataFormatException | NoSalesFoundException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            start();
        }

    }

    private void cleanParameters()
    {
        searchSalesBean.setNameLib("");
        searchSalesBean.setMonth(Month.Cerca_in_tutti_i_mesi);
        searchSalesBean.setTypeOfSales(TypeOfSales.Any);
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
