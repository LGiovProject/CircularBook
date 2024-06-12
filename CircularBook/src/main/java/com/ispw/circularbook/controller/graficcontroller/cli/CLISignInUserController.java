package com.ispw.circularbook.controller.graficcontroller.cli;

import com.ispw.circularbook.controller.appcontroller.SignInController;
import com.ispw.circularbook.engineering.bean.SignInBean;
import com.ispw.circularbook.engineering.exception.EmailUsedException;
import com.ispw.circularbook.engineering.exception.NoMatchPasswordException;
import com.ispw.circularbook.engineering.exception.WrongCityInsertException;
import com.ispw.circularbook.engineering.exception.WrongEmailFormattException;
import com.ispw.circularbook.engineering.utils.MessageSupport;
import com.ispw.circularbook.view.cli.CLISignInUserView;

public class CLISignInUserController {

    CLISignInUserView cliSignInUserView;
    SignInBean signInBean;
    SignInController signInController;
    
    public void start()
    {
        cliSignInUserView = new CLISignInUserView();
        signInBean= new SignInBean();
        signInController= new SignInController();
        this.startSignInUser();
    }
    
    public void startSignInUser(){
        cliSignInUserView.startSignInU();
        this.setEmail();
        this.setPassword();
        this.setNome();
        this.setCognome();
        this.setUsername();
        this.setCitta();
        this.endSignInU();

    }

    public void endSignInU(){
        signInController.signInU(signInBean);
        CLILoginController cliLoginController = new CLILoginController();
        cliLoginController.start();

    }

    private void setCitta(){

        boolean cityIsValid=false;
        String citta;
        while(!cityIsValid)
        {
            citta = cliSignInUserView.getCittaSignIn();
            checkInputBack(citta);
            try {
                signInBean.setCitta(citta);
                cityIsValid=true;
            } catch (WrongCityInsertException e) {
                MessageSupport.cliExceptionSMessage(e.getMessage());
            }
        }
    }

    private void setEmail()
    {
        String email;
        SignInController signInController = new SignInController();
        boolean emailIsValid = false;

        while (!emailIsValid) {
            email = cliSignInUserView.getEmailSignIn();
            try {
                checkInputBack(email);
                signInController.checkMail(email);
                signInBean.setEmail(email);
                emailIsValid = true; // Esce dal ciclo se l'email è valida

            } catch (EmailUsedException | WrongEmailFormattException e) {
                MessageSupport.cliExceptionSMessage(e.getMessage());
            }
        }

    }

    private void setPassword()  {
        String password;
        String repassword;
        boolean passwordIsValid = false;
        while (!passwordIsValid){
            try{
                password = cliSignInUserView.getPasswordSignIn();
                checkInputBack(password);
                repassword = cliSignInUserView.getPasswordSignIn();
                checkInputBack(repassword);
                checkPassword(password,repassword);
                signInBean.setPassword(password);
                passwordIsValid = true;
            }catch (NoMatchPasswordException e) {
                MessageSupport.cliExceptionSMessage(e.getMessage());
            }
        }

    }

    private void setNome(){
        String nome;
        nome =cliSignInUserView.getNome();
        checkInputBack(nome);
        signInBean.setNome(nome);

    }

    private void setCognome(){
        String cognome;
        cognome= cliSignInUserView.getCognome();
        checkInputBack(cognome);
        signInBean.setCognome(cognome);
    }

    private void setUsername(){
        String username;
        username = cliSignInUserView.getUsername();
        checkInputBack(username);
        signInBean.setUsername(username);
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
