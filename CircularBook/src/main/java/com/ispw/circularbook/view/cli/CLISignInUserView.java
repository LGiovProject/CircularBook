package com.ispw.circularbook.view.cli;

import java.util.Scanner;

public class CLISignInUserView {

    private final Scanner scanner = new Scanner(System.in);

    public void startSignInU(){
        System.out.println("*******************Sign In as USER*********************\n");
    }

    public String getEmailSignIn()
    {
        System.out.println("Inserisci email\n");
        return scanner.nextLine();
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

    public String getNome(){
        System.out.println("Inserisci nome\n");
        return scanner.nextLine();
    }

    public String getCognome(){
        System.out.println("Inserisci cognome\n");
        return scanner.nextLine();
    }

    public String getUsername()
    {
        System.out.println("Inserisci username\n");
        return scanner.nextLine();
    }

}
