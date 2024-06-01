package com.ispw.circularbook.controller.graficcontroller.cli;

import com.ispw.circularbook.controller.appcontroller.LoginController;
import com.ispw.circularbook.engineering.bean.LoginBean;
import com.ispw.circularbook.engineering.exception.WrongEmailFormattException;
import com.ispw.circularbook.engineering.utils.BoxExcpetionMessage;
import com.ispw.circularbook.view.cli.CLILoginView;
import com.ispw.circularbook.view.cli.CLISignInView;

import java.io.IOException;

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
                                cliSingInController.start();
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
             this.setEmail();
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

        private void endLogin(LoginBean loginBean)
        {
                loginController = new LoginController();
                if (loginBean.getType() == 1) {

                        loginController.userSession(loginBean);


                } else if (loginBean.getType() == 2) {

                        loginController.librarySession(loginBean);

                } else {
                        BoxExcpetionMessage.PopUpsExcpetionMessage("La mail o la password sono errate");
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

                boolean emailIsValid = false;

                while (!emailIsValid) {
                        try {
                                email = cliLoginView.getEmail();
                                loginBean.setEmail(email);
                                emailIsValid=true;
                        } catch (WrongEmailFormattException e) {
                                throw new RuntimeException(e);
                        }
                }
        }
}
