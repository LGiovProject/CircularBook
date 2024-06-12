package com.ispw.circularbook.controller.graficcontroller.cli;

import com.ispw.circularbook.controller.appcontroller.SignInController;
import com.ispw.circularbook.engineering.bean.SignInBean;
import com.ispw.circularbook.engineering.exception.EmailUsedException;
import com.ispw.circularbook.engineering.exception.NoMatchPasswordException;
import com.ispw.circularbook.engineering.exception.WrongCityInsertException;
import com.ispw.circularbook.engineering.exception.WrongEmailFormattException;
import com.ispw.circularbook.view.cli.CLISignInLibraryView;

public class CLISignInLibraryController {

    CLISignInLibraryView cliSignInLibraryView;
    SignInBean signInBean;
    SignInController signInController;

    public void start()
    {
        cliSignInLibraryView = new CLISignInLibraryView();
        signInBean= new SignInBean();
        signInController= new SignInController();
        this.startSignInLibrary();
    }

    public void startSignInLibrary(){
        cliSignInLibraryView.startSignInL();
        this.setEmail();
        this.setPassword();
        this.setCitta();
        this.setNomeLibreria();
        this.setNumeroTelefono();
        this.setVia();
        this.endSignInL();

    }


    public void endSignInL(){
        signInController.signInL(signInBean);
        CLILoginController cliLoginController = new CLILoginController();
        cliLoginController.start();
    }

    private void setCitta(){

        boolean cityIsValid=false;
        String citta;
        while(!cityIsValid)
        {
            citta = cliSignInLibraryView.getCittaSignIn();
            try {
                signInBean.setCitta(citta);
                cityIsValid=true;
            } catch (WrongCityInsertException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void setEmail()
    {
        String email="";
        SignInController signInController = new SignInController();
        boolean emailIsValid = false;

        while (!emailIsValid) {
            try {
                email = cliSignInLibraryView.getEmailSignIn();
                signInController.checkMail(email);
                signInBean.setEmail(email);
                emailIsValid = true; // Esce dal ciclo se l'email è valida

            } catch (EmailUsedException | WrongEmailFormattException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private void setPassword()  {
        String password;
        String repassword;
        boolean passwordIsValid = false;
        while (!passwordIsValid){
            try{
                password = cliSignInLibraryView.getPasswordSignIn();
                repassword = cliSignInLibraryView.getPasswordSignIn();
                checkPassword(password,repassword);
                signInBean.setPassword(password);
                passwordIsValid = true;
            }catch (NoMatchPasswordException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private void setNomeLibreria()
    {
        String nomeLibreria;
        nomeLibreria=cliSignInLibraryView.getNomeLibreria();
        checkInputBack(nomeLibreria);
        signInBean.setNomeLib(nomeLibreria);
    }

    private void setNumeroTelefono()
    {
        String numTelefono;
        numTelefono= cliSignInLibraryView.getNumeroTelefono();
        checkInputBack(numTelefono);
        signInBean.setnTel(numTelefono);
    }

    private void setVia()
    {
        String via;
        via= cliSignInLibraryView.getVia();
        checkInputBack(via);
        signInBean.setVia(via);
    }

    private void checkPassword(String password,String repassword) throws NoMatchPasswordException {
        if (!password.equals(repassword))
            throw new NoMatchPasswordException();

    }

    private void checkInputBack(String value)
    {
        try {
            int command = Integer.parseInt(value);
            if (command == 10)
                goBack();
        } catch (NumberFormatException e) {
            // Non è un comando numerico, prosegui normalmente
        }

    }

    private void goBack()
    {
        CLISignInController cliSignInController = new CLISignInController();
        cliSignInController.start();
    }
}
