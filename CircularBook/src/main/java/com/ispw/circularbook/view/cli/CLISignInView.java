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
        System.out.println("Scegli se registrarti come Utente o come Libreria\n");
        System.out.println("1)Come Utente\n");
        System.out.println("2)Come Libreria\n");
        System.out.println("3)Torna al Login\n");
        return Integer.parseInt(scanner.nextLine());
    }

}
