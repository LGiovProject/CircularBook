package com.ispw.circularbook.view.cli;

import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.utils.MessageCLISupport;

public class CLIShowBookView {

    public void showBookAvailable(BookBean bookBean)
    {
        MessageCLISupport.delimiterMessage();
        System.out.println("L'id del libro è :"+bookBean.getId());
        System.out.println("Titolo :"+bookBean.getTitolo());
        System.out.println("Username :"+bookBean.getUsername());
        System.out.println("Tipologia :"+bookBean.getTypeOfDisponibilityString());
        System.out.println("Autore :"+bookBean.getAutore());
        System.out.println("Argomento :"+bookBean.getArgomento());
        System.out.println("Numero pagine :"+bookBean.getNPagine());
        System.out.println("Commento :"+bookBean.getCommento());
        MessageCLISupport.delimiterMessage();
    }

    public void showMyBookAvailable(BookBean bookBean)
    {
        MessageCLISupport.delimiterMessage();
        System.out.println("L'id del libro è :"+bookBean.getId());
        System.out.println("Titolo :"+bookBean.getTitolo());
        System.out.println("Tipologia :"+bookBean.getTypeOfDisponibilityString());
        System.out.println("Autore :"+bookBean.getAutore());
        System.out.println("Argomento :"+bookBean.getArgomento());
        System.out.println("Numero pagine :"+bookBean.getNPagine());
        System.out.println("Commento :"+bookBean.getCommento());
        MessageCLISupport.delimiterMessage();
    }

    public void showBookITaked(BookBean bookBean)
    {
        MessageCLISupport.delimiterMessage();
        System.out.println("Titolo :"+bookBean.getTitolo());
        System.out.println("L'hai preso da :"+bookBean.getUsername());
        System.out.println("Tipologia :"+bookBean.getTypeOfDisponibilityString());
        System.out.println("Autore :"+bookBean.getAutore());
        System.out.println("Argomento :"+bookBean.getArgomento());
        System.out.println("Numero pagine :"+bookBean.getNPagine());
        System.out.println("Commento :"+bookBean.getCommento());
        System.out.println(bookBean.getTypeOfDisponibility()==1?"Giorni rimanenti :"+bookBean.getDaysRemaing():"preso in regalo");
        MessageCLISupport.delimiterMessage();
    }

    public void showBookGived(BookBean bookBean)
    {
        MessageCLISupport.delimiterMessage();
        System.out.println("Titolo :"+bookBean.getTitolo());
        System.out.println("Preso da :"+bookBean.getUsername());
        System.out.println("Tipologia :"+bookBean.getTypeOfDisponibilityString());
        System.out.println("Autore :"+bookBean.getAutore());
        System.out.println("Argomento :"+bookBean.getArgomento());
        System.out.println("Numero pagine :"+bookBean.getNPagine());
        System.out.println("Commento :"+bookBean.getCommento());
        System.out.println(bookBean.getTypeOfDisponibility()==1?"Giorni rimanenti :"+bookBean.getDaysRemaing():"E' stato regalato");
        MessageCLISupport.delimiterMessage();
    }
}
