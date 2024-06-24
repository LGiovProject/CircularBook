package com.ispw.circularbook.view.cli;

import com.ispw.circularbook.engineering.utils.MessageCLISupport;

import java.util.Scanner;

public class CLIManageMySalesView {

    private final Scanner scanner = new Scanner(System.in);

    public int start()
    {
        System.out.println("\n************ Sales Insert ************\n");
        System.out.println("1)Modify Sales\n");
        System.out.println("2)Delete Sales\n");
        System.out.println("3)Torna indietro\n");
        return Integer.parseInt(scanner.nextLine());
    }

    public int modifySales()
    {
        MessageCLISupport.delimiterMessage();
        System.out.println("\nInserisci l'id del Sales da modificare\n");
        System.out.println("Per annullare inserisci -1\n");
        return Integer.parseInt(scanner.nextLine());
    }

    public int deleteSales()
    {
        MessageCLISupport.delimiterMessage();
        System.out.println("\nInserisci l'id del Sales da cancellare\n");
        System.out.println("Per annullare inserisci -1\n");
        return Integer.parseInt(scanner.nextLine());
    }
}
