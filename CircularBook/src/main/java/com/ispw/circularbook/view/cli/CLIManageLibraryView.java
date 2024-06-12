package com.ispw.circularbook.view.cli;

import java.util.Scanner;

public class CLIManageLibraryView {

    private final Scanner scanner = new Scanner(System.in);

    public String start()
    {
        System.out.println("**************Manage User View**************\n");
        System.out.println("1)For view Personal Book Available\n");
        System.out.println("2)For view sales inserted\n");
        System.out.println("3)For view Personal book took\n");
        System.out.println("4)Back to homepage\n");
        return scanner.nextLine();
    }
}
