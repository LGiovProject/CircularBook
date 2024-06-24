package com.ispw.circularbook.engineering.decorator;

import com.ispw.circularbook.controller.appcontroller.SearchBookController;
import com.ispw.circularbook.controller.graficcontroller.cli.CLIHomepageController;
import com.ispw.circularbook.controller.graficcontroller.cli.CLIShowBookController;
import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.bean.SearchBookBean;
import com.ispw.circularbook.engineering.enums.Arguments;
import com.ispw.circularbook.engineering.exception.NoBookFoundException;
import com.ispw.circularbook.engineering.exception.WrongArgumentInsertException;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.utils.MessageSupport;
import com.ispw.circularbook.model.BookModel;
import com.ispw.circularbook.view.cli.CLISearchBookView;

import java.util.ArrayList;
import java.util.List;

public class CLISearchBookComponent implements ICLISearchBookComponent{

    public CLISearchBookView cliSearchBookView;
    private SearchBookBean searchBookBean;
    private CLIHomepageController cliHomepageController;

    public CLISearchBookComponent(CLIHomepageController cliHomepageController)
    {
        this.cliHomepageController=cliHomepageController;

        searchBookBean = new SearchBookBean("", Arguments.Any,"", Session.getCurrentSession().getUser().getEmail());

        cliSearchBookView = new CLISearchBookView();

    }
    @Override
    public void start(){command(cliSearchBookView.start(searchBookBean));}

    @Override
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
                cleanParameters();
                break;
            case 6:
                cliHomepageController.start();
                break;
        }
    }

    private void insertTitle()
    {
        searchBookBean.setTitle(cliSearchBookView.insertTitle());
        start();
    }

    private void insertArgument()
    {
        boolean check =true;
        while(check) {
            try {
                searchBookBean.setArgument(cliSearchBookView.insertArgument());
                check = false;
            } catch (WrongArgumentInsertException e) {
                MessageSupport.cliExceptionSMessage(e.getMessage());
            }
        }
        start();
    }

    private void insertAuthor()
    {
        searchBookBean.setAuthor(cliSearchBookView.insertAuthor());
        start();
    }

    private void searchBook()
    {
        SearchBookController searchBookController = new SearchBookController();
        List<BookModel> bookModelList;
        try {
            bookModelList = searchBookController.searchAvailableBook(searchBookBean);
            CLIShowBookController cliShowBookController = new CLIShowBookController();
            cliShowBookController.showBookAvailable(getBookBeanList(bookModelList));
            CLISearchBookDecorator cliSearchBookDecorator = new CLISearchBookDecorator(this);

        } catch (NoBookFoundException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            start();
        }
    }

    private void cleanParameters()
    {
        searchBookBean.setArgument(Arguments.Any);
        searchBookBean.setAuthor("null");
        searchBookBean.setTitle("null");
        start();
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
