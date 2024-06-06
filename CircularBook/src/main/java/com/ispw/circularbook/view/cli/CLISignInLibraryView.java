package com.ispw.circularbook.view.cli;

import java.util.Scanner;

public class CLISignInLibraryView {

    private final Scanner scanner = new Scanner(System.in);

    public void startSignInL()
    {
        System.out.println("*******************Sign In as LIBRARY******************\n");
    }

    public String getEmailSignIn()
    {
        System.out.println("Inserisci email\n");
        return  scanner.nextLine();
    }

    public String getPasswordSignIn() {
        System.out.println("Inserisci password\n");
        return scanner.nextLine();
    }

    public String getCittaSignIn()
    {
        System.out.println("Inserisci la citta, capolugo di regione , con l'iniziale maiuscola");
        return scanner.nextLine();
    }

    public String getNomeLibreria()
    {
        System.out.println("Inserisci nome libreria\n");
        return scanner.nextLine();
    }

    public String getNumeroTelefono()
    {
        System.out.println("Inserisci il numero di telefono della libreria\n");
        return scanner.nextLine();
    }

    public String getVia()
    {
        System.out.println("Inserisci la via della libreria\n");
        return scanner.nextLine();
    }

    public void closeScanner()
    {
        scanner.close();
    }
}
