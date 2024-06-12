package com.ispw.circularbook.view.cli;

import java.util.Scanner;

public class CLIManageMyAvailableBookView {

    private final Scanner scanner = new Scanner(System.in);

    public int start()
    {

        System.out.println("************** Personal Book Available **************");
        System.out.println("1)Modify book info");
        System.out.println("2)Deleted book from list");
        System.out.println("3)go back");
        return scanner.nextInt();
    }

    public int modifyBook()
    {
        System.out.println("Insert book id to modify");
        return scanner.nextInt();
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

    public int deleteBook()
    {
        System.out.println("Insert book id to delete");
        return scanner.nextInt();
    }


}
