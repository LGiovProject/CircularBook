package com.ispw.circularbook.view.cli;

import com.ispw.circularbook.engineering.utils.MessageCLISupport;

import java.util.Scanner;

public class CLISearchBookTakeView {

    public String start()
    {
        Scanner scanner = new Scanner(System.in);
        MessageCLISupport.delimiterMessage();
        System.out.println("\nControlla la lista dei libri disponibili sopra\n");
        System.out.println("Inserisci il numero dell'id del libro che vuoi prendere\n");
        System.out.println("inserisci un valore negativo per tornare indietro\n");
        return scanner.nextLine();
    }
}
