package com.ispw.circularbook.controller.graficcontroller.cli;

import com.ispw.circularbook.controller.appcontroller.SearchBookController;
import com.ispw.circularbook.controller.appcontroller.UserController;
import com.ispw.circularbook.engineering.bean.InfoBookBean;
import com.ispw.circularbook.engineering.bean.LibraryBean;
import com.ispw.circularbook.engineering.bean.UpdateInfoBean;
import com.ispw.circularbook.engineering.enums.City;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.utils.MessageSupport;
import com.ispw.circularbook.model.InfoBookModel;
import com.ispw.circularbook.model.LibraryModel;
import com.ispw.circularbook.view.cli.CLISettingLibraryView;


public class CLISettingLibraryController {
    LibraryModel libraryModel;

    CLIHomepageController cliHomepageController;
    CLISettingLibraryView cliSettingLibraryView;

    public CLISettingLibraryController(CLIHomepageController cliHomepageController){this.cliHomepageController= cliHomepageController;}

    public void start()
    {
        cliSettingLibraryView = new CLISettingLibraryView(this);
        libraryModel = Session.getCurrentSession().getLibrary();
        this.command(cliSettingLibraryView.start());
    }

    public void startSetting()
    {
        this.command(cliSettingLibraryView.start());
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
        cliSettingLibraryView.showPersonalInfo(this.setLibraryBean());
    }

    private void showCircularBookUse()
    {
        cliSettingLibraryView.showInfoCircularBook(this.setInfoBookBean());
    }

    private void modifyPersonalInfo()
    {

        cliSettingLibraryView.showPersonalInfo(this.setLibraryBean());
        String camp=cliSettingLibraryView.choseCamp();
        String value= cliSettingLibraryView.setCamp();
        switch (camp)
        {
            case "Nome":
                libraryModel.setNomeLib(value);
                this.confirmChange();
                break;
            case "Cognome":
                libraryModel.setVia(value);
                this.confirmChange();
                break;
            case "Username":
                libraryModel.setTelNumber(value);
                this.confirmChange();
                break;
            case "Citta":
                while(!checkCity(value))
                {
                    MessageSupport.cliExceptionSMessage("Il valore citta inserito non è stato trovato!");
                    value= cliSettingLibraryView.setCamp();
                }
                libraryModel.setCity(value);
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
        int i=cliSettingLibraryView.confirmChoice();
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
        UpdateInfoBean updateInfoBean = new UpdateInfoBean(libraryModel.getEmail(),libraryModel.getCity());
        updateInfoBean.setNameLibrary(libraryModel.getNomeLib());
        updateInfoBean.setVia(libraryModel.getVia());
        updateInfoBean.setNumberPhone(libraryModel.getTelNumber());
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

    private LibraryBean setLibraryBean()
    {
        LibraryBean libraryBean = new LibraryBean();
        libraryBean.setNomeLib(libraryModel.getNomeLib());
        libraryBean.setVia(libraryModel.getVia());
        libraryBean.setTelNumber(libraryModel.getTelNumber());
        libraryBean.setCity(libraryModel.getCity());
        return libraryBean;
    }

    private InfoBookBean setInfoBookBean()
    {
        SearchBookController searchBookController = new SearchBookController();
        InfoBookBean infoBookBean = new InfoBookBean(libraryModel.getEmail());
        InfoBookModel infoBookModel = searchBookController.searchBookInfoLibrary(infoBookBean);
        infoBookBean.setRegisterBook(infoBookBean.getRegisterBook());
        infoBookBean.setLendedBook(infoBookModel.getLendedBook());
        infoBookBean.setGiftedBook(infoBookModel.getGiftedBook());
        infoBookBean.setSalesInsert(infoBookModel.getSalesInsert());
        return infoBookBean;
    }
}
