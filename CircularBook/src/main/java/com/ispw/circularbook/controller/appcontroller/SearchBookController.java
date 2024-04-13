package com.ispw.circularbook.controller.appcontroller;

import com.ispw.circularbook.engineering.bean.BookBean;

import com.ispw.circularbook.engineering.bean.LibraryBean;
import com.ispw.circularbook.engineering.bean.UserBean;
import com.ispw.circularbook.engineering.dao.SearchBookDAO;
import com.ispw.circularbook.engineering.exception.NoBookLendedException;
import com.ispw.circularbook.model.BookModel;
import com.ispw.circularbook.model.LibraryModel;
import com.ispw.circularbook.model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class SearchBookController {

    public List<BookBean> searchBook(String author, String argument, String title,String email)
    {
        List<BookBean> listBookBean;
        List<BookModel> listBookModel= new ArrayList<>();
        listBookBean=SearchBookDAO.searchBook(author,argument,title,email);
        for(BookBean bookBean: listBookBean)
        {
            BookModel bookModel = new BookModel(bookBean.getId(),bookBean.getEmail(),bookBean.getTypeOfDisponibility(),bookBean.getTitolo(),bookBean.getAutore(),bookBean.getArgomento(),bookBean.getnPagine(),bookBean.getCommento());
            listBookModel.add(bookModel);
        }
        return listBookBean;
    }

    public List<BookModel> searchMyBook(String email) throws NoBookLendedException {

            List<BookBean> listBookBean;
            List<BookModel> listBookModel= new ArrayList<>();
            listBookBean = SearchBookDAO.searchMyBook(email);

            for (BookBean bookBean : listBookBean) {
                BookModel bookModel = new BookModel(bookBean.getId(), bookBean.getEmail(), bookBean.getTypeOfDisponibility(),bookBean.getTitolo(), bookBean.getAutore(), bookBean.getArgomento(),  bookBean.getnPagine(), bookBean.getCommento());
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

            BookModel bookModel = new BookModel(bookBean.getId(), bookBean.getEmail(), bookBean.getTypeOfDisponibility(),bookBean.getTitolo(),bookBean.getAutore(),bookBean.getArgomento(), bookBean.getnPagine(), bookBean.getCommento(),bookBean.getDate_start(),bookBean.getDate_finish(),bookBean.getDaysRemaing(),bookBean.getEmailTaker());
            listBookModel.add(bookModel);
        }
        return listBookModel;
    }

    public UserBean searchBookInfoUser(UserBean userBean)
    {

        UserModel userModel = new UserModel();
        userModel.setBookInfo(SearchBookDAO.searchBookUserInfo(userBean.getEmail()));
        userBean.setBookInfo(userModel.getBookInfo());
        return userBean;

    }
    public LibraryBean searchBookInfoLibrary(LibraryBean libraryBean)
    {
        LibraryModel libraryModel = new LibraryModel();
        libraryModel.setBookInfo(SearchBookDAO.searchBookLibraryInfo(libraryBean.getEmail()));
        libraryBean.setBookInfo(libraryModel.getBookInfo());
        return libraryBean;
    }



}
