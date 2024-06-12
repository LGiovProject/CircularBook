package com.ispw.circularbook.view.cli;

import com.ispw.circularbook.engineering.bean.SalesBean;

public class CLIShowSalesView {

    public void showInsertion(SalesBean salesBean)
    {
        System.out.println("*************************************\n");
        System.out.println("Titolo :"+salesBean.getTitlePromotion()+"\n");
        System.out.println("Tipologia :"+salesBean.getTypeOfSalesString()+"\n");
        System.out.println("Libreria: "+salesBean.getNameLib()+"\n");
        System.out.println("Data inizio: "+salesBean.getDateStart()+"\n");
        System.out.println("Data fine: "+salesBean.getDateFinish()+"\n");
        System.out.println("Descrizione :"+salesBean.getDescription()+"\n");
        System.out.println("*************************************\n");
    }
}
