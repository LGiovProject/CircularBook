package com.ispw.circularbook.engineering.decorator;

import java.util.Scanner;

public class SignInEmailDecorator extends Decorator{

//    public SignInEmailDecorator(SignInComponent signInComponent) {
//        super(signInComponent);
//    }


    @Override
    public String getInfo() {
        System.out.println("Inserisci la email");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
