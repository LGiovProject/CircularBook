package com.ispw.circularbook.view.cli;

import com.ispw.circularbook.controller.graficcontroller.cli.CLILoginController;
import com.ispw.circularbook.engineering.exception.WrongEmailFormattException;

import java.io.IOException;
import java.util.Scanner;

public class CLILoginView {

    private CLILoginController cliLoginController;

    private final Scanner scanner = new Scanner(System.in);

    public CLILoginView(CLILoginController cliLoginController)
    {
        this.cliLoginController = cliLoginController;
    }

    public int start()
    {
        System.out.println("\n***************Login***************\n");
        System.out.println("*Insert:\n");
        System.out.println("1)For Login\n");
        System.out.println("2)Sign in\n");
        System.out.println("3)Guest Access\n");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public String getEmail(){
        System.out.println("Insert Email\n");
        return scanner.nextLine();
    }

    public String getPassword(){
        System.out.println("Insert Password\n");
        return scanner.nextLine();
    }


}
