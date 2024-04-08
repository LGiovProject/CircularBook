package com.ispw.circularbook.engineering.utils;

import com.ispw.circularbook.engineering.Bean.BookBean;
import com.ispw.circularbook.model.BookModel;

public class PrintBeanInfo {

    public static void printBookBean(BookBean bookBean)
    {
        System.out.println(bookBean.getId()+" "+bookBean.getEmail()+" "+bookBean.getTypeOfDisponibility()+" "+bookBean.getTitolo()+" "+bookBean.getAutore()+" "+bookBean.getArgomentoString()+" "+bookBean.getnPagine()+" "+bookBean.getCommento());
    }

    public static void printBookModel(BookModel bookModel){
        System.out.println(bookModel.getId()+" "+bookModel.getEmail()+" "+bookModel.getTypeOfDisponibility()+" "+bookModel.getTitolo()+" "+bookModel.getAutore()+" "+bookModel.getnPagine()+" "+bookModel.getCommento());
    }
}
