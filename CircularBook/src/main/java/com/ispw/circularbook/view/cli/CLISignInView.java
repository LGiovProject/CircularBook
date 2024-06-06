package com.ispw.circularbook.view.cli;

import com.ispw.circularbook.controller.graficcontroller.cli.CLISignInController;
import com.ispw.circularbook.engineering.bean.SignInBean;

import java.util.Scanner;

public class CLISignInView {

    private final Scanner scanner = new Scanner(System.in);

    private CLISignInController cliSignInController;

    public CLISignInView(CLISignInController cliSignInController){this.cliSignInController=cliSignInController;}


    public int SignIn()
    {
//        Scanner scanner = new Scanner(System.in);
        System.out.println("Scegli se registrarti come Utente o come Libreria\n");
        System.out.println("1)Come Utente\n");
        System.out.println("2)Come Libreria\n");
        System.out.println("3)Torna al Login\n");
        return scanner.nextInt();
    }

//    public void startSignInU(){
//        System.out.println("*******************Sign In as USER*********************\n");
//    }
//
//    public void startSignInL()
//    {
//        System.out.println("*******************Sign In as LIBRARY******************\n");
//    }
//
//    public void getInfoSignInU()
//    {
//        System.out.println("Inserisci nome\n");
//        String nome= scanner.nextLine();
//        System.out.println("Inserisci cognome\n");
//        String cognome= scanner.nextLine();
//        System.out.println("Inserisci username\n");
//        String username= scanner.nextLine();
//        scanner.close();
//        cliSignInController.setSignInUser(nome,cognome,username);
//    }
//
//    public void getInfoSingInL()
//    {
//        System.out.println("Inserisci nome libreria\n");
//        String nomeL= scanner.nextLine();
//        System.out.println("Inserisci il numero di telefono della libreria\n");
//        String telefono= scanner.nextLine();
//        System.out.println("Inserisci la via della libreria\n");
//        String via= scanner.nextLine();
//        scanner.close();
//        cliSignInController.setSignInLibrary(nomeL,telefono,via);
//    }
//
//    public String getEmailSignIn()
//    {
//        System.out.println("Inserisci email\n");
//        return  scanner.nextLine();
//    }
//
//    public String getPasswordSignIn() {
//        System.out.println("Inserisci password\n");
//        return scanner.nextLine();
//    }
//
//    public String getCittaSignIn()
//    {
//        System.out.println("Inserisci la citta, capolugo di regione , con l'iniziale maiuscola");
//        return scanner.nextLine();
//    }
}
