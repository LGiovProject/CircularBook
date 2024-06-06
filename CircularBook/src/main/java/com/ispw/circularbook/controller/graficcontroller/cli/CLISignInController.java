package com.ispw.circularbook.controller.graficcontroller.cli;

import com.ispw.circularbook.view.cli.CLISignInView;


public class CLISignInController {

    private CLISignInView cliSignInView;

    public void start()
    {
        cliSignInView = new CLISignInView(this);

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
            case 3:
                this.goLogin();
                break;
            default:
                break;
        }
    }

    public void goLogin()
    {
        CLILoginController cliLoginController = new CLILoginController();
        cliLoginController.start();
    }

    public void startSignInUser()
    {
        CLISignInUserController cliSignInUserController = new CLISignInUserController();
        cliSignInUserController.start();
    }

    public void startSignInLibrary()
    {
       CLISignInLibraryController cliSignInLibraryController = new CLISignInLibraryController();
       cliSignInLibraryController.start();
    }

//    public void startSignInUser(){
//        cliSignInView.startSignInU();
//        this.setEmail();
//        this.setPassword();
//        cliSignInView.getInfoSignInU();
//        this.setCitta();
//        this.endSignInU();
//
//    }
//
//    public void startSignInLibrary(){
//        cliSignInView.startSignInL();
//        this.setEmail();
//        this.setPassword();
//        cliSignInView.getInfoSingInL();
//        this.setCitta();
//        this.endSignInL();
//
//    }
//
//    public void setSignInLibrary(String nomeLib,String telefono,String via)
//    {
//        signInBean.setNomeLib(nomeLib);
//        signInBean.setnTel(telefono);
//        signInBean.setVia(via);
//    }
//
//    public void setSignInUser(String nome,String cognome, String username)
//    {
//        signInBean.setNome(nome);
//        signInBean.setCognome(cognome);
//        signInBean.setUsername(username);
//    }
//
//    public void endSignInU(){
//        signInController.signInU(signInBean);
//        CLILoginController cliLoginController = new CLILoginController();
//        cliLoginController.start();
//
//    }
//
//    public void endSignInL(){
//        signInController.signInL(signInBean);
//        CLILoginController cliLoginController = new CLILoginController();
//        cliLoginController.start();
//    }
//
//    private void setCitta(){
//
//        boolean cityIsValid=false;
//        String citta;
//        while(!cityIsValid)
//        {
//            citta = cliSignInView.getCittaSignIn();
//            try {
//                signInBean.setCitta(citta);
//                cityIsValid=true;
//            } catch (WrongCityInsertException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//
//    private void setEmail()
//    {
//        String email="";
//        SignInController signInController = new SignInController();
//        boolean emailIsValid = false;
//
//        while (!emailIsValid) {
//            try {
//                email = cliSignInView.getEmailSignIn();
//                signInController.checkMail(email);
//                signInBean.setEmail(email);
//                emailIsValid = true; // Esce dal ciclo se l'email è valida
//
//            } catch (EmailUsedException | WrongEmailFormattException e) {
//                throw new RuntimeException(e);
//            }
//        }
//
//    }
//
//    private void setPassword()  {
//        String password;
//        String repassword;
//        boolean passwordIsValid = false;
//        while (!passwordIsValid){
//            try{
//                password = cliSignInView.getPasswordSignIn();
//                repassword = cliSignInView.getPasswordSignIn();
//                checkPassword(password,repassword);
//                signInBean.setPassword(password);
//                passwordIsValid = true;
//            }catch (NoMatchPasswordException e) {
//                throw new RuntimeException(e);
//            }
//        }
//
//    }
//
//    private void checkPassword(String password,String repassword) throws NoMatchPasswordException {
//        if (!password.equals(repassword))
//            throw new NoMatchPasswordException();
//
//    }
}
