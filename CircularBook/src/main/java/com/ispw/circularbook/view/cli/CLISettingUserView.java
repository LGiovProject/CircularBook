package com.ispw.circularbook.view.cli;

import com.ispw.circularbook.controller.graficcontroller.cli.CLISettingUserController;
import com.ispw.circularbook.engineering.bean.InfoBookBean;
import com.ispw.circularbook.engineering.bean.UserBean;

import java.util.Scanner;

public class CLISettingUserView {

    CLISettingUserController cliSettingUserController;

    final Scanner scanner = new Scanner(System.in);

    public CLISettingUserView(CLISettingUserController cliSettingUserController){this.cliSettingUserController = cliSettingUserController;}

    public int start()
    {
        System.out.println("*************************User Setting***********************");
        System.out.println("1)Modify personal info");
        System.out.println("2)Show persona info");
        System.out.println("3)Show circular book use");
        System.out.println("4)go back");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    public void showInfoCircularBook(InfoBookBean infoBookBean)
    {
        System.out.println(infoBookBean.getRegisterBook()+" registrati\n");
        System.out.println(infoBookBean.getLendedBook()+" messi in prestito\n");
        System.out.println(infoBookBean.getGiftedBook()+" messi in regalo\n");
        System.out.println(infoBookBean.getLendedBookTaked()+" presi in regalo\n");
        System.out.println(infoBookBean.getGiftedBooktaked()+" presi in prestito\n");
    }

    public void showPersonalInfo(UserBean userBean)
    {
        System.out.println("Nome: "+userBean.getName()+"\n");
        System.out.println("Cognome: "+userBean.getCognome()+"\n");
        System.out.println("Username: "+userBean.getUsername()+"\n");
        System.out.println("Citta: "+userBean.getCityString()+"\n");
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
        return Integer.parseInt(scanner.nextLine());
    }

    public void errorMessage(String errorMessage)
    {
        System.out.println(errorMessage);
    }


}
