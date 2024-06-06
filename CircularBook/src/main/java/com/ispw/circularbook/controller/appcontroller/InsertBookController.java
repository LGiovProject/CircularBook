package com.ispw.circularbook.controller.appcontroller;

import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.bean.TakeBookBean;
import com.ispw.circularbook.engineering.bean.RegistrationBookBean;
import com.ispw.circularbook.engineering.dao.BookDAO;

public class InsertBookController {

    public void registerBook(RegistrationBookBean registrationBookBean){
        BookDAO.insertBook(registrationBookBean);
    }

    public void registerLendBook(TakeBookBean takeBookBean){BookDAO.insertLendBook(takeBookBean);}

    public void updateBookInfo(BookBean bookBean){BookDAO.updateBook(bookBean);}

    public void removeBook(int id){BookDAO.removeBook(id);}
}
