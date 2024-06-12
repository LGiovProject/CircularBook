package com.ispw.circularbook.controller.graficcontroller.cli;

import com.ispw.circularbook.controller.appcontroller.LoginController;
import com.ispw.circularbook.engineering.bean.LoginBean;
import com.ispw.circularbook.engineering.exception.WrongEmailFormattException;
import com.ispw.circularbook.engineering.utils.MessageSupport;
import com.ispw.circularbook.view.cli.CLILoginView;

public class CLILoginController {

        private CLILoginView cliLoginView;
        private CLISignInController cliSingInController;
        private LoginBean loginBean;
        private LoginController loginController;

        public void start(){
                loginBean = new LoginBean();
                loginController = new LoginController();

                this.cliLoginView = new CLILoginView(this);
                this.command(cliLoginView.start());

        }

        private void command(int value){
                switch (value)
                {
                        case 1:
                                this.startLogin();
                                break;
                        case 2:
                                this.startSignIn();
                                break;
                        case 3:
                                this.startLoginGuest();
                                break;
                        default:
                                break;
                }
        }



        public void startLogin()
        {
             setEmail();
             String password = cliLoginView.getPassword();
             loginBean.setPassword(password);
             checkCredential(loginBean);
             this.endLogin(loginBean);
        }

        public void startLoginGuest()
        {
                loginBean=loginController.guestSession();
                endLogin(loginBean);
        }

        public void startSignIn()
        {
                cliSingInController = new CLISignInController();
                cliSingInController.start();
        }

        private void endLogin(LoginBean loginBean)
        {
                loginController = new LoginController();
                if (loginBean.getType() == 1) {

                        loginController.userSession(loginBean);
                        CLIHomepageController cliHomepageController = new CLIHomepageController();
                        cliHomepageController.homepageStart(loginBean);


                } else if (loginBean.getType() == 2) {

                        loginController.librarySession(loginBean);
                        CLIHomepageController cliHomepageController = new CLIHomepageController();
                        cliHomepageController.homepageStart(loginBean);

                } else {
                        MessageSupport.cliExceptionSMessage("La mail o la password sono errate");
                        this.start();
                }
        }

        private void checkCredential(LoginBean loginBean){
                loginController = new LoginController();
                loginController.checkLogin(loginBean);
        }

        private void setEmail()
        {
                String email;

                boolean emailIsValid = true;

                while (emailIsValid) {
                        try {
                                email = cliLoginView.getEmail();
                                loginBean.setEmail(email);
                                emailIsValid=false;
                        } catch (WrongEmailFormattException e) {
                                MessageSupport.cliExceptionSMessage(e.getMessage());
                        }
                }
        }
}
