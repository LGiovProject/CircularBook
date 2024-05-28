package com.ispw.circularbook.controller.appcontroller;

import com.ispw.circularbook.engineering.bean.SalesBean;

import com.ispw.circularbook.engineering.bean.SearchSalesBean;
import com.ispw.circularbook.engineering.dao.SalesDAO;
import com.ispw.circularbook.model.SalesModel;


import java.util.ArrayList;
import java.util.List;

    public class SearchSalesController {

    public List<SalesModel> searchSales(SearchSalesBean searchSalesBean) throws Exception {
        List<SalesModel> salesModelList = new ArrayList<>();
        List<SalesBean> salesBeanList= SalesDAO.searchSales(searchSalesBean);
        for(SalesBean salesBean: salesBeanList)
        {
            SalesModel salesModel= new SalesModel(salesBean.getId(),salesBean.getEmail(),salesBean.getNameLib(),salesBean.getTypeOfSalesInt(),salesBean.getTitlePromotion(),salesBean.getDescription(),salesBean.getDateStart(),salesBean.getDateFinish());
            salesModelList.add(salesModel);
        }
        return salesModelList;
    }
    public List<SalesModel> searchSales(String email) throws Exception {
            List<SalesBean> salesBeanList;

            List<SalesModel> salesModelList= new ArrayList<>();
                   salesBeanList= SalesDAO.searchSales(email);
            for(SalesBean salesBean: salesBeanList)
            {
                SalesModel salesModel= new SalesModel(salesBean.getId(),salesBean.getEmail(),salesBean.getNameLib(),salesBean.getTypeOfSalesInt(),salesBean.getTitlePromotion(),salesBean.getDescription(),salesBean.getDateStart(),salesBean.getDateFinish());
                System.out.println("SearchSalesController.searchSales()  "+salesModel.getDateStart()+" "+salesModel.getDateFinishString());
                salesModelList.add(salesModel);
            }
            return salesModelList;
    }
}
