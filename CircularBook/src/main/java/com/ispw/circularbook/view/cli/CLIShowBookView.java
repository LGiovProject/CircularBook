package com.ispw.circularbook.view.cli;

import com.ispw.circularbook.engineering.bean.BookBean;

public class CLIShowBookView {

    public void showBookAvailable(BookBean bookBean)
    {
        System.out.println("\n*************************************\n");
        System.out.println("Titolo :"+bookBean.getTitolo());
        System.out.println("Username :"+bookBean.getUsername());
        System.out.println("Tipologia :"+bookBean.getTypeOfDisponibilityString());
        System.out.println("Autore :"+bookBean.getAutore());
        System.out.println("Argomento :"+bookBean.getArgomento());
        System.out.println("Numero pagine :"+bookBean.getNPagine());
        System.out.println("Commento :"+bookBean.getCommento());
        System.out.println("\n*************************************\n");
    }

    public void showMyBookAvailable(BookBean bookBean)
    {
        System.out.println("\n*************************************\n");
        System.out.println("Titolo :"+bookBean.getTitolo());
        System.out.println("Tipologia :"+bookBean.getTypeOfDisponibilityString());
        System.out.println("Autore :"+bookBean.getAutore());
        System.out.println("Argomento :"+bookBean.getArgomento());
        System.out.println("Numero pagine :"+bookBean.getNPagine());
        System.out.println("Commento :"+bookBean.getCommento());
        System.out.println("\n*************************************\n");
    }

    public void showBookITaked(BookBean bookBean)
    {
        System.out.println("\n*************************************\n");
        System.out.println("Titolo :"+bookBean.getTitolo());
        System.out.println("L'hai preso da :"+bookBean.getUsername());
        System.out.println("Tipologia :"+bookBean.getTypeOfDisponibilityString());
        System.out.println("Autore :"+bookBean.getAutore());
        System.out.println("Argomento :"+bookBean.getArgomento());
        System.out.println("Numero pagine :"+bookBean.getNPagine());
        System.out.println("Commento :"+bookBean.getCommento());
        System.out.println(bookBean.getTypeOfDisponibility()==1?"Giorni rimanenti :"+bookBean.getDaysRemaing():"preso in regalo");
        System.out.println("\n*************************************\n");
    }

    public void showBookGived(BookBean bookBean)
    {
        System.out.println("\n*************************************\n");
        System.out.println("Titolo :"+bookBean.getTitolo());
        System.out.println("Preso da :"+bookBean.getUsername());
        System.out.println("Tipologia :"+bookBean.getTypeOfDisponibilityString());
        System.out.println("Autore :"+bookBean.getAutore());
        System.out.println("Argomento :"+bookBean.getArgomento());
        System.out.println("Numero pagine :"+bookBean.getNPagine());
        System.out.println("Commento :"+bookBean.getCommento());
        System.out.println(bookBean.getTypeOfDisponibility()==1?"Giorni rimanenti :"+bookBean.getDaysRemaing():"E' stato regalato");
        System.out.println("\n*************************************\n");
    }
}
