package com.ispw.circularbook.view.cli;

import com.ispw.circularbook.engineering.utils.MessageCLISupport;

import java.util.Scanner;

public class CLISignInLibraryView {

    private final Scanner scanner = new Scanner(System.in);

    public void startSignInL()
    {
        System.out.println("\n*******************Sign In as LIBRARY******************\n");
    }

    public String getEmailSignIn()
    {
        MessageCLISupport.delimiterMessage();
        MessageCLISupport.campObligatoryMessage();
        System.out.println("\nInserisci email\n");
        MessageCLISupport.campObligatoryMessage();
        MessageCLISupport.backValueMessage();
        return  scanner.nextLine();
    }

    public String getPasswordSignIn() {
        MessageCLISupport.delimiterMessage();
        MessageCLISupport.campObligatoryMessage();
        System.out.println("\nInserisci password\n");
        MessageCLISupport.campObligatoryMessage();
        MessageCLISupport.backValueMessage();
        return scanner.nextLine();
    }

    public String getCittaSignIn()
    {
        MessageCLISupport.delimiterMessage();
        MessageCLISupport.campObligatoryMessage();
        System.out.println("\nInserisci la citta, capolugo di regione , con l'iniziale maiuscola\n");
        MessageCLISupport.campObligatoryMessage();
        MessageCLISupport.backValueMessage();
        return scanner.nextLine();
    }

    public String getNomeLibreria()
    {
        MessageCLISupport.delimiterMessage();
        System.out.println("\nInserisci nome libreria\n");
        MessageCLISupport.backValueMessage();
        return scanner.nextLine();
    }

    public String getNumeroTelefono()
    {
        MessageCLISupport.delimiterMessage();
        System.out.println("\nInserisci il numero di telefono della libreria\n");
        MessageCLISupport.backValueMessage();
        return scanner.nextLine();
    }

    public String getVia()
    {
        MessageCLISupport.delimiterMessage();
        System.out.println("\nInserisci la via della libreria\n");
        MessageCLISupport.backValueMessage();
        return scanner.nextLine();
    }

}
