package com.ispw.circularbook.engineering.dao;


import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.bean.LenderBookBean;
import com.ispw.circularbook.engineering.bean.RegistrationBookBean;
import com.ispw.circularbook.engineering.connection.ConnectionDB;
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


    public static void insertBook(RegistrationBookBean registrationBookBean) {
        Statement stmt;
        try {
            stmt = ConnectionDB.getConnection();
            Queries.insertBook(stmt, registrationBookBean.getEmail(), registrationBookBean.getTypeOfDisponibility(), registrationBookBean.getTitle(), registrationBookBean.getAuthor(), registrationBookBean.getArgument(), registrationBookBean.getNPageInt(), registrationBookBean.getComment());

        } catch (SQLException e) {

        } catch (ErrorInsertBookException |ErrorConnectionDbException e) {
            BoxExcpetionMessage.PopUpsExcpetionMessage(e.getMessage());
        }
    }

    public static void insertLendBook(LenderBookBean lenderBookBean) {
        Statement stmt;
       try {
            stmt = ConnectionDB.getConnection();
            Queries.registerLendBook(stmt, lenderBookBean.getId(), lenderBookBean.getEmail(), lenderBookBean.getUsername(), lenderBookBean.getDateStart(), lenderBookBean.getDateFinish());

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
            Queries.updateBook(stmt,bookBean.getId(),bookBean.getTypeOfDisponibility(),bookBean.getTitolo(),bookBean.getAutore(),bookBean.getArgomentoString(), bookBean.getNPagineInt(), bookBean.getCommento());

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