package com.ispw.circularbook.view.cli;

import java.util.Scanner;

public class CLIInsertSalesView {

    public Scanner scanner = new Scanner(System.in);

    public int start()
    {
        System.out.println("**********************Inserisci  Sales**********************\n");
        System.out.println("1)Per iniziare a immettere i dati\n");
        System.out.println("2)Per tornare indietro\n");
        return Integer.parseInt(scanner.nextLine());
    }

    public int finish()
    {
        System.out.println("Finiti i dati da inserire\n");
        System.out.println("1)per registrare i dati\n");
        System.out.println("2)per tornare indietro\n");
        return Integer.parseInt(scanner.nextLine());
    }

    public String insertTitle()
    {
        System.out.println("Inserisci Titolo: \n");
        System.out.println("Inserisci 10 per tornare indietro\n");
        return scanner.nextLine();
    }

    public int insertTypeOfSales()
    {
        System.out.println("Inserisci tipo di sales 1 Promozione o 2 Evento\n");
        System.out.println("Inserisci 10 per tornare indietro\n");
        return Integer.parseInt(scanner.nextLine());
    }

    public String insertDescription()
    {
        System.out.println("Inserisci la descrizione\n");
        System.out.println("Inserisci 10 per tornare indietro\n");
        return scanner.nextLine();
    }

    public String insertDateStart()
    {
        System.out.println("Inserisci la data d'inizio\n");
        System.out.println("Inserisci 10 per tornare indietro\n");
        return scanner.nextLine();
    }

    public String insertDateFinish()
    {
        System.out.println("Inserisci la data finale\n");
        System.out.println("Inserisci 10 per tornare indietro\n");
        return scanner.nextLine();
    }


}
