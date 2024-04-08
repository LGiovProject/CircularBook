package com.ispw.circularbook.controller.appcontroller;

import com.ispw.circularbook.engineering.Bean.BookBean;
import com.ispw.circularbook.engineering.Bean.LibraryBean;
import com.ispw.circularbook.engineering.Bean.LoginBean;
import com.ispw.circularbook.engineering.Bean.UserBean;
import com.ispw.circularbook.engineering.DAO.*;
import com.ispw.circularbook.engineering.Session.Session;
import com.ispw.circularbook.engineering.exception.NoBookLendedException;
import com.ispw.circularbook.model.BookModel;
import com.ispw.circularbook.model.LibraryModel;
import com.ispw.circularbook.model.UserModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginController {

   //Invocata dal loginController passa i dati alla classe loginDao affinchè faccia una ricerca nel database per vedere se i dati
   //Presi in input facciano match con quelli salvati nel database
    public void checkLogin(LoginBean loginBean) throws IOException {

       loginBean.setType(LoginDAO.checkLogin(loginBean.getEmail(),loginBean.getPassword()));

    }


    //Viene invocata dal loginController
    //Inizializza la classe userModel prendendo le informazioni dal database dell'utente con l'email ottenuta dal loginBean al momento del login
    //Tramite lo userModel appena istanziato creiamo una istanza di userBean che viene poi passata a Session per tenere traccia di quale utente al momento
    //sta usando l'applicazione.
    //Facciamo anche una ricerca su quali libri si hanno in prestito,così da avere la notifica se manca poco alla scadenza della riconsegna.
    public void userSession(LoginBean loginBean){

        List<BookBean> listBookBean = new ArrayList<>();
        UserModel userModel = UserDAO.searchUserByEmail(loginBean.getEmail());
        UserBean userBean = new UserBean(userModel.getEmail(),userModel.getUsername(),userModel.getName(), userModel.getCognome(), userModel.getCitta());
        Session.setSessionInstance(userBean);
        try {
            userModel.setBookBeanTaked(SearchBookDAO.searchLendedBook(userModel.getEmail()));
        }catch (NoBookLendedException e) {
            e.printStackTrace();
        }
        if(userModel.getBookBeanTaked()!=null) {
            for (BookModel bookModel : userModel.getBookBeanTaked()) {
                BookBean bookBean = new BookBean(bookModel.getId(), bookModel.getEmail(), bookModel.getTypeOfDisponibility(), bookModel.getTitolo(), bookModel.getAutore(), bookModel.getArgomento(), bookModel.getnPagine(), bookModel.getCommento(), bookModel.getDate_start(), bookModel.getDate_finish(), bookModel.getDaysRemaing(), bookModel.getEmailGiver());
                listBookBean.add(bookBean);
            }
        }
        else
        {
            listBookBean= new ArrayList<>();
        }
        userBean.setBookBeanTaked(listBookBean);
    }

    //Viene invocata dal loginController
    //Inizializza la classe libraryModel prendendo le informazioni dal database della libreria con l'email ottenuta dal loginBean al momento del login
    //Tramite la libraryModel appena istanziata creiamo una istanza di libraryBean che viene poi passata a Session per tenere traccia di quale libreria al momento
    //sta usando l'applicazione.
    public void librarySession(LoginBean loginBean){

        LibraryModel libraryModel= LibraryDAO.searchLibraryByEmail(loginBean.getEmail());
        LibraryBean libraryBean = new LibraryBean(libraryModel.getEmail(), libraryModel.getNomeLib(), libraryModel.getCitta(), libraryModel.getVia(),libraryModel.getTelNumber());
        Session.setSessionInstance(libraryBean);

    }


}