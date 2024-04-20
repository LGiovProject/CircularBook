package com.ispw.circularbook.engineering.session;


import com.ispw.circularbook.controller.graficcontroller.gui.GUIHomepageController;
import com.ispw.circularbook.model.LibraryModel;
import com.ispw.circularbook.model.UserModel;

public class Session {

    private static Session session;

    private UserModel userModel = null;
    private LibraryModel libraryModel= null;
    private GUIHomepageController guiHomepageController;

    private Session(Object ob) {
        if(ob instanceof UserModel) {
            this.userModel = (UserModel) ob;
        }
        else if(ob instanceof LibraryModel) {
            libraryModel = (LibraryModel) ob;
        }
    }


    public static synchronized void setSessionInstance(Object ob) {
        if(session == null)
            session = new Session(ob);



    }



    public static void closeSession() {
        session = null;
    }

    public static Session getCurrentSession() {
        return session;
    }

    public UserModel getUser() {
        return userModel;
    }

    public LibraryModel getLibrary() {
        return libraryModel;
    }

    public GUIHomepageController getGuiHomepageController(){ return guiHomepageController;}

    public void setGuiHomepageController(GUIHomepageController guiHomepageController){ this.guiHomepageController = guiHomepageController;}
}
