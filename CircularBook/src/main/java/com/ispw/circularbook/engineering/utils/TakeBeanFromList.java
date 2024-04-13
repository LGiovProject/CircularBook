package com.ispw.circularbook.engineering.utils;

import com.ispw.circularbook.engineering.bean.BookBean;

import com.ispw.circularbook.engineering.session.Session;

import java.util.List;

public class TakeBeanFromList {

    public static String getEmailFromCurrentSession()
    {
        String email=null;
        if(Session.getCurrentSession().getUser()!=null)
        {
            email=Session.getCurrentSession().getUser().getEmail();
        }
        else if(Session.getCurrentSession().getLibrary()!=null)
        {
            email=Session.getCurrentSession().getLibrary().getEmail();
        }
        return email;
    }

    public static int getTypeFromCurrentSession()
    {
         int type=0;
        if(Session.getCurrentSession().getUser()!=null)
        {
            type=1;
        }
        else if(Session.getCurrentSession().getLibrary()!=null)
        {
            type=2;
        }
        return type;
    }



    public static BookBean getBookBeanFromListById(int id,List<BookBean> bookBeanList)
    {


            BookBean bookBean = null;
            for (BookBean bookBeanTemp : bookBeanList) {
                if (bookBeanTemp.getId() == id) {
                    bookBean = bookBeanTemp;
                }
            }
            return bookBean;
    }




    }

