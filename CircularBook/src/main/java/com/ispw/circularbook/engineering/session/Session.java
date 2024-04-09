package com.ispw.circularbook.engineering.session;

import com.ispw.circularbook.engineering.bean.LibraryBean;
import com.ispw.circularbook.engineering.bean.UserBean;

public class Session {

    private static Session session;

    private UserBean userBean = null;
    private LibraryBean libraryBean= null;

    private Session(Object ob) {
        if(ob instanceof UserBean) {
            this.userBean = (UserBean) ob;
        }
        else if(ob instanceof LibraryBean) {
            libraryBean = (LibraryBean) ob;
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

    public UserBean getUserBean() {
        return userBean;
    }

    public LibraryBean getLibraryBean() {
        return libraryBean;
    }
}
