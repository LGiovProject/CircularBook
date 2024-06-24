package com.ispw.circularbook.view.cli;

import java.util.Scanner;

public class CLIManageMyAvailableBookView {

    private final Scanner scanner = new Scanner(System.in);

    public int start()
    {

        System.out.println("\n************** Personal Book Available **************\n");
        System.out.println("1)Modify book info\n");
        System.out.println("2)Deleted book from list\n");
        System.out.println("3)go back\n");
        return scanner.nextInt();
    }

    public int modifyBook()
    {
        System.out.println("\nInsert book id to modify\n");
        System.out.println("Insert -1 per tornare indietro\n");
        return scanner.nextInt();
    }

    public int deleteBook()
    {
        System.out.println("\nInsert book id to delete\n");
        System.out.println("Inserisci -1 per tornare indietro\n");
        return scanner.nextInt();
    }


}
