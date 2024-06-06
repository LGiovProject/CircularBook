package com.ispw.circularbook.engineering.bean;

import com.ispw.circularbook.engineering.enums.Month;
import com.ispw.circularbook.engineering.enums.TypeOfSales;
import com.mysql.cj.util.StringUtils;

public class SearchSalesBean {
    private Month month;
    private String nameLib;
    private TypeOfSales typeOfSales;

    public SearchSalesBean(String nameLib, Month month, TypeOfSales typeOfSales) {
        this.nameLib= nameLib;
        setTypeOfSales(typeOfSales);
        setMonth(month);
    }

    public SearchSalesBean(String nameLib, String month, String typeOfSales) {
        this.nameLib= nameLib;
        setTypeOfSales(typeOfSales);
        setMonth(month);
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

    public void setMonth(String month){
        for(Month month1: Month.values()) {
            if (month1.getMonth().equals(month))
                this.month=month1;
            else
                this.month=Month.Cerca_in_tutti_i_mesi;
        }
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

    public void setTypeOfSales(String typeOfSales)
    {
        if(TypeOfSales.Event.getType().equals(typeOfSales))
            this.typeOfSales=TypeOfSales.Event;
        else if (TypeOfSales.Promotion.getType().equals(typeOfSales))
            this.typeOfSales=TypeOfSales.Promotion;
        else
            this.typeOfSales=TypeOfSales.Any;
    }
}
