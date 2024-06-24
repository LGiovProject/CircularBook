package com.ispw.circularbook.view.cli;

import com.ispw.circularbook.engineering.utils.MessageCLISupport;

import java.util.Scanner;

public class CLISignInUserView {

    private final Scanner scanner = new Scanner(System.in);

    public void startSignInU(){
        System.out.println("\n*******************Sign In as USER*********************\n");
    }

    public String getEmailSignIn()
    {
        MessageCLISupport.delimiterMessage();
        MessageCLISupport.campObligatoryMessage();
        System.out.println("\nInserisci email\n");
        MessageCLISupport.campObligatoryMessage();
        return scanner.nextLine();
    }

    public String getPasswordSignIn() {
        MessageCLISupport.delimiterMessage();
        MessageCLISupport.campObligatoryMessage();
        System.out.println("\nInserisci password\n");
        MessageCLISupport.campObligatoryMessage();
        return scanner.nextLine();
    }

    public String getCittaSignIn()
    {
        MessageCLISupport.delimiterMessage();
        MessageCLISupport.campObligatoryMessage();
        System.out.println("\nInserisci la citta, capolugo di regione , con l'iniziale maiuscola\n");
        MessageCLISupport.campObligatoryMessage();
        return scanner.nextLine();
    }

    public String getNome(){
        MessageCLISupport.delimiterMessage();
        System.out.println("\nInserisci nome\n");
        return scanner.nextLine();
    }

    public String getCognome(){
        MessageCLISupport.delimiterMessage();
        System.out.println("\nInserisci cognome\n");
        return scanner.nextLine();
    }

    public String getUsername()
    {
        MessageCLISupport.delimiterMessage();
        System.out.println("\nInserisci username\n");
        return scanner.nextLine();
    }

}
