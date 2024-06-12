package com.ispw.circularbook.view.cli;

import java.util.Scanner;

public class CLIHomepageUserView {

    public int start()
    {
        System.out.println("\n*****************USER Homepage*****************\n");
        System.out.println("*Insert:\n");
        System.out.println("1)Insert new Book \n");
        System.out.println("2)Search Book\n");
        System.out.println("3)Search Sales\n");
        System.out.println("4)Manage own system\n");
        System.out.println("5)Setting\n");
        System.out.println("6)Logout\n");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }
}
