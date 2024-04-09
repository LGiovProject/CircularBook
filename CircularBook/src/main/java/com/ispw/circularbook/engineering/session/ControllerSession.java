package com.ispw.circularbook.engineering.session;
import com.ispw.circularbook.controller.graficcontroller.gui.*;
import com.ispw.circularbook.controller.graficcontroller.gui.GUIInsertLendBookController;

public class ControllerSession {
    private static  GUIHomepageController guiHomepageController;

    private static GUIHomepageSideButtonUserController guiHomepageUserSideButtonController;
    private static GUIInsertLendBookController guiInsertLendBookController;

    public static void  setGuiHomepageLendBook(GUIInsertLendBookController lendBookController) {
        guiInsertLendBookController = lendBookController;
    }



    public static void setGuiHomepageUserSideButtonController(GUIHomepageSideButtonUserController homepageUserSideButtonController) {
        guiHomepageUserSideButtonController = homepageUserSideButtonController;
    }

    public static void setGuiHomepageController(GUIHomepageController homepageController) {
        guiHomepageController = homepageController;
    }

    public static GUIInsertLendBookController getGuiHomepageLendBook() {
        return guiInsertLendBookController;
    }

    public static GUIHomepageController getGuiHomepageController() {
        return guiHomepageController;
    }

    public static GUIHomepageSideButtonUserController getGuiHomepageUserSideButtonController() {
        return guiHomepageUserSideButtonController;
    }
}
