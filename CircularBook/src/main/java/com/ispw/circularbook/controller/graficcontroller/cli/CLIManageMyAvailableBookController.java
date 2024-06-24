package com.ispw.circularbook.controller.graficcontroller.cli;

import com.ispw.circularbook.controller.appcontroller.InsertBookController;
import com.ispw.circularbook.controller.appcontroller.SearchBookController;
import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.exception.NoBookRegisteredException;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.utils.MessageSupport;
import com.ispw.circularbook.model.BookModel;
import com.ispw.circularbook.view.cli.CLIManageMyAvailableBookView;

import java.util.ArrayList;
import java.util.List;

public class CLIManageMyAvailableBookController {

    private String sessionEmail;

    private CLIManageController cliManageController;
    private CLIManageMyAvailableBookView cliManageMyAvailableBookView;
    private SearchBookController searchBookController;
    private CLIShowBookController cliShowBookController;

    public CLIManageMyAvailableBookController(CLIManageController cliManageController)
    {
        cliManageMyAvailableBookView = new CLIManageMyAvailableBookView();
        this.cliManageController=cliManageController;
        searchBookController = new SearchBookController();
        cliShowBookController = new CLIShowBookController();
        sessionEmail=getSessionEmail();
    }

    public void startManage()
    {
        List<BookModel> bookModelList;
        try {
            bookModelList = searchBookController.searchMyAvailableBook(sessionEmail);
            cliShowBookController.showMyBookAvailable(getBookBeanList(bookModelList));
            command(cliManageMyAvailableBookView.start());
        } catch (NoBookRegisteredException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            startManage();
        }

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
                cliManageController.start();
                break;
        }
    }

    public void modifyBookInfo()
    {
        int id=cliManageMyAvailableBookView.modifyBook();
        CLIModifyMyAvailableBookController cliModifyMyAvailableBookController = new CLIModifyMyAvailableBookController(this);
        cliModifyMyAvailableBookController.setId(id);
        cliModifyMyAvailableBookController.start();
    }

    public void deleteBook()
    {
        int i=cliManageMyAvailableBookView.deleteBook();
        InsertBookController insertBookController = new InsertBookController();
        insertBookController.removeBook(i);
        startManage();
    }

    private List<BookBean> getBookBeanList(List<BookModel> bookModelList)
    {
        List<BookBean> bookBeanList = new ArrayList<>();
        for(BookModel bookModel: bookModelList)
        {
            BookBean bookBean = new BookBean();
            bookBean.setId(bookModel.getId());
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
