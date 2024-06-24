package com.ispw.circularbook.controller.graficcontroller.cli;

import com.ispw.circularbook.controller.appcontroller.InsertBookController;
import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.exception.NoBookFoundException;
import com.ispw.circularbook.engineering.session.Session;
import com.ispw.circularbook.engineering.utils.MessageSupport;
import com.ispw.circularbook.model.BookModel;
import com.ispw.circularbook.view.cli.CLIModifyMyAvailableBookView;
import java.util.List;

public class CLIModifyMyAvailableBookController {

    private CLIModifyMyAvailableBookView cliModifyMyAvailableBookView;

    private CLIManageMyAvailableBookController cliManageMyAvailableBookController;

    private BookBean bookBean;

    private int id;

    private List<BookModel> bookModelList;

    public void setId(int id){this.id=id;}

    public CLIModifyMyAvailableBookController(CLIManageMyAvailableBookController cliManageMyAvailableBookController)
    {
        cliModifyMyAvailableBookView = new CLIModifyMyAvailableBookView();
        this.cliManageMyAvailableBookController = cliManageMyAvailableBookController;
        bookModelList=Session.getCurrentSession().getUser().getBookOwnList();
    }

    public void start()
    {
        try {
            bookBean=getBookBean(bookModelList,id);
        } catch (NoBookFoundException e) {
            MessageSupport.cliExceptionSMessage("Il libro non è stato trovato");
            this.start();
        }
        command(cliModifyMyAvailableBookView.start(bookBean));

    }

    private void command(int i)
    {
        switch (i) {
            case 1:
                insertTitle();
                break;
            case 2:
                insertAuthor();
                break;
            case 3:
                insertArgument();
                break;
            case 4:
                insertTypeOfBook();
                break;
            case 5:
                insertNPage();
                break;
            case 6:
                insertComment();
                break;
            case 7:
                saveUpdate();
                break;
            case 8:
                goBack();
                break;
        }
    }

    private void insertTitle()
    {
        bookBean.setTitolo(cliModifyMyAvailableBookView.insertTitle());
    }

    private void insertArgument()
    {
        bookBean.setArgomento(cliModifyMyAvailableBookView.insertArgument());
    }

    private void insertAuthor()
    {
        bookBean.setAutore(cliModifyMyAvailableBookView.insertAuthor());
    }

    private void insertTypeOfBook()
    {
        bookBean.setTypeOfDisponibility(cliModifyMyAvailableBookView.insertTypeOfBook());
    }

    private void insertNPage()
    {
        bookBean.setNPagine(cliModifyMyAvailableBookView.insertNPage());
    }

    private void insertComment()
    {
        bookBean.setCommento(cliModifyMyAvailableBookView.insertComment());
    }

    private void saveUpdate()
    {
        InsertBookController insertBookController = new InsertBookController();
        insertBookController.updateBookInfo(bookBean);
    }

    private void goBack()
    {
        cliManageMyAvailableBookController.startManage();
    }

    private BookBean getBookBean(List<BookModel> bookModelList,int id) throws NoBookFoundException {
            BookBean bookBean =new BookBean();
            for(BookModel bookModel: bookModelList)
            {
                if(bookModel.getId()==id) {
                    bookBean.setId(bookBean.getId());
                    bookBean.setTitolo(bookModel.getTitolo());
                    bookBean.setUsername(bookModel.getUsername());
                    bookBean.setAutore(bookModel.getAutore());
                    bookBean.setArgomento(bookModel.getArgomento());
                    bookBean.setTypeOfDisponibility(bookModel.getTypeOfDisponibility());
                    bookBean.setNPagine(bookModel.getnPagine());
                    bookBean.setCommento(bookModel.getCommento());
                    return bookBean;
                }
            }
            throw new NoBookFoundException();
    }

}

