package com.ispw.circularbook.view.cli;

import com.ispw.circularbook.controller.graficcontroller.cli.CLISearchSalesController;
import com.ispw.circularbook.engineering.bean.SalesBean;

import java.util.List;
import java.util.Scanner;

public class CLISearchSalesView {

    CLISearchSalesController cliSearchSalesController;

    public CLISearchSalesView(CLISearchSalesController cliSearchSalesController) {
        this.cliSearchSalesController = cliSearchSalesController;
    }

    private final Scanner scanner = new Scanner(System.in);

    public int start()
    {
        System.out.println("***********************Search Sales*************************\n");
        System.out.println("Inserisci i parametri per la ricerca\n");
        System.out.println("Se non inserisci parametri la ricerca mostrerà tutti i risultati disponibili\n");
        System.out.println("1)Nome Libreria:\n");
        System.out.println("2)Mese in cui effettuare la ricerca\n");
        System.out.println("3)Tipologia di inserzione\n");
        System.out.println("4)Effetua ricerca\n");
        System.out.println("5)go back\n");
        return Integer.parseInt(scanner.nextLine());
    }

    public String insertLibraryName()
    {
        System.out.println("Inserisci il nome di una libreria per la quale stai cercando inserzioni\n");
        System.out.println("Non inserire nulla per effettuare la ricerca tra tutte le librerie");
        System.out.println("Nome Libreria: ");
        return scanner.nextLine();
    }

    public String insertMonth() {
        System.out.println("Inserisci il nome del mese in cui vuoi effettuare la riceca \n");
        System.out.println("Non inserire niente per effettuare la ricerca su tutti i mesi \n");
        System.out.println("Il mese va inserito con la prima lettera maiuscola \"Jennuary\"\n");
        System.out.println("Nome mese: ");
        return scanner.nextLine();
    }

    public String insertTypologyInsertion()
    {
        System.out.println("Inserisci la tipologia di inserzione\n");
        System.out.println("Possono essere del tipo \"Evento\" oppure \"Promozione\"\n");
        System.out.println("Non inserire niente per cercare tra entrambe le tipologie\n");
        System.out.println("Tipologia: ");
        return scanner.nextLine();
    }

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

    public void check()
    {

    }

    public void errorMessage(String string)
    {
        System.out.println("\n"+string+"\n");
    }

}
