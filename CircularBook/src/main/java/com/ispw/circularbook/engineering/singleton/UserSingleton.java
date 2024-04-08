package com.ispw.circularbook.engineering.singleton;

import com.ispw.circularbook.engineering.Bean.LibraryBean;
import com.ispw.circularbook.engineering.Bean.UserBean;

public class UserSingleton {

    private static UserSingleton userInstance = null;
    private UserBean userBean;
    private LibraryBean libraryBean;

    private UserSingleton(Object ob)
    {
        if(ob instanceof UserBean)
        {
            userBean=(UserBean) ob;
        }
        else if(ob instanceof LibraryBean)
        {
            libraryBean=(LibraryBean) ob;
        }
    }
    public synchronized static UserSingleton getSingletonInstance()
    {
        return userInstance;
    }

    public synchronized static void setSingletonInstance(Object ob)
    {
        if(userInstance ==null)
            userInstance =new UserSingleton(ob);
    }

    public UserBean getUserBean()
    {
        return userBean;
    }

    public LibraryBean getLibraryBean()
    {
        return libraryBean;
    }

    public static void clearInstance()
    {
        userInstance=null;
    }

}
