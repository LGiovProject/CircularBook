package com.ispw.circularbook.view.cli;

import com.ispw.circularbook.controller.graficcontroller.cli.CLILoginController;
import com.ispw.circularbook.engineering.exception.WrongEmailFormattException;
import com.ispw.circularbook.engineering.utils.MessageCLISupport;

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
        return Integer.parseInt(scanner.nextLine());
    }

    public String getEmail(){
        MessageCLISupport.delimiterMessage();
        System.out.println("\nInsert Email\n");
        return scanner.nextLine();
    }

    public String getPassword(){
        MessageCLISupport.delimiterMessage();
        System.out.println("\nInsert Password\n");
        return scanner.nextLine();
    }


}
