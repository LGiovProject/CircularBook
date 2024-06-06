package com.ispw.circularbook.controller.graficcontroller.cli;

import com.ispw.circularbook.controller.appcontroller.SearchBookController;
import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.bean.SearchBookBean;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.model.BookModel;
import com.ispw.circularbook.view.cli.CLISearchBookView;

import java.util.List;

public class CLISearchBookController {

    CLISearchBookView cliSearchBookView;
    SearchBookBean searchBookBean;
    CLIHomepageController cliHomepageController;

    public CLISearchBookController(CLIHomepageController cliHomepageController)
    {
        this.cliHomepageController=cliHomepageController;
        searchBookBean = new SearchBookBean("","","", Session.getCurrentSession().getUser().getEmail());
        cliSearchBookView = new CLISearchBookView(this);
        start();
    }

    public void start()
    {
        command(cliSearchBookView.start());
    }



    public void command(int i)
    {
        switch (i)
        {
            case 1:
                insertTitle();
                break;
            case 2:
                insertArgument();
                break;
            case 3:
                insertAuthor();
                break;
            case 4:
                searchBook();
                break;
            case 5:
                cliHomepageController.start();
                break;
        }
    }

    public void insertTitle()
    {
       searchBookBean.setTitle(cliSearchBookView.insertTitle());
       start();
    }

    public void insertArgument()
    {
        searchBookBean.setArgument(cliSearchBookView.insertArgument());
        start();
    }

    public void insertAuthor()
    {
        searchBookBean.setAuthor(cliSearchBookView.insertAuthor());
        start();
    }

    public void searchBook()
    {
        SearchBookController searchBookController = new SearchBookController();
        List<BookModel> bookModelList = searchBookController.searchAvailableBook(searchBookBean);
        showBook(bookModelList);
    }

    public void showBook(List<BookModel> bookModelList)
    {
        BookBean bookBean = new BookBean();
        for(BookModel bookModel: bookModelList)
        {
            bookBean.setTitolo(bookModel.getTitolo());
            bookBean.setUsername(bookModel.getUsername());
            bookBean.setAutore(bookModel.getAutore());
            bookBean.setArgomento(bookModel.getArgomento());
            bookBean.setTypeOfDisponibility(bookModel.getTypeOfDisponibility());
            bookBean.setNPagine(bookModel.getnPagine());
            bookBean.setCommento(bookModel.getCommento());
            cliSearchBookView.showBook(bookBean);
        }
    }


}
