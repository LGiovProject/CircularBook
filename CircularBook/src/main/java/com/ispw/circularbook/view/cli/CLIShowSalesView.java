package com.ispw.circularbook.view.cli;

import com.ispw.circularbook.engineering.bean.SalesBean;
import com.ispw.circularbook.engineering.utils.MessageCLISupport;

public class CLIShowSalesView {

    public void showInsertion(SalesBean salesBean)
    {
        MessageCLISupport.delimiterMessage();
        System.out.println("Titolo :"+salesBean.getTitlePromotion());
        System.out.println("Tipologia :"+salesBean.getTypeOfSalesString());
        System.out.println("Libreria: "+salesBean.getNameLib());
        System.out.println("Data inizio: "+salesBean.getDateStart());
        System.out.println("Data fine: "+salesBean.getDateFinish());
        System.out.println("Descrizione :"+salesBean.getDescription());
        MessageCLISupport.delimiterMessage();
    }
}
