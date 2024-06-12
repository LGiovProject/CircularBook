package com.ispw.circularbook.controller.graficcontroller.cli;

import com.ispw.circularbook.controller.appcontroller.SearchBookController;
import com.ispw.circularbook.controller.appcontroller.SearchSalesController;
import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.bean.SalesBean;
import com.ispw.circularbook.engineering.exception.NoBookLendedException;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.model.BookModel;
import com.ispw.circularbook.model.SalesModel;

import java.util.ArrayList;
import java.util.List;

public class CLIManageLibraryController {

    String sessionEmail;
    CLIHomepageController cliHomepageController;

    public CLIManageLibraryController(CLIHomepageController cliHomepageController){this.cliHomepageController=cliHomepageController;}

    public void start()
    {
        sessionEmail=Session.getCurrentSession().getLibrary().getEmail();
    }

    public void command(int i)
    {
        switch (i)
        {
            case 1:
                showMyAvailableBook();
                break;
            case 2:
                showMySales();
                break;
            case 3:
                showMyBookTook();
                break;
            case 4:
                cliHomepageController.start();
                break;
        }
    }

    public void showMyAvailableBook()
    {
        List<BookModel> listBookModel;
        SearchBookController searchBookController = new SearchBookController();
        CLIShowBookController cliShowBookController = new CLIShowBookController();
        listBookModel = searchBookController.searchMyAvailableBook(sessionEmail);
        cliShowBookController.showBookAvailable(getBookBeanList(listBookModel));
    }

    public void showMySales()
    {
        List<SalesModel> salesModelList;
        SearchSalesController searchSalesController = new SearchSalesController();
        CLIShowSalesController cliShowSalesController = new CLIShowSalesController();
        try {
            salesModelList=searchSalesController.searchSales(sessionEmail);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        cliShowSalesController.showSales(getSalesBeanList(salesModelList));
    }

    public void showMyBookTook()
    {
        List<BookModel> listBookModel;
        SearchBookController searchBookController = new SearchBookController();
        CLIShowBookController cliShowBookController = new CLIShowBookController();
        try {
            listBookModel = searchBookController.searchMyGivenBook(sessionEmail);
        } catch (NoBookLendedException e) {
            throw new RuntimeException(e);
        }
        cliShowBookController.showBookAvailable(getBookBeanList(listBookModel));
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
