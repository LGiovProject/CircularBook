package com.ispw.circularbook.controller.appcontroller;

import com.ispw.circularbook.engineering.Bean.SalesBean;
import com.ispw.circularbook.engineering.DAO.SalesDAO;

public class InsertSalesController {
    public void insertSales(SalesBean salesBean)
    {
        SalesDAO.insertSales(salesBean.getEmail(), salesBean.getNameLib(), salesBean.getTitlePromotion(),salesBean.getTypeOfSalesInt(),salesBean.getDescription(),salesBean.getDateStart(),salesBean.getDateFinish());
    }
}
