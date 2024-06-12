package com.ispw.circularbook.controller.graficcontroller.cli;

import com.ispw.circularbook.controller.appcontroller.InsertBookController;
import com.ispw.circularbook.controller.appcontroller.SearchBookController;
import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.model.BookModel;
import com.ispw.circularbook.view.cli.CLIManageMyAvailableBookView;

import java.util.ArrayList;
import java.util.List;

public class CLIManageMyAvailableBookController {

    String sessionEmail;

    CLIManageUserController cliManageUserController;
    CLIManageMyAvailableBookView cliManageMyAvailableBookView;

    public void start()
    {
        sessionEmail=getSessionEmail();
        cliManageMyAvailableBookView = new CLIManageMyAvailableBookView();
        command(cliManageMyAvailableBookView.start());
        List<BookModel> bookModelList;
        SearchBookController searchBookController = new SearchBookController();
        CLIShowBookController cliShowBookController = new CLIShowBookController();
        bookModelList = searchBookController.searchMyAvailableBook(sessionEmail);
        cliShowBookController.showMyBookAvailable(getBookBeanList(bookModelList));
    }

    public void command(int i)
    {
        switch (i)
        {
            case 1:
                modifyBookInfo();
                break;
            case 2:
                deleteBook();
                break;
            case 3:
                cliManageUserController.start();
                break;
        }
    }

    public void modifyBookInfo()
    {
        BookBean bookBean = new BookBean();
        int i=cliManageMyAvailableBookView.modifyBook();
        InsertBookController insertBookController = new InsertBookController();
        insertBookController.updateBookInfo(bookBean);
    }

    public void deleteBook()
    {
        int i=cliManageMyAvailableBookView.deleteBook();
        InsertBookController insertBookController = new InsertBookController();
        insertBookController.removeBook(i);
    }

    private List<BookBean> getBookBeanList(List<BookModel> bookModelList)
    {
        List<BookBean> bookBeanList = new ArrayList<>();
        for(BookModel bookModel: bookModelList)
        {
            BookBean bookBean = new BookBean();
            bookBean.setTitolo(bookModel.getTitolo());
            bookBean.setUsername(bookModel.getUsername());
            bookBean.setAutore(bookModel.getAutore());
            bookBean.setArgomento(bookModel.getArgomento());
            bookBean.setTypeOfDisponibility(bookModel.getTypeOfDisponibility());
            bookBean.setNPagine(bookModel.getnPagine());
            bookBean.setCommento(bookModel.getCommento());
            bookBeanList.add(bookBean);
        }
        return bookBeanList;
    }

    private String getSessionEmail()
    {
        return Session.getCurrentSession().getUser()==null?Session.getCurrentSession().getLibrary().getEmail():Session.getCurrentSession().getUser().getEmail();
    }


}
