package com.ispw.circularbook.controller.graficcontroller.cli;

import com.ispw.circularbook.controller.appcontroller.LoginController;
import com.ispw.circularbook.engineering.bean.LoginBean;
import com.ispw.circularbook.engineering.exception.WrongEmailFormattException;
import com.ispw.circularbook.view.cli.CLILoginView;

import java.io.IOException;

public class CLILoginController {

        CLILoginView cliLoginView;
        public void start() throws WrongEmailFormattException, IOException {
                this.cliLoginView = new CLILoginView(this);
                this.command(cliLoginView.start());

        }

        public void command(int value) throws WrongEmailFormattException, IOException {
                switch (value)
                {
                        case 1:
                                cliLoginView.getCredentials();
                                break;
                        case 2:

                                break;
                        case 3:

                                break;
                        default:
                                break;
                }
        }

        public void checkCredential(String username, String password) throws WrongEmailFormattException, IOException {
                LoginController loginController = new LoginController();
                LoginBean loginBean = new LoginBean(password,username);
                loginController.checkLogin(loginBean);
        }
}
