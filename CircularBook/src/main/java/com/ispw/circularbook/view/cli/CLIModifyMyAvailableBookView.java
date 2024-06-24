package com.ispw.circularbook.view.cli;

import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.utils.MessageCLISupport;

import java.util.Scanner;

public class CLIModifyMyAvailableBookView {

    private final Scanner scanner = new Scanner(System.in);


    public int start(BookBean bookBean)
    {
        System.out.println("Scegli quale informazione modificare\n");
        System.out.println("1)Titolo ** Attualmente: "+bookBean.getTitolo()+" **\n");
        System.out.println("2)Autore ** Attualmente: "+bookBean.getAutore()+" **\n");
        System.out.println("3)Argomento ** Attualmente: "+bookBean.getArgomento()+" **\n");
        System.out.println("4)Tipo di inserimento ** Attualmente: "+bookBean.getTypeOfDisponibilityString()+" ** \n");
        System.out.println("5)Numero di pagine ** Attualmente: "+bookBean.getNPagine()+" **\n");
        System.out.println("6)Commento ** Attualmente: "+bookBean.getCommento()+" **\n");
        System.out.println("7)Conferma modifiche\n");
        System.out.println("8)Torna indietro\n");
        return Integer.parseInt(scanner.nextLine());
    }


    public String insertTitle()
    {
        MessageCLISupport.delimiterMessage();
        System.out.println("Insert title\n");
        System.out.println("Inserisci 10 per tornare indietro\n");
        return scanner.nextLine();
    }

    public String insertAuthor()
    {
        MessageCLISupport.delimiterMessage();
        System.out.println("Insert Author\n");
        System.out.println("Inserisci 10 per tornare indietro\n");
        return scanner.nextLine();
    }

    public String insertArgument()
    {
        MessageCLISupport.delimiterMessage();
        System.out.println("Insert Argument\n");
        System.out.println("Inserisci 10 per tornare indietro\n");
        return scanner.nextLine();
    }

    public int insertTypeOfBook()
    {
        MessageCLISupport.delimiterMessage();
        System.out.println("Insert TypeOfBook\n");
        System.out.println("1 for lend Book 2 for a gift book\n");
        System.out.println("Inserisci 10 per tornare indietro\n");
        return Integer.parseInt(scanner.nextLine());
    }

    public int insertNPage()
    {
        MessageCLISupport.delimiterMessage();
        System.out.println("Insert number of book page digit only number\n");
        System.out.println("Inserisci 10 per tornare indietro\n");
        return Integer.parseInt(scanner.nextLine());
    }

    public String insertComment()
    {
        MessageCLISupport.delimiterMessage();
        System.out.println("Insert a description for a Book\n");
        System.out.println("Inserisci 10 per tornare indietro\n");
        return scanner.nextLine();
    }
}
