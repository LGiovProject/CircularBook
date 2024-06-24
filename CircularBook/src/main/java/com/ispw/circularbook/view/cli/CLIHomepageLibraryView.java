package com.ispw.circularbook.view.cli;

import java.util.Scanner;

public class CLIHomepageLibraryView {

    public int start()
    {
        System.out.println("\n*****************LIBRARY Homepage*****************\n");
        System.out.println("*Insert:\n");
        System.out.println("1)Insert new Book\n");
        System.out.println("2)Insert Sales\n");
        System.out.println("3)Manage own system\n");
        System.out.println("4)Setting\n");
        System.out.println("5)Logout\n");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }
}
