package com.ispw.circularbook.view.cli;

import java.util.Scanner;

public class CLISignInView {

    public void signIn()
    {
        System.out.println("*******************Sign In******************\n");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci email\n");
        String email=scanner.nextLine();
        System.out.println("Inserisci password\n");
        String password = scanner.nextLine();
        System.out.println("Inserisci di nuovo la password\n");
        String repassword = scanner.nextLine();
        System.out.println("Inserisci nome\n");
        String nome= scanner.nextLine();
        System.out.println("Inserisci cognome");
        String cognome= scanner.nextLine();
        System.out.println("Inserisci username");
        String username= scanner.nextLine();
        System.out.println("Inserisci città");
        String città = scanner.nextLine();


    }
}
