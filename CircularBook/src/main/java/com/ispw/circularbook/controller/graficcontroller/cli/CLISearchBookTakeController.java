package com.ispw.circularbook.controller.graficcontroller.cli;

import com.ispw.circularbook.controller.appcontroller.InsertBookController;
import com.ispw.circularbook.controller.appcontroller.SearchBookController;
import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.bean.SearchBookBean;
import com.ispw.circularbook.engineering.bean.TakeBookBean;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.model.BookModel;
import com.ispw.circularbook.view.cli.CLISearchBookTakeView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CLISearchBookTakeController {

    SearchBookBean searchBookBean;

    CLIManageUserController cliManageUserController;

    String sessionEmail;

    List<BookBean> bookBeanList;

    private CLISearchBookTakeController(SearchBookBean searchBookBean,CLIManageUserController cliManageUserController)
    {
        sessionEmail = Session.getCurrentSession().getUser().getEmail();
        this.searchBookBean=searchBookBean;
        this.cliManageUserController=cliManageUserController;
    }

    public void start()
    {
        SearchBookController searchBookController = new SearchBookController();
        List<BookModel> bookModelList = searchBookController.searchAvailableBook(searchBookBean);
        CLIShowBookController cliShowBookController = new CLIShowBookController();
        CLISearchBookTakeView cliSearchBookTakeView = new CLISearchBookTakeView();
        bookBeanList=getBookBeanList(bookModelList);
        cliShowBookController.showBookAvailable(bookBeanList);
        String value = cliSearchBookTakeView.start();

        //command(Integer.parseInt(value));
    }

    public void command(int i){
        if(i>0) {
            takeBook(i);
        }else
            cliManageUserController.start();
    }


    private void takeBook(int i)
    {
        BookBean bookBean = getBookBean(i,bookBeanList);
        if(bookBean!=null) {
            TakeBookBean takeBookBean = new TakeBookBean(i, bookBean.getEmail(), sessionEmail, bookBean.getTypeOfDisponibility(), LocalDate.now());
            InsertBookController insertBookController = new InsertBookController();
            insertBookController.registerLendBook(takeBookBean);
        }
    }


    private BookBean getBookBean(int id,List<BookBean> bookBeanList)
    {
        for(BookBean bookBean: bookBeanList)
            if (bookBean.getId()==id)
                return bookBean;
        return null;
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
