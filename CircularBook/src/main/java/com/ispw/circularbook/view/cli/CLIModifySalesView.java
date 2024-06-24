package com.ispw.circularbook.view.cli;

import com.ispw.circularbook.engineering.bean.SalesBean;
import com.ispw.circularbook.engineering.utils.MessageCLISupport;

import java.util.Scanner;

public class CLIModifySalesView {

    private final Scanner scanner = new Scanner(System.in);

    public int start(SalesBean salesBean)
    {
        System.out.println("\nScegli quali dati modificare\n");
        System.out.println("1)Titolo ** Attualmente :"+salesBean.getTitlePromotion()+" **\n");
        System.out.println("2)Tipologia ** Attualmente :"+salesBean.getTypeOfSalesString()+" **\n");
        System.out.println("3)Data Inizio ** Attualmente :"+salesBean.getDateStart()+" **\n");
        System.out.println("4)Data Fine ** Attualmente :"+salesBean.getDateFinish()+" **\n");
        System.out.println("5)Commento ** Attualmente :"+salesBean.getDescription()+" **\n");
        System.out.println("6)Conferma modifiche\n");
        System.out.println("7)Torna indietro\n");
        return Integer.parseInt(scanner.nextLine());
    }

    public String insertTitle()
    {
        MessageCLISupport.delimiterMessage();
        System.out.println("Inserisci Titolo: \n");
        System.out.println("Inserisci -1 per tornare indietro\n");
        return scanner.nextLine();
    }

    public int insertTypeOfSales()
    {
        MessageCLISupport.delimiterMessage();
        System.out.println("Inserisci tipo di sales 1 Promozione o 2 Evento\n");
        System.out.println("Inserisci -1 per tornare indietro\n");
        return Integer.parseInt(scanner.nextLine());
    }

    public String insertDescription()
    {
        MessageCLISupport.delimiterMessage();
        System.out.println("Inserisci la descrizione\n");
        System.out.println("Inserisci -1 per tornare indietro\n");
        return scanner.nextLine();
    }

    public String insertDateStart()
    {
        MessageCLISupport.delimiterMessage();
        System.out.println("Inserisci la data d'inizio\n");
        System.out.println("Usa il formato yyyy-mm-dd\n");
        System.out.println("Inserisci -1 per tornare indietro\n");
        return scanner.nextLine();
    }

    public String insertDateFinish()
    {
        MessageCLISupport.delimiterMessage();
        System.out.println("Inserisci la data finale\n");
        System.out.println("Usa il formato yyyy-mm-dd\n");
        System.out.println("Inserisci -1 per tornare indietro\n");
        return scanner.nextLine();
    }
}
