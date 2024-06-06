package com.ispw.circularbook.view.cli;

import com.ispw.circularbook.controller.graficcontroller.cli.CLISettingLibraryController;
import com.ispw.circularbook.controller.graficcontroller.cli.CLISettingUserController;
import com.ispw.circularbook.engineering.bean.InfoBookBean;
import com.ispw.circularbook.engineering.bean.LibraryBean;
import com.ispw.circularbook.engineering.bean.UserBean;

import java.util.Scanner;

public class CLISettingLibraryView {

    CLISettingLibraryController cliSettingLibraryController;

    final Scanner scanner = new Scanner(System.in);

    public CLISettingLibraryView(CLISettingLibraryController cliSettingLibraryController){this.cliSettingLibraryController = cliSettingLibraryController;}


    public int start()
    {
        System.out.println("*************************Library Setting***********************");
        System.out.println("1)Modify personal info");
        System.out.println("2)Show persona info");
        System.out.println("3)Show circular book use");
        System.out.println("4)go back");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void showInfoCircularBook(InfoBookBean infoBookBean)
    {
        System.out.println(infoBookBean.getRegisterBook()+" registrati\n");
        System.out.println(infoBookBean.getLendedBook()+" messi in prestito\n");
        System.out.println(infoBookBean.getGiftedBook()+" messi in regalo\n");
        System.out.println(infoBookBean.getSalesInsert()+" inserzioni inserite\n");
    }

    public void showPersonalInfo(LibraryBean libraryBean)
    {
        System.out.println("Nome: "+libraryBean.getNomeLib()+"\n");
        System.out.println("via: "+libraryBean.getVia()+"\n");
        System.out.println("nTel: "+libraryBean.getTelNumber()+"\n");
        System.out.println("Citta: "+libraryBean.getCity()+"\n");
    }

    public String choseCamp()
    {
        System.out.println("Scegli il campo che vuoi modificare\n");
        System.out.println("Inserisci None per annullare\n");
        return scanner.nextLine();

    }

    public String setCamp()
    {
        System.out.println("Inserisci il nuovo valore\n");
        return scanner.nextLine();
    }

    public int confirmChoice()
    {
        System.out.println("Insert\n");
        System.out.println("1)Per continuare a modificare");
        System.out.println("2)Per confermare le modfiche");
        System.out.println("3)Per annullare");
        return scanner.nextInt();
    }

    public void errorMessage(String errorMessage)
    {
        System.out.println(errorMessage);
    }

}
