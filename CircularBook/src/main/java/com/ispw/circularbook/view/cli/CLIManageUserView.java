package com.ispw.circularbook.view.cli;

import java.util.Scanner;

public class CLIManageUserView {

    private final Scanner scanner = new Scanner(System.in);

    public int start()
    {
        System.out.println("\n**************Manage User View**************\n");
        System.out.println("1)For view Personal Book Available\n");
        System.out.println("2)For view Books took\n");
        System.out.println("3)For view Personal book took\n");
        System.out.println("4)Back to homepage\n");
        return Integer.parseInt(scanner.nextLine());
    }





}
