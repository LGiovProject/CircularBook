package com.ispw.circularbook.controller.graficcontroller.cli;

import com.ispw.circularbook.controller.appcontroller.SearchBookController;
import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.exception.NoBookLendedException;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.model.BookModel;
import com.ispw.circularbook.view.cli.CLIManageUserView;

import java.util.ArrayList;
import java.util.List;

public class CLIManageUserController {

    public CLIHomepageController cliHomepageController;

    String sessionEmail;

    public CLIManageUserController(CLIHomepageController cliHomepageController)
    {
        this.cliHomepageController=cliHomepageController;
        sessionEmail = Session.getCurrentSession().getUser().getEmail();
    }

    public void start()
    {
        CLIManageUserView cliManageUserView = new CLIManageUserView();
        command(cliManageUserView.start());
    }

    public void command(int i)
    {
        switch (i)
        {
            case 1:
                showMyAvailableBook();
                break;
            case 2:
                showBookITook();
                break;
            case 3:
                showBookGived();
                break;
            case 4:
                cliHomepageController.start();
                break;
        }
    }

    public void showMyAvailableBook()
    {
        List<BookModel> bookModelList;
        SearchBookController searchBookController = new SearchBookController();
        CLIShowBookController cliShowBookController = new CLIShowBookController();
        bookModelList = searchBookController.searchMyAvailableBook(sessionEmail);
        cliShowBookController.showMyBookAvailable(getBookBeanList(bookModelList));
    }

    public void showBookITook()
    {
        List<BookModel>  bookModelList;
        SearchBookController searchBookController = new SearchBookController();
        CLIShowBookController cliShowBookController = new CLIShowBookController();
        bookModelList= searchBookController.searchMyBookTaked(sessionEmail);
        cliShowBookController.showBookAvailable(getBookBeanList(bookModelList));
    }

    public void showBookGived()
    {
        List<BookModel> listBookModel;
        SearchBookController searchBookController = new SearchBookController();
        CLIShowBookController cliShowBookController = new CLIShowBookController();
        try {
            listBookModel = searchBookController.searchMyGivenBook(sessionEmail);
        } catch (NoBookLendedException e) {
            throw new RuntimeException(e);
        }
        cliShowBookController.showBookGived(getBookBeanList(listBookModel));
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
}
