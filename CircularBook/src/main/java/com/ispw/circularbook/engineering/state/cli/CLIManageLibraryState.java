package com.ispw.circularbook.engineering.state.cli;

import com.ispw.circularbook.controller.appcontroller.SearchBookController;
import com.ispw.circularbook.controller.appcontroller.SearchSalesController;
import com.ispw.circularbook.controller.graficcontroller.cli.*;
import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.bean.SalesBean;
import com.ispw.circularbook.engineering.exception.NoBookLendedException;
import com.ispw.circularbook.engineering.exception.NoBookRegisteredException;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.utils.MessageSupport;
import com.ispw.circularbook.model.BookModel;
import com.ispw.circularbook.model.SalesModel;
import com.ispw.circularbook.view.cli.CLIManageLibraryView;

import java.util.ArrayList;
import java.util.List;

public class CLIManageLibraryState implements CLIManageState{

    private CLIManageController context;

    private CLIManageLibraryView cliManageLibraryView;

    String sessionEmail;

    public CLIManageLibraryState(CLIManageController cliManageController)
    {
        context=cliManageController;
        cliManageLibraryView = new CLIManageLibraryView();
        sessionEmail = Session.getCurrentSession().getLibrary().getEmail();
    }

    @Override
    public int start() {
       return cliManageLibraryView.start();
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
                manageMySales();
                break;
            case 3:
                manageBookIGive();
                break;
            case 4:
                context.goBack();
                break;
        }
    }

    @Override
    public void manageMyAvailableBook()
    {
        CLIManageMyAvailableBookController cliManageMyAvailableBookController= new CLIManageMyAvailableBookController(context);
        cliManageMyAvailableBookController.startManage();

    }

    public void manageMySales()
    {
        CLIManageMySalesController cliManageMySalesController = new CLIManageMySalesController(context);
        cliManageMySalesController.start();
    }

    @Override
    public void manageBookIGive()
    {
        List<BookModel> listBookModel;
        SearchBookController searchBookController = new SearchBookController();
        CLIShowBookController cliShowBookController = new CLIShowBookController();
        try {
            listBookModel = searchBookController.searchMyGivenBook(sessionEmail);
            cliShowBookController.showBookAvailable(getBookBeanList(listBookModel));
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

    private List<SalesBean> getSalesBeanList(List<SalesModel> salesModelList)
    {
        List<SalesBean> salesBeanList = new ArrayList<>();
        for(SalesModel salesModel : salesModelList)
        {
            SalesBean salesBean = new SalesBean();
            salesBean.setTitlePromotion(salesModel.getTitle());
            salesBean.setTypeOfSales(salesModel.getTypeOfSalesInt());
            salesBean.setNameLib(salesModel.getNameLib());
            salesBean.setDateStart(salesModel.getDateStart());
            salesBean.setDateFinish(salesModel.getDateFinish());
            salesBean.setDescription(salesModel.getDescription());
            salesBeanList.add(salesBean);
        }
        return salesBeanList;
    }
}
