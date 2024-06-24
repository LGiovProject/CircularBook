package com.ispw.circularbook.view.cli;

import com.ispw.circularbook.engineering.utils.MessageCLISupport;
import com.ispw.circularbook.engineering.utils.MessageSupport;

import java.util.Scanner;

public class CLIInsertBookView {

    Scanner scanner = new Scanner(System.in);

    public int start()
    {
        MessageCLISupport.delimiterMessage();
        System.out.println("***************Insert new Book****************\n");
        System.out.println("1)Inizia ad inserire i dati\n");
        System.out.println("2)Torna indietro\n");
        return Integer.parseInt(scanner.nextLine());

    }

    public int finish()
    {
        MessageCLISupport.delimiterMessage();
        System.out.println("***************Insert new Book****************\n");
        System.out.println("1)Registra i dati inviati\n");
        System.out.println("2)Torna indietro\n");
        return Integer.parseInt(scanner.nextLine());
    }

    public String insertTitle()
    {
        MessageCLISupport.delimiterMessage();
        System.out.println("Insert title\n");
        MessageCLISupport.backValueMessage();
        return scanner.nextLine();
    }

    public String insertAuthor()
    {
        MessageCLISupport.delimiterMessage();
        System.out.println("Insert Author\n");
        MessageCLISupport.backValueMessage();
        return scanner.nextLine();
    }

    public String insertArgument()
    {
        MessageCLISupport.delimiterMessage();
        System.out.println("Insert Argument\n");
        MessageCLISupport.backValueMessage();
        return scanner.nextLine();
    }

    public int insertTypeOfBook()
    {
        MessageCLISupport.delimiterMessage();
        System.out.println("Insert TypeOfBook\n");
        System.out.println("1 for lend Book 2 for a gift book\n");
        MessageCLISupport.backValueMessage();
        return Integer.parseInt(scanner.nextLine());
    }

    public int insertNPage()
    {
        MessageCLISupport.delimiterMessage();
        System.out.println("Insert number of book page digit only number\n");
        MessageCLISupport.backValueMessage();
        return Integer.parseInt(scanner.nextLine());
    }

    public String insertComment()
    {
        MessageCLISupport.delimiterMessage();
        System.out.println("Insert a description for a Book\n");
        MessageCLISupport.backValueMessage();
        return scanner.nextLine();
    }
}
