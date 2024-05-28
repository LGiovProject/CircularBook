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

    public List<BookModel> searchAvailableBook(SearchBookBean searchBookBean)
    {
        List<BookBean> listBookBean;
        List<BookModel> listBookModel= new ArrayList<>();
        listBookBean=SearchBookDAO.searchAvailableBook(searchBookBean);
        for(BookBean bookBean: listBookBean)
        {
            BookModel bookModel = new BookModel(bookBean.getId(),bookBean.getEmail(), bookBean.getUsername(),bookBean.getTypeOfDisponibility(),bookBean.getTitolo(),bookBean.getAutore(),bookBean.getArgomento(),bookBean.getNPagine(),bookBean.getCommento());
            listBookModel.add(bookModel);
        }
        return listBookModel;
    }

    public List<BookModel> searchMyAvailableBook(String email){

            List<BookBean> listBookBean;
            List<BookModel> listBookModel= new ArrayList<>();
            listBookBean = SearchBookDAO.searchMyAvailableBook(email);

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
            BookModel bookModel = new BookModel(bookBean.getId(), bookBean.getUsernameTaker(), bookBean.getTypeOfDisponibility(),bookBean.getTitolo(),bookBean.getAutore(),bookBean.getArgomento(), bookBean.getNPagine(), bookBean.getCommento(),bookBean.getDate_start(),bookBean.getDate_finish(),bookBean.getDaysRemaing());
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
