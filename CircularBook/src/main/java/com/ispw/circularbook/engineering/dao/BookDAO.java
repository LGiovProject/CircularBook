package com.ispw.circularbook.engineering.dao;


import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.Connection.ConnectionDB;
import com.ispw.circularbook.engineering.dao.Queries.Queries;
import com.ispw.circularbook.engineering.exception.ErrorConnectionDbException;
import com.ispw.circularbook.engineering.utils.BoxExcpetionMessage;
import com.ispw.circularbook.engineering.exception.ErrorInsertBookException;
import com.ispw.circularbook.engineering.exception.ErrorRemoveBookException;
import com.ispw.circularbook.engineering.exception.ErrorUpdateBookException;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class BookDAO {


    public static void insertBook(BookBean bookBean) {
        Statement stmt;
        try {
            stmt = ConnectionDB.getConnection();
            System.out.println(bookBean.getTitolo()+" BookDAO");
            Queries.insertBook(stmt, bookBean.getEmail(), bookBean.getTypeOfDisponibility(), bookBean.getTitolo(), bookBean.getAutore(), bookBean.getArgomentoString(), bookBean.getnPagine(), bookBean.getCommento());

        } catch (SQLException e) {

        } catch (ErrorInsertBookException |ErrorConnectionDbException e) {
            BoxExcpetionMessage.PopUpsExcpetionMessage(e.getMessage());
        }
    }

    public static void insertLendBook(BookBean bookBean, String username) {
        LocalDate data_start = LocalDate.now();
        LocalDate data_finish = data_start.plusMonths(2);
        String d_start = data_start.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String d_finish = data_finish.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        Statement stmt;
       try {
            stmt = ConnectionDB.getConnection();
            Queries.registerLendBook(stmt, bookBean.getId(), bookBean.getEmail(), username, d_start,d_finish);

       } catch (SQLException e) {

        } catch (ErrorInsertBookException |ErrorConnectionDbException e) {
           BoxExcpetionMessage.PopUpsExcpetionMessage(e.getMessage());
       }

    }

    public static void updateBook(BookBean bookBean){
        Statement stmt;
        try
        {
            stmt=ConnectionDB.getConnection();
            Queries.updateBook(stmt,bookBean.getId(),bookBean.getTypeOfDisponibility(),bookBean.getTitolo(),bookBean.getAutore(),bookBean.getArgomentoString(), bookBean.getnPagine(), bookBean.getCommento());

        }catch (SQLException e) {
            e.printStackTrace();
        } catch (ErrorUpdateBookException |ErrorConnectionDbException e) {
            BoxExcpetionMessage.PopUpsExcpetionMessage(e.getMessage());
        }
    }

    public static void removeBook(int id)
    {
        Statement stmt;
        try
        {
            stmt=ConnectionDB.getConnection();
            Queries.removeBook(stmt,String.valueOf(id));

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ErrorRemoveBookException|ErrorConnectionDbException e) {
            BoxExcpetionMessage.PopUpsExcpetionMessage(e.getMessage());
        }
    }
}