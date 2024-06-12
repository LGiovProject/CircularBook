package com.ispw.circularbook.view.cli;

import java.util.Scanner;

public class CLIInsertBookView {

    Scanner scanner = new Scanner(System.in);

    public int start()
    {
        System.out.println("***************Insert new Book****************\n");
        System.out.println("1)Inizia ad inserire i dati\n");
        System.out.println("2)Torna indietro\n");
        return Integer.parseInt(scanner.nextLine());

    }

    public int finish()
    {
        System.out.println("***************Insert new Book****************\n");
        System.out.println("1)Registra i dati inviati\n");
        System.out.println("2)Torna indietro\n");
        return Integer.parseInt(scanner.nextLine());
    }

    public String insertTitle()
    {
        System.out.println("Insert title\n");
        System.out.println("Inserisci 10 per tornare indietro\n");
        return scanner.nextLine();
    }

    public String insertAuthor()
    {
        System.out.println("Insert Author\n");
        System.out.println("Inserisci 10 per tornare indietro\n");
        return scanner.nextLine();
    }

    public String insertArgument()
    {
        System.out.println("Insert Argument\n");
        System.out.println("Inserisci 10 per tornare indietro\n");
        return scanner.nextLine();
    }

    public int insertTypeOfBook()
    {
        System.out.println("Insert TypeOfBook\n");
        System.out.println("1 for lend Book 2 for a gift book\n");
        System.out.println("Inserisci 10 per tornare indietro\n");

        return Integer.parseInt(scanner.nextLine());
    }

    public int insertNPage()
    {
        System.out.println("Insert number of book page digit only number\n");
        System.out.println("Inserisci 10 per tornare indietro\n");
        return Integer.parseInt(scanner.nextLine());
    }

    public String insertComment()
    {
        System.out.println("Insert a description for a Book\n");
        System.out.println("Inserisci 10 per tornare indietro\n");
        return scanner.nextLine();
    }
}
