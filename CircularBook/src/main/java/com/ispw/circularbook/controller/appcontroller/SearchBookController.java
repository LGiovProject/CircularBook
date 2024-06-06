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

    //Cerca i libri in base ai parametri di ricerca di searchBookBeani
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
    //Cerca i propri libri nel sistema ancora disponibili
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

    //Cerca i propri libri nel sistema che sono stati presi
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
    //Raccoglie le informazioni su l'utilizzo dell'applicazione in termini di libri inseriti, dati e presi.
    public InfoBookModel searchBookInfoUser(InfoBookBean infoBookBeanIn)
    {
        InfoBookBean infoBookBeanOut = SearchBookDAO.searchBookUserInfo(infoBookBeanIn);
        InfoBookModel infoBookModel = new InfoBookModel(infoBookBeanOut.getRegisterBook(),infoBookBeanOut.getLendedBook(),infoBookBeanOut.getGiftedBook(),infoBookBeanOut.getLendedBookTaked(),infoBookBeanOut.getGiftedBooktaked());

        return infoBookModel;

    }
    //Raccoglie le informazioni su l'utilizzo dell'applicazione da parte delle librerie in termini di libri inseriti.
    public InfoBookModel searchBookInfoLibrary(InfoBookBean infoBookBeanIn)
    {
        InfoBookBean infoBookBeanOut=SearchBookDAO.searchBookLibraryInfo(infoBookBeanIn);
        InfoBookModel infoBookModel;
        infoBookModel = new InfoBookModel(infoBookBeanOut.getRegisterBook(),infoBookBeanOut.getLendedBook(),infoBookBeanOut.getGiftedBook(),infoBookBeanOut.getSalesInsert());

        return infoBookModel;
    }



}
