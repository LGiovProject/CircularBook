package com.ispw.circularbook.view.cli;

import com.ispw.circularbook.engineering.utils.MessageCLISupport;

import java.util.Scanner;

public class CLIInsertSalesView {

    public Scanner scanner = new Scanner(System.in);

    public int start()
    {
        System.out.println("\n**********************Inserisci  Sales**********************\n");
        System.out.println("1)Per iniziare a immettere i dati\n");
        System.out.println("2)Per tornare indietro\n");
        return Integer.parseInt(scanner.nextLine());
    }

    public int finish()
    {
        System.out.println("\n********************** Finiti i dati da inserire **********************\n");
        System.out.println("1)per registrare i dati\n");
        System.out.println("2)per tornare indietro\n");
        return Integer.parseInt(scanner.nextLine());
    }

    public String insertTitle()
    {
        System.out.println("\nInserisci Titolo: \n");
        MessageCLISupport.backValueMessage();
        return scanner.nextLine();
    }

    public int insertTypeOfSales()
    {
        System.out.println("\nInserisci tipo di sales 1 Promozione o 2 Evento\n");
        MessageCLISupport.backValueMessage();
        return Integer.parseInt(scanner.nextLine());
    }

    public String insertDescription()
    {
        System.out.println("\nInserisci la descrizione\n");
        MessageCLISupport.backValueMessage();
        return scanner.nextLine();
    }

    public String insertDateStart()
    {
        System.out.println("\nInserisci la data d'inizio\n");
        System.out.println("Usa il formato yyyy-mm-dd\n");
        MessageCLISupport.backValueMessage();
        return scanner.nextLine();
    }

    public String insertDateFinish()
    {
        System.out.println("\nInserisci la data finale\n");
        System.out.println("Usa il formato yyyy-mm-dd\n");
        MessageCLISupport.backValueMessage();
        return scanner.nextLine();
    }


}
