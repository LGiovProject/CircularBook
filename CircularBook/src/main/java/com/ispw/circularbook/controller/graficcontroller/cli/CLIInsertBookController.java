package com.ispw.circularbook.controller.graficcontroller.cli;

import com.ispw.circularbook.controller.appcontroller.InsertBookController;
import com.ispw.circularbook.engineering.bean.RegistrationBookBean;
import com.ispw.circularbook.engineering.exception.TitleCampRequiredException;
import com.ispw.circularbook.engineering.exception.WrongArgumentInsertException;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.utils.MessageSupport;
import com.ispw.circularbook.view.cli.CLIInsertBookView;

public class CLIInsertBookController {

    public CLIHomepageController cliHomepageController;
    public CLIInsertBookView cliInsertBookView;
    public RegistrationBookBean registrationBookBean;

    public CLIInsertBookController(CLIHomepageController cliHomepageController)
    {
        this.cliHomepageController= cliHomepageController;
    }

    public void start()
    {
        cliInsertBookView =new CLIInsertBookView();
        command(cliInsertBookView.start());
    }

    public void command(int i)
    {
        switch (i)
        {
            case 1:
                insertData();
                break;
            case 2:
                cliHomepageController.start();
                break;
        }
    }

    public void finishCommnad(int i)
    {
        switch (i)
        {
            case 1:
                registrationData();
            case 2:
                cliHomepageController.start();
        }
    }



    public void insertData(){
        registrationBookBean = new RegistrationBookBean();
        insertTitle();
        insertArgument();
        insertAuthor();
        insertNpage();
        insertTypeOfBook();
        insertComment();
        finishCommnad(cliInsertBookView.finish());
    }

    public void registrationData()
    {
        InsertBookController insertBookController= new InsertBookController();
        registrationBookBean.setEmail(getSessionEmail());
        insertBookController.registerBook(registrationBookBean);
    }

    public void insertTitle()
    {
        boolean check=true;
        while(check) {
            String title = cliInsertBookView.insertTitle();
            checkInput(title);
            try {
                registrationBookBean.setTitle(title);
                check=false;
            } catch (TitleCampRequiredException e) {
                MessageSupport.PopUpsExceptionMessage(e.getMessage());
            }
        }
    }

    public void insertArgument()
    {
       boolean errorArgument =true;

       while(errorArgument) {
           String argument= cliInsertBookView.insertArgument();
           checkInput(argument);
               try {
                   registrationBookBean.setArgument(argument);
                   errorArgument=false;
               } catch (WrongArgumentInsertException e) {
                   MessageSupport.cliExceptionSMessage(e.getMessage());
               }

       }
    }

    public void insertAuthor()
    {
       String author= cliInsertBookView.insertAuthor();
       checkInput(author);
       registrationBookBean.setAuthor(author);
    }

    public void insertNpage()
    {
        int npage =cliInsertBookView.insertNPage();
        checkInput(String.valueOf(npage));
        registrationBookBean.setNPage(npage);

    }

    public void insertTypeOfBook()
    {
        int typeOfBook =cliInsertBookView.insertTypeOfBook();
        checkInput(String.valueOf(typeOfBook));
        registrationBookBean.setTypeOfDisponibility(typeOfBook);
    }

    public void insertComment()
    {
        String comment=cliInsertBookView.insertComment();
        checkInput(comment);
        registrationBookBean.setComment(comment);
    }

    public void checkInput(String value)
    {

        try {
            int command = Integer.parseInt(value);
            if (command == -1)
                this.command(2);
        } catch (NumberFormatException e) {
            // Non è un comando numerico, prosegui normalmente
        }

    }

    private String getSessionEmail()
    {
        return  Session.getCurrentSession().getUser()==null?Session.getCurrentSession().getLibrary().getEmail():Session.getCurrentSession().getUser().getEmail();
    }

}
