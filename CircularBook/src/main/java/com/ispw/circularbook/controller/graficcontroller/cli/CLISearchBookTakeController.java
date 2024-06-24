package com.ispw.circularbook.controller.graficcontroller.cli;

import com.ispw.circularbook.controller.appcontroller.InsertBookController;
import com.ispw.circularbook.engineering.bean.SearchBookBean;
import com.ispw.circularbook.engineering.bean.TakeBookBean;
import com.ispw.circularbook.engineering.exception.NoBookFoundException;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.utils.MessageSupport;
import com.ispw.circularbook.model.BookModel;
import com.ispw.circularbook.view.cli.CLISearchBookTakeView;

import java.time.LocalDate;
import java.util.List;

public class CLISearchBookTakeController {

    SearchBookBean searchBookBean;

    CLISearchBookController cliSearchBookController;

    String sessionEmail;

    List<BookModel> bookModelList;

    CLISearchBookTakeView cliSearchBookTakeView;

    public CLISearchBookTakeController(CLISearchBookController cliSearchBookController)
    {
        sessionEmail = Session.getCurrentSession().getUser().getEmail();
        this.cliSearchBookController=cliSearchBookController;
        cliSearchBookTakeView = new CLISearchBookTakeView();
    }

    public void start()
    {
        bookModelList = Session.getCurrentSession().getUser().getBookLastSearch();
        command(Integer.parseInt(cliSearchBookTakeView.start()));
    }

    private void command(int i){
        if(i>0) {
            takeBook(i);
        }else
            cliSearchBookController.start();
    }


    private void takeBook(int i)
    {
        try {
            TakeBookBean takeBookBean = getTakeBookBean(bookModelList,i);
            InsertBookController insertBookController = new InsertBookController();
            insertBookController.registerLendBook(takeBookBean);
            MessageSupport.cliSuccessMessage("Il libro è stato preso correttamente");
            cliSearchBookController.start();
        } catch (NoBookFoundException e) {
            MessageSupport.cliExceptionSMessage(e.getMessage());
            cliSearchBookController.start();
        }
    }


    private TakeBookBean getTakeBookBean(List<BookModel> bookModelList,int i) throws NoBookFoundException {

        for(BookModel bookModel: bookModelList)
        {
            if(bookModel.getId()==i){
                return new TakeBookBean(bookModel.getId(),bookModel.getTypeOfDisponibility(),bookModel.getEmail(),sessionEmail,LocalDate.now());
            }
        }
        throw new NoBookFoundException();

    }
}
