package com.ispw.circularbook.view.cli;

import java.util.Scanner;

public class CLISearchBookTakeView {

    public String start()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Controlla la lista dei libri disponibili sopra\n");
        System.out.println("Inserisci il numero dell'id del libro che vuoi prendere\n");
        System.out.println("inserisci back per tornare indietro\n");
        return scanner.nextLine();
    }
}
