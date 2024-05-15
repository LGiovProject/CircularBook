package com.ispw.circularbook.controller.appcontroller;

import com.ispw.circularbook.engineering.bean.*;

import com.ispw.circularbook.engineering.dao.SearchBookDAO;
import com.ispw.circularbook.engineering.exception.NoBookLendedException;
import com.ispw.circularbook.model.BookModel;
import com.ispw.circularbook.model.InfoBookModel;
import com.ispw.circularbook.model.LibraryModel;
import com.ispw.circularbook.model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class SearchBookController {

    public List<BookModel> searchBook(SearchBookBean searchBookBean)
    {
        List<BookBean> listBookBean;
        List<BookModel> listBookModel= new ArrayList<>();
        listBookBean=SearchBookDAO.searchBook(searchBookBean);
        for(BookBean bookBean: listBookBean)
        {
            BookModel bookModel = new BookModel(bookBean.getId(),bookBean.getEmail(),bookBean.getTypeOfDisponibility(),bookBean.getTitolo(),bookBean.getAutore(),bookBean.getArgomento(),bookBean.getNPagine(),bookBean.getCommento());
            listBookModel.add(bookModel);
        }
        return listBookModel;
    }

    public List<BookModel> searchMyBook(String email) throws NoBookLendedException {

            List<BookBean> listBookBean;
            List<BookModel> listBookModel= new ArrayList<>();
            listBookBean = SearchBookDAO.searchMyBook(email);

            for (BookBean bookBean : listBookBean) {
                BookModel bookModel = new BookModel(bookBean.getId(), bookBean.getEmail(), bookBean.getTypeOfDisponibility(),bookBean.getTitolo(), bookBean.getAutore(), bookBean.getArgomento(),  bookBean.getNPagine(), bookBean.getCommento());
                listBookModel.add(bookModel);
            }
            return listBookModel;

    }


    public List<BookModel> searchMyGivenBook(String email) throws NoBookLendedException {
        List<BookBean> listBookBean;
        List<BookModel> listBookModel = new ArrayList<>();

        listBookBean=SearchBookDAO.searchGivenBook(email);

        for(BookBean bookBean: listBookBean)
        {
            BookModel bookModel = new BookModel(bookBean.getId(), bookBean.getEmail(), bookBean.getTypeOfDisponibility(),bookBean.getTitolo(),bookBean.getAutore(),bookBean.getArgomento(), bookBean.getNPagine(), bookBean.getCommento(),bookBean.getDate_start(),bookBean.getDate_finish(),bookBean.getDaysRemaing(),bookBean.getEmailTaker());
            listBookModel.add(bookModel);
        }
        return listBookModel;
    }

    public InfoBookModel searchBookInfoUser(InfoBookBean infoBookBeanIn)
    {
        InfoBookBean infoBookBeanOut = SearchBookDAO.searchBookUserInfo(infoBookBeanIn);
        InfoBookModel infoBookModel = new InfoBookModel(infoBookBeanOut.getRegisterBook(),infoBookBeanOut.getLendedBook(),infoBookBeanOut.getGiftedBook(),infoBookBeanOut.getLendedBookTaked(),infoBookBeanOut.getGiftedBooktaked());

        return infoBookModel;

    }
    public InfoBookModel searchBookInfoLibrary(String email)
    {
        InfoBookBean infoBookBean=SearchBookDAO.searchBookLibraryInfo(email);
        InfoBookModel infoBookModel;
        infoBookModel = new InfoBookModel(infoBookBean.getRegisterBook(),infoBookBean.getLendedBook(),infoBookBean.getGiftedBook(),infoBookBean.getSalesInsert());

        return infoBookModel;
    }



}
