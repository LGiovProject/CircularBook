package com.ispw.circularbook.engineering.dao;

import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.bean.InfoBookBean;
import com.ispw.circularbook.engineering.bean.SearchBookBean;
import com.ispw.circularbook.engineering.connection.ConnectionDB;
import com.ispw.circularbook.engineering.dao.queries.Queries;
import com.ispw.circularbook.engineering.exception.*;
import com.ispw.circularbook.engineering.utils.MessageSupport;


import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SearchBookDAO {

    public static List<BookBean> searchAvailableBook(SearchBookBean searchBookBean){
        Statement stmt;
        ResultSet resultSet;
        List<BookBean> listBookBean= new ArrayList<>();

        try{
            stmt= ConnectionDB.getConnection();
            resultSet=Queries.searchAvailableBook(stmt,searchBookBean);

            if(!resultSet.first())
            {
                throw new NoBookFoundException();
            }

                resultSet.next();
                // Riposiziono il cursore sul primo record del result set
                resultSet.first();

                do {
                    BookBean bookBean = new BookBean();
                    bookBean.setId(resultSet.getInt(1));
                    bookBean.setEmail(resultSet.getString(2));
                    bookBean.setUsername(resultSet.getString(3));
                    bookBean.setTypeOfDisponibility(resultSet.getInt(4));
                    bookBean.setAutore(resultSet.getString(5));
                    bookBean.setArgomento(resultSet.getString(6));
                    bookBean.setTitolo(resultSet.getString(7));
                    bookBean.setNPagine(resultSet.getInt(8));
                    bookBean.setCommento(resultSet.getString(9));

                    listBookBean.add(bookBean);
                } while (resultSet.next());







            resultSet.close();

        } catch (ErrorConnectionDbException |SQLException e) {
            throw new RuntimeException(e);
        }catch (NoBookFoundException e) {
            MessageSupport.PopUpsExcpetionMessage("Non ci sono libri con i parametri inseriti");
        }
        return listBookBean;
    }

    public static List<BookBean> searchMyAvailableBook(String email) {
        Statement stmt;
        ResultSet resultSet;
        List<BookBean> listBookBean= new ArrayList<>();
        try{
            stmt= ConnectionDB.getConnection();
            resultSet=Queries.searchMyAvailableBook(stmt,email);

            if(!resultSet.first())
            {
                throw new NoBookRegisteredException();

            }



            resultSet.next();
            // Riposiziono il cursore sul primo record del result set
            resultSet.first();

            do {
                BookBean bookBean = new BookBean();
                bookBean.setId(resultSet.getInt(1));
                bookBean.setTypeOfDisponibility(resultSet.getInt(2));
                bookBean.setAutore(resultSet.getString(3));
                bookBean.setArgomento(resultSet.getString(4));
                bookBean.setTitolo(resultSet.getString(5));
                bookBean.setNPagine(resultSet.getInt(6));
                bookBean.setCommento(resultSet.getString(7));
                listBookBean.add(bookBean);
            } while (resultSet.next());

                resultSet.close();

        } catch (SQLException | ErrorConnectionDbException e) {
            throw new RuntimeException(e);
        }
          catch (NoBookRegisteredException e)
        {
            MessageSupport.PopUpsExcpetionMessage(e.getMessage());
        }
        return listBookBean;
    }

//    public static BookBean searchBook(int id){
//
//        Statement stmt;
//        ResultSet resultSet;
//        BookBean bookBean = new BookBean();
//        try{
//        stmt=ConnectionDB.getConnection();
//        resultSet = Queries.searchBookById(stmt,id);
//
//
//
//            if(!resultSet.first())
//            {
//                throw new NoBookFoundException();
//
//            }
//
//            resultSet.next();
//            // Riposiziono il cursore sul primo record del result set
//            resultSet.first();
//
//            bookBean.setId(resultSet.getInt(1));
//            bookBean.setEmail(resultSet.getString(2));
//            bookBean.setTypeOfDisponibility(resultSet.getInt(3));
//            bookBean.setAutore(resultSet.getString(4));
//            bookBean.setArgomento(resultSet.getString(5));
//            bookBean.setTitolo(resultSet.getString(6));
//            bookBean.setNPagine(resultSet.getInt(7));
//            bookBean.setCommento(resultSet.getString(8));
//        }catch (ErrorConnectionDbException| NoBookFoundException | SQLException e){
//            throw new RuntimeException(e);
//        }
//        return bookBean;
//    }

    public static List<BookBean> searchTakedBook (String email) throws NoBookLendedException {
        {
            Statement stmt;
            ResultSet resultSet;
            List<BookBean> listBookBean= new ArrayList<>();
            try{
                stmt= ConnectionDB.getConnection();
                resultSet=Queries.searchTakedBook(stmt,email);

                if(!resultSet.first())
                {
                    throw new NoBookLendedException();

                }

                resultSet.next();
                // Riposiziono il cursore sul primo record del result set
                resultSet.first();

                do {

                    BookBean bookBean = new BookBean();
                    bookBean.setId(resultSet.getInt(1));
                    bookBean.setUsernamePutter(resultSet.getString(2));
                    bookBean.setAutore(resultSet.getString(3));
                    bookBean.setArgomento(resultSet.getString(4));
                    bookBean.setTitolo(resultSet.getString(5));
                    bookBean.setNPagine(resultSet.getInt(6));
                    bookBean.setCommento(resultSet.getString(7));
                    bookBean.setTypeOfDisponibility(resultSet.getInt(8));
                    bookBean.setDate_start(resultSet.getString(9));
                    if(bookBean.getTypeOfDisponibility()==1) {
                        String buffer = resultSet.getString(10);
                        bookBean.setDate_finish(buffer);
                        bookBean.setDaysRemaing(buffer);
                    }
                    listBookBean.add(bookBean);

                } while (resultSet.next());

                resultSet.close();

            } catch (ErrorConnectionDbException  |SQLException e) {
                throw new RuntimeException(e);
            }
            return listBookBean;
        }
    }

    public static List<BookBean> searchGivenBook(String email) throws NoBookLendedException {
        Statement stmt;
        ResultSet resultSet;
        List<BookBean> listBookBean= new ArrayList<>();
        try{
            stmt= ConnectionDB.getConnection();
            resultSet=Queries.searchGivenBook(stmt,email);

            if(!resultSet.first())
            {
                throw new NoBookLendedException();

            }

            resultSet.next();
            // Riposiziono il cursore sul primo record del result set
            resultSet.first();

            do {
                BookBean bookBean = new BookBean();
                bookBean.setId(resultSet.getInt(1));
                bookBean.setUsernameTaker(resultSet.getString(2));
                bookBean.setAutore(resultSet.getString(3));
                bookBean.setArgomento(resultSet.getString(4));
                bookBean.setTitolo(resultSet.getString(5));
                bookBean.setNPagine(resultSet.getInt(6));
                bookBean.setCommento(resultSet.getString(7));
                bookBean.setTypeOfDisponibility(resultSet.getInt(8));
                bookBean.setDate_start(resultSet.getString(9));
                if(bookBean.getTypeOfDisponibility()==1) {
                    String buffer = resultSet.getString(10);
                    bookBean.setDate_finish(buffer);
                    bookBean.setDaysRemaing(buffer);

                }
                listBookBean.add(bookBean);
            } while (resultSet.next());

            resultSet.close();

        } catch (ErrorConnectionDbException  |SQLException e) {
            throw new RuntimeException(e);
        }
        return listBookBean;
    }

    public static InfoBookBean searchBookUserInfo(InfoBookBean infoBookBean)  {
//        Statement stmt;
//
//        ResultSet resultSet;
//        try {
//            stmt = ConnectionDB.getConnection();
//            resultSet=Queries.searchBookUserInfo(stmt, infoBookBean.getEmail(),infoBookBean.getUsername());
//            if(!resultSet.first())
//            {
//                throw new NoBookInfoException();
//
//            }
//
//            resultSet.next();
//            // Riposiziono il cursore sul primo record del result set
//            resultSet.first();
//
//            infoBookBean.setRegisterBook( resultSet.getInt(1));
//            infoBookBean.setLendedBook(resultSet.getInt(2));
//            infoBookBean.setGiftedBook(resultSet.getInt(3));
//            infoBookBean.setLendedBookTaked(resultSet.getInt(4));
//            infoBookBean.setGiftedBooktaked(resultSet.getInt(5));
//
//
//        }catch (ErrorConnectionDbException | SQLException e)
//        {
//            throw new RuntimeException(e);
//        } catch (NoBookInfoException e) {
//            MessageSupport.PopUpsExcpetionMessage(e.getMessage());
//        }

        try {
            CallableStatement callableStatement = ConnectionDB.bookInfoUser();
            callableStatement.setString(1,infoBookBean.getEmail());
            callableStatement.executeQuery();

            ResultSet resultSet= callableStatement.getResultSet();
            if(!resultSet.next())
            {
                throw new NoBookInfoException();

            }

            infoBookBean.setRegisterBook( resultSet.getInt(1));
            infoBookBean.setLendedBook(resultSet.getInt(2));
            infoBookBean.setGiftedBook(resultSet.getInt(3));
            infoBookBean.setLendedBookTaked(resultSet.getInt(4));
            infoBookBean.setGiftedBooktaked(resultSet.getInt(5));

        } catch (SQLException | NoBookInfoException e) {
            throw new RuntimeException(e);
        }


        return infoBookBean;
    }

    public static InfoBookBean searchBookLibraryInfo(InfoBookBean infoBookBean)    {
//        Statement stmt;
//        InfoBookBean infoBookBean = new InfoBookBean();
//        ResultSet resultSet;
//        try {
//            stmt = ConnectionDB.getConnection();
//            resultSet=Queries.searchBookLibraryInfo(stmt, email);
//            if(!resultSet.first())
//            {
//                throw new NoBookInfoException();
//
//            }
//
//            resultSet.next();
//            // Riposiziono il cursore sul primo record del result set
//            resultSet.first();
//
//            infoBookBean.setRegisterBook( resultSet.getInt(1));
//            infoBookBean.setLendedBook(resultSet.getInt(2));
//
//        }catch (ErrorConnectionDbException | SQLException e)
//        {
//            throw new RuntimeException(e);
//        } catch (NoBookInfoException e) {
//            MessageSupport.PopUpsExcpetionMessage(e.getMessage());
//        }

        try {
            CallableStatement callableStatement = ConnectionDB.bookInfoLibrary();
            callableStatement.setString(1,infoBookBean.getEmail());
            callableStatement.executeQuery();

            ResultSet resultSet = callableStatement.getResultSet();
            if(!resultSet.next())
                throw new NoBookInfoException();

            infoBookBean.setRegisterBook(resultSet.getInt(1));
            infoBookBean.setSalesInsert(resultSet.getInt(2));
            infoBookBean.setLendedBook(resultSet.getInt(3));
            infoBookBean.setGiftedBook(resultSet.getInt(4));

        } catch (SQLException | NoBookInfoException e) {
            throw new RuntimeException(e);
        }
        return infoBookBean;
    }
}


