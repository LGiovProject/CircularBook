package com.ispw.circularbook.engineering.state.cli;

import com.ispw.circularbook.controller.appcontroller.SearchBookController;
import com.ispw.circularbook.controller.graficcontroller.cli.CLIManageController;
import com.ispw.circularbook.controller.graficcontroller.cli.CLIManageMyAvailableBookController;
import com.ispw.circularbook.controller.graficcontroller.cli.CLIShowBookController;
import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.exception.NoBookLendedException;
import com.ispw.circularbook.engineering.exception.NoBookRegisteredException;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.utils.MessageSupport;
import com.ispw.circularbook.model.BookModel;
import com.ispw.circularbook.view.cli.CLIManageUserView;

import java.util.ArrayList;
import java.util.List;

public class CLIManageUserState implements CLIManageState{

    CLIManageController context;
    CLIManageUserView cliManageUserView;
    String sessionEmail;

    public CLIManageUserState(CLIManageController cliManageController)
    {
        context=cliManageController;
        cliManageUserView = new CLIManageUserView();
        sessionEmail = Session.getCurrentSession().getUser().getEmail();
    }

    @Override
    public int start() {
        return cliManageUserView.start();
    }


    @Override
    public void command(int i)
    {
        switch (i)
        {
            case 1:
                manageMyAvailableBook();
                break;
            case 2:
                showBookITook();
                break;
            case 3:
                manageBookIGive();
                break;
            case 4:
                context.goBack();
                break;
            default:
                MessageSupport.cliExceptionSMessage("Comando non trovato");
                start();
        }
    }
    @Override
    public void manageMyAvailableBook()
    {
        CLIManageMyAvailableBookController cliManageMyAvailableBookController= new CLIManageMyAvailableBookController(context);
        cliManageMyAvailableBookController.startManage();

    }

    public void showBookITook()
    {
        List<BookModel>  bookModelList;
        SearchBookController searchBookController = new SearchBookController();
        CLIShowBookController cliShowBookController = new CLIShowBookController();
        try {
            bookModelList= searchBookController.searchMyBookTaked(sessionEmail);
            cliShowBookController.showBookAvailable(getBookBeanList(bookModelList));
            context.start();
        } catch (NoBookLendedException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            context.start();
        }

    }

    @Override
    public void manageBookIGive()
    {
        List<BookModel> listBookModel;
        SearchBookController searchBookController = new SearchBookController();
        CLIShowBookController cliShowBookController = new CLIShowBookController();
        try {
            listBookModel = searchBookController.searchMyGivenBook(sessionEmail);
            cliShowBookController.showBookGived(getBookBeanList(listBookModel));
            context.start();
        } catch (NoBookLendedException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            context.start();
        }

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
}
