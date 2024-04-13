package com.ispw.circularbook.controller.appcontroller;

import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.bean.LibraryBean;
import com.ispw.circularbook.engineering.bean.LoginBean;
import com.ispw.circularbook.engineering.bean.UserBean;
import com.ispw.circularbook.engineering.dao.*;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.exception.NoBookLendedException;
import com.ispw.circularbook.model.BookModel;
import com.ispw.circularbook.model.LibraryModel;
import com.ispw.circularbook.model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class LoginController {

   //Invocata dal loginController passa i dati alla classe loginDao affinchè faccia una ricerca nel database per vedere se i dati
   //Presi in input facciano match con quelli salvati nel database
    public void checkLogin(LoginBean loginBean) {

       loginBean.setType(LoginDAO.checkLogin(loginBean));

    }


    //Viene invocata dal loginController
    //Inizializza la classe userModel prendendo le informazioni dal database dell'utente con l'email ottenuta dal loginBean al momento del login
    //Tramite lo userModel appena istanziato creiamo una istanza di userBean che viene poi passata a session per tenere traccia di quale utente al momento
    //sta usando l'applicazione.
    //Facciamo anche una ricerca su quali libri si hanno in prestito,così da avere la notifica se manca poco alla scadenza della riconsegna.
    public void userSession(LoginBean loginBean){

//        List<BookBean> listBookBean = new ArrayList<>();
//        UserModel userModel = UserDAO.searchUserByEmail(loginBean.getEmail());
//        UserBean userBean = new UserBean(userModel.getEmail(),userModel.getUsername(),userModel.getName(), userModel.getCognome(), userModel.getCitta());
//        Session.setSessionInstance(userBean);
//        try {
//            userModel.setBookBeanTaked(SearchBookDAO.searchLendedBook(userModel.getEmail()));
//        }catch (NoBookLendedException e) {
//            e.printStackTrace();
//        }
//        if(userModel.getBookBeanTaked()!=null) {
//            for (BookModel bookModel : userModel.getBookBeanTaked()) {
//                BookBean bookBean = new BookBean(bookModel.getId(), bookModel.getEmail(), bookModel.getTypeOfDisponibility(), bookModel.getTitolo(), bookModel.getAutore(), bookModel.getArgomento(), bookModel.getnPagine(), bookModel.getCommento(), bookModel.getDate_start(), bookModel.getDate_finish(), bookModel.getDaysRemaing(), bookModel.getEmailGiver());
//                listBookBean.add(bookBean);
//            }
//        }
//        else
//        {
//            listBookBean= new ArrayList<>();
//        }
//        userBean.setBookBeanTaked(listBookBean);

        List<BookModel> listBookModel = new ArrayList<>();
        UserBean userBean = UserDAO.searchUserByEmail(loginBean.getEmail());
        UserModel userModel = new UserModel();


        try {
           List<BookBean> bookBeanList=(SearchBookDAO.searchLendedBook(userBean.getEmail()));
            if(bookBeanList!=null)
            {

                for (BookBean bookBean : bookBeanList) {

                    BookModel bookModel = new BookModel(bookBean.getId(), bookBean.getEmail(), bookBean.getTypeOfDisponibility(), bookBean.getTitolo(), bookBean.getAutore(), bookBean.getArgomento(), bookBean.getnPagine(), bookBean.getCommento(), bookBean.getDate_start(), bookBean.getDate_finish(), bookBean.getDaysRemaing(), bookBean.getEmailGiver());
                    listBookModel.add(bookModel);
                }
            }

        }catch (NoBookLendedException e) {
            e.printStackTrace();
        }

        userModel.setBookTaked(listBookModel);
        Session.setSessionInstance(userModel);
    }

    //Viene invocata dal loginController
    //Inizializza la classe libraryModel prendendo le informazioni dal database della libreria con l'email ottenuta dal loginBean al momento del login
    //Tramite la libraryModel appena istanziata creiamo una istanza di libraryBean che viene poi passata a session per tenere traccia di quale libreria al momento
    //sta usando l'applicazione.
    public void librarySession(LoginBean loginBean){

//        LibraryModel libraryModel= LibraryDAO.searchLibraryByEmail(loginBean.getEmail());
//        LibraryBean libraryBean = new LibraryBean(libraryModel.getEmail(), libraryModel.getNomeLib(), libraryModel.getCitta(), libraryModel.getVia(),libraryModel.getTelNumber());
//        Session.setSessionInstance(libraryBean);

        LibraryBean libraryBean= LibraryDAO.searchLibraryByEmail(loginBean.getEmail());
        LibraryModel libraryModel = new LibraryModel(libraryBean.getEmail(),libraryBean.getNomeLib(),libraryBean.getCityString(),libraryBean.getVia(),libraryBean.getTelNumber());
        Session.setSessionInstance(libraryModel);

    }


}