package com.ispw.circularbook.engineering.dao;

import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.bean.InfoBookBean;
import com.ispw.circularbook.engineering.bean.SearchBookBean;
import com.ispw.circularbook.engineering.bean.UserBean;
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

    public static List<BookBean> searchBook(SearchBookBean searchBookBean) {
        Statement stmt;
        ResultSet resultSet;
        List<BookBean> listBookBean= new ArrayList<>();

        try{
            stmt= ConnectionDB.getConnection();
            resultSet=Queries.searchBook(stmt,searchBookBean);

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

    public static List<BookBean> searchLendedBook (UserBean userBean) throws NoBookLendedException
    {
        {
            Statement stmt;
            ResultSet resultSet;
            List<BookBean> listBookBean= new ArrayList<>();
            try{
                stmt= ConnectionDB.getConnection();
                resultSet=Queries.searchLendedBook(stmt,userBean);

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

    public static InfoBookBean searchBookUserInfo(String email)  {
        Statement stmt;
        InfoBookBean infoBookBean = new InfoBookBean();
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

            infoBookBean.setRegisterBook( resultSet.getInt(1));
            infoBookBean.setLendedBook(resultSet.getInt(2));
            infoBookBean.setGiftedBook(resultSet.getInt(3));
            infoBookBean.setLendedBookTaked(resultSet.getInt(4));
            infoBookBean.setGiftedBooktaked(resultSet.getInt(5));


        }catch (ErrorConnectionDbException | SQLException e)
        {
            e.printStackTrace();
        } catch (NoBookInfoException e) {
            BoxExcpetionMessage.PopUpsExcpetionMessage(e.getMessage());
        }
        return infoBookBean;
    }

    public static InfoBookBean searchBookLibraryInfo(String email)
    {
        Statement stmt;
        InfoBookBean infoBookBean = new InfoBookBean();
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

            infoBookBean.setRegisterBook( resultSet.getInt(1));
            infoBookBean.setLendedBook(resultSet.getInt(2));

        }catch (ErrorConnectionDbException | SQLException e)
        {
            e.printStackTrace();
        } catch (NoBookInfoException e) {
            BoxExcpetionMessage.PopUpsExcpetionMessage(e.getMessage());
        }
        return infoBookBean;
    }
}


