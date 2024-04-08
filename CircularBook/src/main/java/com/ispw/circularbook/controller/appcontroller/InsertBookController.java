package com.ispw.circularbook.controller.appcontroller;

import com.ispw.circularbook.engineering.Bean.BookBean;
import com.ispw.circularbook.engineering.DAO.BookDAO;

public class InsertBookController {

    public void registerBook(BookBean bookBean){BookDAO.insertBook(bookBean);}
    public void registerLendBook(BookBean bookBean,String username){BookDAO.insertLendBook(bookBean, username); }
    public void updateBookInfo(BookBean bookBean){BookDAO.updateBook(bookBean);}
    public void removeBook(int id){BookDAO.removeBook(id);}
}
