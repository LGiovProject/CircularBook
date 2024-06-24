package com.ispw.circularbook.view.cli;

import com.ispw.circularbook.controller.graficcontroller.cli.CLISearchBookController;
import com.ispw.circularbook.engineering.bean.SearchBookBean;
import com.ispw.circularbook.engineering.utils.MessageCLISupport;

import java.util.Scanner;

public class CLISearchBookView {

    private final Scanner scanner = new Scanner(System.in);

    public int start(SearchBookBean searchBookBean)
    {
        System.out.println("\nInizia la ricerca di un libro \n");
        System.out.println("Inserisci i parametri per la ricerca del libro\n");
        System.out.println("Se non metti alcun parametro la ricerca mostrerà tutti i risultati disponibili\n");
        System.out.println("1)Inserisci Titolo    ** parametro di ricerca attuale: "+searchBookBean.getTitle()+" **\n");
        System.out.println("2)Inserisci Argomento ** parametro di ricerca attuale: "+searchBookBean.getArgument()+" **\n");
        System.out.println("3)Inserisci Autore    ** parametro di ricerca attuale: "+searchBookBean.getAuthor()+" **\n");
        System.out.println("4)Effetua ricerca\n");
        System.out.println("5)Pulisci i parametri\n");
        System.out.println("6)go back\n");
        return Integer.parseInt(scanner.nextLine());
    }

    public String insertTitle()
    {
        MessageCLISupport.delimiterMessage();
        System.out.println("\nInserisci il titolo per il quale vuoi effettuare la ricerca\n");
        System.out.println("Se non viene inserito nulla, verrà fatta la ricerca su ogni titolo\n");
        System.out.println("Titolo ");
        return scanner.nextLine();
    }

    public String insertArgument()
    {
        MessageCLISupport.delimiterMessage();
        System.out.println("\nInserisci l'argomento per cui vuoi effettuare la ricerca\n");
        System.out.println("Se non viene inserito nulla, verrà fatta la ricerca per ogni argomento\n");
        System.out.println("Argomento: ");
        return scanner.nextLine();
    }

    public String insertAuthor()
    {
        MessageCLISupport.delimiterMessage();
        System.out.println("\nInserisci l'autore per cui va effettuare la ricerca\n");
        System.out.println("Se non viene inserito nulla verrà fatto la ricerca per ogni autore\n");
        System.out.println("Autore: ");
        return scanner.nextLine();
    }

}
