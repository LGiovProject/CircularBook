package com.ispw.circularbook.controller.graficcontroller.cli;

import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.model.BookModel;
import com.ispw.circularbook.view.cli.CLIShowBookView;

import java.util.List;

public class CLIShowBookController {

    CLIShowBookView cliShowBookView;

    public CLIShowBookController()
    {
        cliShowBookView = new CLIShowBookView();
    }

    public void showBookAvailable(List<BookBean> bookBeanList)
    {
        for(BookBean bookBean: bookBeanList)
            cliShowBookView.showBookAvailable(bookBean);

    }

    public void showBookITaked(List<BookBean> bookBeanList) {
        for (BookBean bookBean : bookBeanList)
            cliShowBookView.showBookITaked(bookBean);

    }

    public void showBookGived(List<BookBean> bookBeanList) {
        for (BookBean bookBean : bookBeanList)
            cliShowBookView.showBookGived(bookBean);

    }



    public void showMyBookAvailable(List<BookBean> bookBeanList) {
        for (BookBean bookBean : bookBeanList)
            cliShowBookView.showMyBookAvailable(bookBean);

    }

}
