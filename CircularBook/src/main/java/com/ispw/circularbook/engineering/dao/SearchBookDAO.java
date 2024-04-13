package com.ispw.circularbook.engineering.dao;

import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.connection.ConnectionDB;
import com.ispw.circularbook.engineering.dao.Queries.Queries;
import com.ispw.circularbook.engineering.exception.*;
import com.ispw.circularbook.engineering.utils.BoxExcpetionMessage;
import com.ispw.circularbook.model.BookModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SearchBookDAO {

    public static List<BookBean> searchBook(String author, String argument, String title, String email) {
        Statement stmt;
        ResultSet resultSet;
        List<BookBean> listBookBean= new ArrayList<>();

        try{
            stmt= ConnectionDB.getConnection();
            resultSet=Queries.searchBook(stmt,author,argument,title,email);

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
                    bookBean.setTypeOfDisponibility(resultSet.getInt(3));
                    bookBean.setAutore(resultSet.getString(4));
                    bookBean.setArgomento(resultSet.getString(5));
                    bookBean.setTitolo(resultSet.getString(6));
                    bookBean.setnPagine(resultSet.getInt(7));
                    bookBean.setCommento(resultSet.getString(8));

                    listBookBean.add(bookBean);
                } while (resultSet.next());







            resultSet.close();

        } catch (NoBookFoundException| ErrorConnectionDbException |SQLException e) {
            e.printStackTrace();
        }
        return listBookBean;
    }
    public static List<BookBean> searchMyBook(String email) {
        Statement stmt;
        ResultSet resultSet;
        List<BookBean> listBookBean= new ArrayList<>();
        try{
            stmt= ConnectionDB.getConnection();
            resultSet=Queries.searchMyBook(stmt,email);

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
                bookBean.setEmail(resultSet.getString(2));
                bookBean.setTypeOfDisponibility(resultSet.getInt(3));
                bookBean.setAutore(resultSet.getString(4));
                bookBean.setArgomento(resultSet.getString(5));
                bookBean.setTitolo(resultSet.getString(6));
                bookBean.setnPagine(resultSet.getInt(7));
                bookBean.setCommento(resultSet.getString(8));
                listBookBean.add(bookBean);
            } while (resultSet.next());







            resultSet.close();

        } catch (ErrorConnectionDbException |SQLException e) {
            e.printStackTrace();
        }catch (NoBookRegisteredException e)
        {
            BoxExcpetionMessage.PopUpsExcpetionMessage(e.getMessage());
        }
        return listBookBean;
    }
    public static BookBean searchBook(int id){

        Statement stmt;
        ResultSet resultSet;
        BookBean bookBean = new BookBean();
        try{
        stmt=ConnectionDB.getConnection();
        resultSet = Queries.searchBookById(stmt,id);



            if(!resultSet.first())
            {
                throw new NoBookFoundException();

            }

            resultSet.next();
            // Riposiziono il cursore sul primo record del result set
            resultSet.first();

            bookBean.setId(resultSet.getInt(1));
            bookBean.setEmail(resultSet.getString(2));
            bookBean.setTypeOfDisponibility(resultSet.getInt(3));
            bookBean.setAutore(resultSet.getString(4));
            bookBean.setArgomento(resultSet.getString(5));
            bookBean.setTitolo(resultSet.getString(6));
            bookBean.setnPagine(resultSet.getInt(7));
            bookBean.setCommento(resultSet.getString(8));
        }catch (ErrorConnectionDbException| NoBookFoundException | SQLException e){
            e.printStackTrace();
        };
        return bookBean;
    }

    public static List<BookBean> searchLendedBook (String email) throws NoBookLendedException
    {
        {
            Statement stmt;
            ResultSet resultSet;
            List<BookBean> listBookBean= new ArrayList<>();
            try{
                stmt= ConnectionDB.getConnection();
                resultSet=Queries.searchLendedBook(stmt,email);

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
                    bookBean.setEmail(resultSet.getString(2));
                    bookBean.setTypeOfDisponibility(resultSet.getInt(3));
                    bookBean.setAutore(resultSet.getString(4));
                    bookBean.setArgomento(resultSet.getString(5));
                    bookBean.setTitolo(resultSet.getString(6));
                    bookBean.setnPagine(resultSet.getInt(7));
                    bookBean.setCommento(resultSet.getString(8));
                    bookBean.setDate_start(resultSet.getString(9));
                    String buffer =resultSet.getString(10);
                    bookBean.setDate_finish(buffer);
                    bookBean.setDaysRemaing(buffer);
                    bookBean.setEmailGiver(resultSet.getString(11));
                    listBookBean.add(bookBean);
                } while (resultSet.next());

                resultSet.close();

            } catch (ErrorConnectionDbException  |SQLException e) {
                e.printStackTrace();
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
                bookBean.setEmail(resultSet.getString(2));
                bookBean.setTypeOfDisponibility(resultSet.getInt(3));
                bookBean.setAutore(resultSet.getString(4));
                bookBean.setArgomento(resultSet.getString(5));
                bookBean.setTitolo(resultSet.getString(6));
                bookBean.setnPagine(resultSet.getInt(7));
                bookBean.setCommento(resultSet.getString(8));
                bookBean.setDate_start(resultSet.getString(9));
                String buffer =resultSet.getString(10);
                bookBean.setDate_finish(buffer);
                bookBean.setDaysRemaing(buffer);
                bookBean.setEmailTaker(resultSet.getString(11));
                listBookBean.add(bookBean);
            } while (resultSet.next());

            resultSet.close();

        } catch (ErrorConnectionDbException  |SQLException e) {
            e.printStackTrace();
        }
        return listBookBean;
    }

    public static int[] searchBookUserInfo(String email)  {
        Statement stmt;
        int[] infoBook= new int[5];
        ResultSet resultSet;
        try {
            stmt = ConnectionDB.getConnection();
            resultSet=Queries.searchBookUserInfo(stmt, email);
            if(!resultSet.first())
            {
                throw new NoBookInfoException();

            }

            resultSet.next();
            // Riposiziono il cursore sul primo record del result set
            resultSet.first();

                for(int i=0;i<5;i++) {
                    infoBook[i] = resultSet.getInt(i+1);
                }

        }catch (ErrorConnectionDbException | SQLException e)
        {
            e.printStackTrace();
        } catch (NoBookInfoException e) {
            BoxExcpetionMessage.PopUpsExcpetionMessage(e.getMessage());
        }
        return infoBook;
    }

    public static int[] searchBookLibraryInfo(String email)
    {
        Statement stmt;
        int[] infoBook= new int[2];
        ResultSet resultSet;
        try {
            stmt = ConnectionDB.getConnection();
            resultSet=Queries.searchBookLibraryInfo(stmt, email);
            if(!resultSet.first())
            {
                throw new NoBookInfoException();

            }

            resultSet.next();
            // Riposiziono il cursore sul primo record del result set
            resultSet.first();

            for(int i=0;i<2;i++) {
                infoBook[i] = resultSet.getInt(i+1);
            }

        }catch (ErrorConnectionDbException | SQLException e)
        {
            e.printStackTrace();
        } catch (NoBookInfoException e) {
            BoxExcpetionMessage.PopUpsExcpetionMessage(e.getMessage());
        }
        return infoBook;
    }
}


