package com.ispw.circularbook.engineering.decorator;

import java.util.Scanner;

public class SignInPasswordDecorator {

    public String getInfo()
    {
        System.out.println("Inserisci la password");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
