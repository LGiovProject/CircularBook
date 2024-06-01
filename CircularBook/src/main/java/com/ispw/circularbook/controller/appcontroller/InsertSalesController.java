package com.ispw.circularbook.controller.appcontroller;

import com.ispw.circularbook.engineering.bean.SalesBean;
import com.ispw.circularbook.engineering.dao.SalesDAO;

public class InsertSalesController {
    public void insertSales(SalesBean salesBean){
        SalesDAO.insertSales(salesBean);
    }
    public void updateSales(SalesBean salesBean){SalesDAO.updateSales(salesBean);}
    public void removeSales(SalesBean salesBean){
        SalesDAO.removeSales(salesBean);
    }

}
