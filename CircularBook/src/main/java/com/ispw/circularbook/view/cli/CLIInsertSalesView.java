package com.ispw.circularbook.view.cli;

import java.util.Scanner;

public class CLIInsertSalesView {

    public Scanner scanner = new Scanner(System.in);

    public void start()
    {
        System.out.println("**********************Inserisci  Sales**********************");
    }

    public String insertTitle()
    {
        System.out.println("Inserisci Titolo: ");
        return scanner.nextLine();
    }

    public int insertTypeOfSales()
    {
        System.out.println("Inserisci tipo di sales 1 Promozione o 2 Evento");
        return scanner.nextInt();
    }

    public String insertDescription()
    {
        System.out.println("Inserisci la descrizione");
        return scanner.nextLine();
    }

    public String insertDateStart()
    {
        System.out.println("Inserisci la data d'inizio");
        return scanner.nextLine();
    }

    public String insertDateFinish()
    {
        System.out.println("Inserisci la data finale");
        return scanner.nextLine();
    }
}
