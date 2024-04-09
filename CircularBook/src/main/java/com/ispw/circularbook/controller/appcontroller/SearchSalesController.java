package com.ispw.circularbook.controller.appcontroller;

import com.ispw.circularbook.engineering.bean.SalesBean;

import com.ispw.circularbook.engineering.dao.SalesDAO;
import com.ispw.circularbook.model.SalesModel;


import java.util.ArrayList;
import java.util.List;

    public class SearchSalesController {

    public List<SalesBean> searchSales(String nameLib, Integer month, Integer typeOfSales) throws Exception {
        List<SalesBean> salesBeanList= new ArrayList<>();

        List<SalesModel> salesModelList= SalesDAO.searchSales(nameLib,month,typeOfSales);
        for(SalesModel salesModel: salesModelList)
        {
            SalesBean salesBean= new SalesBean(salesModel.getId(),salesModel.getEmail(),salesModel.getNameLib(),salesModel.getTypeOfSales(),salesModel.getTitle(),salesModel.getDescription(),salesModel.getDate_start(),salesModel.getDate_finish());
            salesBeanList.add(salesBean);
        }
        return salesBeanList;
    }
        public List<SalesBean> searchSales(String email) throws Exception {
            List<SalesBean> salesBeanList= new ArrayList<>();

            List<SalesModel> salesModelList=SalesDAO.searchSales(email);
            for(SalesModel salesModel: salesModelList)
            {
                SalesBean salesBean= new SalesBean(salesModel.getId(),salesModel.getEmail(),salesModel.getNameLib(),salesModel.getTypeOfSales(),salesModel.getTitle(),salesModel.getDescription(),salesModel.getDate_start(),salesModel.getDate_finish());
                salesBeanList.add(salesBean);
            }
            return salesBeanList;
        }
}
