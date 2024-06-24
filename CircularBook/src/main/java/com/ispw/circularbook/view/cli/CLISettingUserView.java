package com.ispw.circularbook.view.cli;

import com.ispw.circularbook.controller.graficcontroller.cli.CLISettingUserController;
import com.ispw.circularbook.engineering.bean.InfoBookBean;
import com.ispw.circularbook.engineering.bean.UserBean;
import com.ispw.circularbook.engineering.utils.MessageCLISupport;

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
        MessageCLISupport.delimiterMessage();
        System.out.println(infoBookBean.getRegisterBook()+" registrati\n");
        System.out.println(infoBookBean.getLendedBook()+" messi in prestito\n");
        System.out.println(infoBookBean.getGiftedBook()+" messi in regalo\n");
        System.out.println(infoBookBean.getLendedBookTaked()+" presi in regalo\n");
        System.out.println(infoBookBean.getGiftedBooktaked()+" presi in prestito\n");
    }

    public void showPersonalInfo(UserBean userBean)
    {
        MessageCLISupport.delimiterMessage();
        System.out.println("Nome: "+userBean.getName());
        System.out.println("Cognome: "+userBean.getCognome());
        System.out.println("Username: "+userBean.getUsername());
        System.out.println("Citta: "+userBean.getCityString());
    }

    public String choseCamp()
    {
        MessageCLISupport.delimiterMessage();
        System.out.println("Scegli il campo che vuoi modificare\n");
        System.out.println("Inserisci None per annullare\n");
        return scanner.nextLine();

    }

    public String setCamp()
    {
        MessageCLISupport.delimiterMessage();
        System.out.println("Inserisci il nuovo valore\n");
        return scanner.nextLine();
    }

    public int confirmChoice()
    {
        MessageCLISupport.delimiterMessage();
        System.out.println("Insert\n");
        System.out.println("1)Per continuare a modificare\n");
        System.out.println("2)Per confermare le modfiche\n");
        System.out.println("3)Per annullare\n");
        return Integer.parseInt(scanner.nextLine());
    }

    public void errorMessage(String errorMessage)
    {
        System.out.println(errorMessage);
    }


}
