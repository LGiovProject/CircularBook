package com.ispw.circularbook.controller.appcontroller;

import com.ispw.circularbook.engineering.bean.SalesBean;

import com.ispw.circularbook.engineering.bean.SearchSalesBean;
import com.ispw.circularbook.engineering.dao.SalesDAO;
import com.ispw.circularbook.model.SalesModel;


import java.util.ArrayList;
import java.util.List;

    public class SearchSalesController {

    public List<SalesBean> searchSales(SearchSalesBean searchSalesBean) throws Exception {
        List<SalesBean> salesBeanList= new ArrayList<>();

        List<SalesModel> salesModelList= SalesDAO.searchSales(searchSalesBean);
        for(SalesModel salesModel: salesModelList)
        {
            SalesBean salesBean= new SalesBean(salesModel.getId(),salesModel.getEmail(),salesModel.getNameLib(),salesModel.getTypeOfSales(),salesModel.getTitle(),salesModel.getDescription(),salesModel.getDate_start(),salesModel.getDate_finish());
            salesBeanList.add(salesBean);
        }
        return salesBeanList;
    }
        public List<SalesModel> searchSales(String email) throws Exception {
            List<SalesBean> salesBeanList;

            List<SalesModel> salesModelList= new ArrayList<>();
                   salesBeanList= SalesDAO.searchSales(email);
            for(SalesBean salesBean: salesBeanList)
            {
                SalesModel salesModel= new SalesModel(salesBean.getId(),salesBean.getEmail(),salesBean.getNameLib(),salesBean.getTypeOfSalesInt(),salesBean.getTitle(),salesBean.getDescription(),salesBean.getDateStart(),salesBean.getDateFinish());
                salesModelList.add(salesModel);
            }
            return salesModelList;
        }
}
