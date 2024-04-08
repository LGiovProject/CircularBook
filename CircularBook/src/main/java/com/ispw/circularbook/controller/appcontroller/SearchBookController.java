package com.ispw.circularbook.controller.appcontroller;

import com.ispw.circularbook.engineering.Bean.BookBean;

import com.ispw.circularbook.engineering.Bean.LibraryBean;
import com.ispw.circularbook.engineering.Bean.UserBean;
import com.ispw.circularbook.engineering.DAO.SearchBookDAO;
import com.ispw.circularbook.engineering.exception.NoBookLendedException;
import com.ispw.circularbook.model.BookModel;
import com.ispw.circularbook.model.LibraryModel;
import com.ispw.circularbook.model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class SearchBookController {

    public List<BookBean> searchBook(String author, String argument, String title,String email)
    {
        List<BookBean> listBookBean=new ArrayList<>();
        List<BookModel> listBookModel;
        listBookModel=SearchBookDAO.searchBook(author,argument,title,email);
        for(BookModel bookModel: listBookModel)
        {
            BookBean bookBean = new BookBean(bookModel.getId(),bookModel.getEmail(),bookModel.getTypeOfDisponibility(),bookModel.getTitolo(),bookModel.getAutore(),bookModel.getArgomento(),  bookModel.getnPagine(), bookModel.getCommento());
            listBookBean.add(bookBean);
        }
        return listBookBean;
    }

    public List<BookBean> searchMyBook(String email) throws NoBookLendedException {

            List<BookBean> listBookBean = new ArrayList<>();
            List<BookModel> listBookModel;
            listBookModel = SearchBookDAO.searchMyBook(email);

            for (BookModel bookModel : listBookModel) {
                BookBean bookBean = new BookBean(bookModel.getId(), bookModel.getEmail(), bookModel.getTypeOfDisponibility(),bookModel.getTitolo(), bookModel.getAutore(), bookModel.getArgomento(),  bookModel.getnPagine(), bookModel.getCommento());
                listBookBean.add(bookBean);
            }
            return listBookBean;

    }


    public List<BookBean> searchMyGivenBook(String email) throws NoBookLendedException {
        List<BookBean> listBookBean=new ArrayList<>();
        List<BookModel> listBookModel;

        listBookModel=SearchBookDAO.searchGivenBook(email);

        for(BookModel bookModel: listBookModel)
        {

            BookBean bookBean = new BookBean(bookModel.getId(), bookModel.getEmail(), bookModel.getTypeOfDisponibility(),bookModel.getTitolo(),bookModel.getAutore(),bookModel.getArgomento(), bookModel.getnPagine(), bookModel.getCommento(),bookModel.getDate_start(),bookModel.getDate_finish(),bookModel.getDaysRemaing(),bookModel.getEmailTaker());
            listBookBean.add(bookBean);
        }
        return listBookBean;
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
