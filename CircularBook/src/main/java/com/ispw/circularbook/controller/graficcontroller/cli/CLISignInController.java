package com.ispw.circularbook.controller.graficcontroller.cli;

import com.ispw.circularbook.controller.appcontroller.SignInController;
import com.ispw.circularbook.engineering.bean.SignInBean;
import com.ispw.circularbook.engineering.exception.EmailUsedException;
import com.ispw.circularbook.engineering.exception.NoMatchPasswordException;
import com.ispw.circularbook.engineering.exception.WrongCityInsertException;
import com.ispw.circularbook.engineering.exception.WrongEmailFormattException;
import com.ispw.circularbook.view.cli.CLISignInView;

import java.io.IOException;

public class CLISignInController {

    private CLISignInView cliSignInView;
    private SignInController signInController;
    private SignInBean signInBean;
    public void start()
    {
        cliSignInView = new CLISignInView(this);
        signInController = new SignInController();
        signInBean = new SignInBean();

        int value=cliSignInView.SignIn();
        this.command(value);
    }

    public void command(int value)
    {
        switch (value)
        {
            case 1:
                this.startSignInUser();
                break;
            case 2:
                this.startSignInLibrary();
                break;
            default:
                break;
        }
    }

    public void startSignInUser(){
        cliSignInView.startSignInU();
        this.setEmail();
        this.setPassword();
        cliSignInView.getInfoSignInU();
        this.setCitta();
        this.endSignInU();

    }

    public void startSignInLibrary(){
        cliSignInView.startSignInL();
        this.setEmail();
        this.setPassword();
        cliSignInView.getInfoSingInL();
        this.setCitta();
        this.endSignInL();

    }

    public void setSignInLibrary(String nomeLib,String telefono,String via)
    {
        signInBean.setNomeLib(nomeLib);
        signInBean.setnTel(telefono);
        signInBean.setVia(via);
    }

    public void setSignInUser(String nome,String cognome, String username)
    {
        signInBean.setNome(nome);
        signInBean.setCognome(cognome);
        signInBean.setUsername(username);
    }

    public void endSignInU(){
        signInController.signInU(signInBean);
        CLILoginController cliLoginController = new CLILoginController();
        cliLoginController.start();

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
            citta = cliSignInView.getCittaSignIn();
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
                email = cliSignInView.getEmailSignIn();
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
                password = cliSignInView.getPasswordSignIn();
                repassword = cliSignInView.getPasswordSignIn();
                checkPassword(password,repassword);
                signInBean.setPassword(password);
                passwordIsValid = true;
            }catch (NoMatchPasswordException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private void checkPassword(String password,String repassword) throws NoMatchPasswordException {
        if (!password.equals(repassword))
            throw new NoMatchPasswordException();

    }
}
