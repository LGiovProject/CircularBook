package com.ispw.circularbook.controller.appcontroller;

import com.ispw.circularbook.engineering.bean.SalesBean;
import com.ispw.circularbook.engineering.dao.SalesDAO;

public class InsertSalesController {
    public void insertSales(SalesBean salesBean)
    {
        SalesDAO.insertSales(salesBean);
    }
}
