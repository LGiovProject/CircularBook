package com.ispw.circularbook.view.cli;

import com.ispw.circularbook.controller.graficcontroller.cli.CLISearchBookController;
import com.ispw.circularbook.engineering.bean.BookBean;

import java.util.Scanner;

public class CLISearchBookView {

    private final Scanner scanner = new Scanner(System.in);

    CLISearchBookController cliSearchBookController;

    public CLISearchBookView(CLISearchBookController cliSearchBookController){this.cliSearchBookController = cliSearchBookController;}

    public int start()
    {
        System.out.println("Inizia la ricerca di un libro \n");
        System.out.println("Inserisci i parametri per la ricerca del libro\n");
        System.out.println("Se non metti alcun parametro la ricerca mostrerà tutti i risultati disponibili\n");
        System.out.println("1)Inserisci Titolo\n");
        System.out.println("2)Inserisci Argomento\n");
        System.out.println("3)Inserisci Autore\n");
        System.out.println("4)Effetua ricerca\n");
        System.out.println("5)go back\n");
        return scanner.nextInt();
    }

    public String insertTitle()
    {
        System.out.println("Inserisci il titolo per il quale vuoi effettuare la ricerca\n");
        System.out.println("Se non viene inserito nulla, verrà fatta la ricerca su ogni titolo\n");
        System.out.println("Titolo ");
        return scanner.nextLine();
    }

    public String insertArgument()
    {
        System.out.println("Inserisci l'argomento per cui vuoi effettuare la ricerca");
        System.out.println("Se non viene inserito nulla, verrà fatta la ricerca per ogni argomento");
        System.out.println("Argomento: ");
        return scanner.nextLine();
    }

    public String insertAuthor()
    {
        System.out.println("Inserisci l'autore per cui va effettuare la ricerca");
        System.out.println("Se non viene inserito nulla verrà fatto la ricerca per ogni autore");
        return scanner.nextLine();
    }

    public void showBook(BookBean bookBean)
    {
        System.out.println("*************************************\n");
        System.out.println("Titolo :"+bookBean.getTitolo());
        System.out.println("Username :"+bookBean.getUsername());
        System.out.println("Tipologia :"+bookBean.getTypeOfDisponibilityString());
        System.out.println("Autore :"+bookBean.getAutore());
        System.out.println("Argomento :"+bookBean.getArgomento());
        System.out.println("Numero pagine :"+bookBean.getNPagine());
        System.out.println("Commento :"+bookBean.getCommento());
        System.out.println("*************************************\n");
    }
}
