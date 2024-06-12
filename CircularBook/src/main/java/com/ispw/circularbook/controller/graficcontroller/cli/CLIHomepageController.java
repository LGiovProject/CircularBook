package com.ispw.circularbook.controller.graficcontroller.cli;

import com.ispw.circularbook.engineering.bean.LoginBean;


import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.state.cli.CLIHomepageGuestState;
import com.ispw.circularbook.engineering.state.cli.CLIHomepageLibraryState;
import com.ispw.circularbook.engineering.state.cli.CLIHomepageState;
import com.ispw.circularbook.engineering.state.cli.CLIHomepageUserState;

public class CLIHomepageController {

    private CLIHomepageState currentState;

    public void setState(CLIHomepageState state)
    {
        this.currentState=state;
    }

    public void homepageStart(LoginBean loginBean){

        if(loginBean.getType()==1)
            if(Session.getCurrentSession().getUser().isGuest())
                this.setState(new CLIHomepageGuestState());
            else
                this.setState(new CLIHomepageUserState());
        else if (loginBean.getType()==2)
            this.setState(new CLIHomepageLibraryState());

        this.command(currentState.startHomepage(this));
    }

    public void start()
    {
        this.command(currentState.startHomepage(this));
    }

    public void logOut(){
        CLILoginController cliLoginController = new CLILoginController();
        Session.closeSession();
        cliLoginController.start();
    }

    public void insertBook()
    {
        CLIInsertBookController cliInsertBookController = new CLIInsertBookController(this);
        cliInsertBookController.start();
    }

    public void command(int value)
    {
        currentState.command(value);
    }
}
