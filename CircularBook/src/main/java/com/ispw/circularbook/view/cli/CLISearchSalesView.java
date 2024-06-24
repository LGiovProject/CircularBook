package com.ispw.circularbook.view.cli;

import com.ispw.circularbook.controller.graficcontroller.cli.CLISearchSalesController;
import com.ispw.circularbook.engineering.bean.SalesBean;
import com.ispw.circularbook.engineering.bean.SearchSalesBean;
import com.ispw.circularbook.engineering.utils.MessageCLISupport;

import java.util.List;
import java.util.Scanner;

public class CLISearchSalesView {

    CLISearchSalesController cliSearchSalesController;

    public CLISearchSalesView(CLISearchSalesController cliSearchSalesController) {
        this.cliSearchSalesController = cliSearchSalesController;
    }

    private final Scanner scanner = new Scanner(System.in);

    public int start(SearchSalesBean searchSalesBean)
    {
        System.out.println("\n***********************Search Sales*************************\n");
        System.out.println("Inserisci i parametri per la ricerca\n");
        System.out.println("Se non inserisci parametri la ricerca mostrerà tutti i risultati disponibili\n");
        System.out.println("1)Nome Libreria ** parametro di ricerca attuale: "+searchSalesBean.getNameLib()+" **\n");
        System.out.println("2)Mese in cui effettuare la ricerca ** parametro di ricerca attuale: "+searchSalesBean.getMonth()+" **\n");
        System.out.println("3)Tipologia di inserzione ** parametro di ricerca attuale: "+searchSalesBean.getTypeOfSales()+" **\n");
        System.out.println("4)Effetua ricerca\n");
        System.out.println("5)Azzera i parametri\n");
        System.out.println("6)go back\n");
        return Integer.parseInt(scanner.nextLine());
    }

    public String insertLibraryName()
    {
        MessageCLISupport.delimiterMessage();
        System.out.println("\nInserisci il nome di una libreria per la quale stai cercando inserzioni\n");
        System.out.println("Non inserire nulla per effettuare la ricerca tra tutte le librerie\n");
        System.out.println("Nome Libreria: ");
        return scanner.nextLine();
    }

    public String insertMonth() {
        System.out.println("\nInserisci il nome del mese in cui vuoi effettuare la riceca \n");
        System.out.println("Non inserire niente per effettuare la ricerca su tutti i mesi \n");
        System.out.println("Il mese va inserito con la prima lettera maiuscola \"Jennuary\"\n");
        System.out.println("Nome mese: ");
        return scanner.nextLine();
    }

    public String insertTypologyInsertion()
    {
        System.out.println("\nInserisci la tipologia di inserzione\n");
        System.out.println("Possono essere del tipo \"Evento\" oppure \"Promozione\"\n");
        System.out.println("Non inserire niente per cercare tra entrambe le tipologie\n");
        System.out.println("Tipologia: ");
        return scanner.nextLine();
    }

}
