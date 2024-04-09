package com.ispw.circularbook.view.cli;

import com.ispw.circularbook.controller.graficcontroller.cli.CLILoginController;
import com.ispw.circularbook.engineering.exception.WrongEmailFormattException;

import java.io.IOException;
import java.util.Scanner;

public class CLILoginView {

    private CLILoginController cliLoginController;

    public CLILoginView(CLILoginController cliLoginController)
    {
        this.cliLoginController = cliLoginController;
    }

    public int start()
    {
        System.out.println("\n***************Login***************\n");
        System.out.println("*Insert:\n");
        System.out.println("1)For Login\n");
        System.out.println("2)Forget password\n");
        System.out.println("3)Sign in\n");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void getCredentials() throws WrongEmailFormattException, IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert username\n");
        String username = scanner.nextLine();
        System.out.println("Insert password\n");
        String password = scanner.nextLine();
        cliLoginController.checkCredential(username,password);

    }

    public void selectSignIn()
    {
        System.out.println("Insert:\n");
        System.out.println("1)For sign in as user\n");
        System.out.println("2)For sign in as library\n");
    }
}
