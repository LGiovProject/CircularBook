package com.ispw.circularbook.engineering.Bean;

import com.ispw.circularbook.engineering.Enums.Month;
import com.ispw.circularbook.engineering.Enums.TypeOfSales;
import com.mysql.cj.util.StringUtils;

public class SearchSalesBean {
    private Month month;
    private String nameLib;
    private TypeOfSales typeOfSales;

    public SearchSalesBean(String nameLib, Month mounth, TypeOfSales typeOfSales) {
        this.typeOfSales=typeOfSales;
        this.nameLib = nameLib;
        this.month = mounth;
    }

    public Integer getMonth() {
        if(this.month.getId()==0)
            return null;
        else
            return this.month.getId();
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public String getNameLib() {
        String nameLib;
        if(StringUtils.isEmptyOrWhitespaceOnly(this.nameLib))
            return null;
        else
            return nameLib="'"+this.nameLib+"'";
    }

    public void setNameLib(String nameLib) {
        this.nameLib = nameLib;
    }

    public Integer getTypeOfSales() {
        if(this.typeOfSales.getId()==0)
            return null;
        else
            return this.typeOfSales.getId();
    }

    public void setTypeOfSales(TypeOfSales typeOfSales) {
        this.typeOfSales = typeOfSales;
    }
}
