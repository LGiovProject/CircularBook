package com.ispw.circularbook.controller.graficcontroller.cli;

import com.ispw.circularbook.controller.appcontroller.SearchBookController;
import com.ispw.circularbook.controller.appcontroller.UserController;
import com.ispw.circularbook.engineering.bean.InfoBookBean;
import com.ispw.circularbook.engineering.bean.UpdateInfoBean;
import com.ispw.circularbook.engineering.bean.UserBean;
import com.ispw.circularbook.engineering.enums.City;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.model.InfoBookModel;
import com.ispw.circularbook.model.UserModel;
import com.ispw.circularbook.view.cli.CLISettingUserView;

public class CLISettingUserController {

    CLIHomepageController cliHomepageController;
    CLISettingUserView cliSettingUserView;

    UserModel userModel;
    UserBean userBean;
    public CLISettingUserController(CLIHomepageController cliHomepageController){this.cliHomepageController= cliHomepageController;}

    public void start()
    {
        this.cliSettingUserView = new CLISettingUserView(this);
        this.userModel = Session.getCurrentSession().getUser();
        this.command(cliSettingUserView.start());
    }

    public void startSetting()
    {
        this.command(cliSettingUserView.start());
    }

    private void command(int value){
        switch (value)
        {
            case 1:
                this.modifyPersonalInfo();
                break;
            case 2:
                this.showPersonalInfo();
                break;
            case 3:
                this.showCircularBookUse();
                break;
            case 4:
                this.goBack();
                break;
            default:
                break;
        }
    }

    private void showPersonalInfo()
    {
        this.cliSettingUserView.showPersonalInfo(this.setUserBean());
        startSetting();
    }

    private void showCircularBookUse()
    {
        this.cliSettingUserView.showInfoCircularBook(this.setInfoBookBean());
        startSetting();
    }

    private void modifyPersonalInfo()
    {
        this.userBean = this.setUserBean();
        this.cliSettingUserView.showPersonalInfo(userBean);
        String camp=cliSettingUserView.choseCamp();
        String value= cliSettingUserView.setCamp();
        switch (camp)
        {
            case "Nome":
                this.userBean.setNome(value);
                this.confirmChange();
                break;
            case "Cognome":
                this.userBean.setCognome(value);
                this.confirmChange();
                break;
            case "Username":
                this.userBean.setUsername(value);
                this.confirmChange();
                break;
            case "Citta":
                while(!checkCity(value))
                {
                    cliSettingUserView.errorMessage("Il valore citta inserito non è stato trovato!");
                    value= cliSettingUserView.setCamp();
                }
                this.userBean.setCity(value);
                this.confirmChange();
                break;
            case "None":
                this.startSetting();
                break;
            default:
                break;
        }

    }

    public void confirmChange()
    {
        int i=cliSettingUserView.confirmChoice();
        switch (i) {
            case 1:
                this.modifyPersonalInfo();
                break;
            case 2:
                this.applyChange();
                break;
            case 3:
                this.start();
                break;
        }
    }

    public void applyChange()
    {
        UserController userController = new UserController();
        UpdateInfoBean updateInfoBean = new UpdateInfoBean(userBean.getEmail(),userBean.getCity());
        updateInfoBean.setNameUser(userBean.getName());
        updateInfoBean.setSurname(userBean.getCognome());
        updateInfoBean.setUsername(userBean.getUsername());
        userController.updateUser(updateInfoBean);
    }

    private void goBack()
    {
        cliHomepageController.start();
    }

    private boolean checkCity(String value)
    {
        for(City city : City.values())
        {
            if(city.getCity().equals(value))
                return true;
        }
        return false;
    }

    private UserBean setUserBean()
    {
        UserBean userBean = new UserBean();
        userBean.setEmail(userModel.getEmail());
        userBean.setNome(userModel.getNome());
        userBean.setCognome(userModel.getCognome());
        userBean.setUsername(userModel.getUsername());
        userBean.setCity(userModel.getCityString());
        return userBean;
    }

    private InfoBookBean setInfoBookBean()
    {
        SearchBookController searchBookController = new SearchBookController();
        InfoBookBean infoBookBean = new InfoBookBean(userModel.getEmail());
        InfoBookModel infoBookModel = searchBookController.searchBookInfoUser(infoBookBean);
        infoBookBean.setRegisterBook(infoBookBean.getRegisterBook());
        infoBookBean.setLendedBook(infoBookModel.getLendedBook());
        infoBookBean.setGiftedBook(infoBookModel.getGiftedBook());
        infoBookBean.setLendedBookTaked(infoBookModel.getLendedBookTaked());
        infoBookBean.setGiftedBooktaked(infoBookModel.getGiftedBooktaked());
        return infoBookBean;
    }

}
