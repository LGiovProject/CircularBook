package com.ispw.circularbook.engineering.dao;

import com.ispw.circularbook.engineering.Connection.ConnectionDB;
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

    public static List<BookModel> searchBook(String author, String argument, String title,String email) {
        Statement stmt;
        ResultSet resultSet;
        List<BookModel> listBookModel= new ArrayList<>();

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
                    BookModel bookModel = new BookModel();
                    bookModel.setId(resultSet.getInt(1));
                    bookModel.setEmail(resultSet.getString(2));
                    bookModel.setTypeOfDisponibility(resultSet.getInt(3));
                    bookModel.setAutore(resultSet.getString(4));
                    bookModel.setArgomento(resultSet.getString(5));
                    bookModel.setTitolo(resultSet.getString(6));
                    bookModel.setnPagine(resultSet.getInt(7));
                    bookModel.setCommento(resultSet.getString(8));

                    listBookModel.add(bookModel);
                } while (resultSet.next());







            resultSet.close();

        } catch (NoBookFoundException| ErrorConnectionDbException |SQLException e) {
            e.printStackTrace();
        }
        return listBookModel;
    }
    public static List<BookModel> searchMyBook(String email) {
        Statement stmt;
        ResultSet resultSet;
        List<BookModel> listBookModel= new ArrayList<>();
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
                BookModel bookModel = new BookModel();
                bookModel.setId(resultSet.getInt(1));
                bookModel.setEmail(resultSet.getString(2));
                bookModel.setTypeOfDisponibility(resultSet.getInt(3));
                bookModel.setAutore(resultSet.getString(4));
                bookModel.setArgomento(resultSet.getString(5));
                bookModel.setTitolo(resultSet.getString(6));
                bookModel.setnPagine(resultSet.getInt(7));
                bookModel.setCommento(resultSet.getString(8));
                listBookModel.add(bookModel);
            } while (resultSet.next());







            resultSet.close();

        } catch (ErrorConnectionDbException |SQLException e) {
            e.printStackTrace();
        }catch (NoBookRegisteredException e)
        {
            BoxExcpetionMessage.PopUpsExcpetionMessage(e.getMessage());
        }
        return listBookModel;
    }
    public static BookModel searchBook(int id){

        Statement stmt;
        ResultSet resultSet;
        BookModel bookModel = new BookModel();
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

            bookModel.setId(resultSet.getInt(1));
            bookModel.setEmail(resultSet.getString(2));
            bookModel.setTypeOfDisponibility(resultSet.getInt(3));
            bookModel.setAutore(resultSet.getString(4));
            bookModel.setArgomento(resultSet.getString(5));
            bookModel.setTitolo(resultSet.getString(6));
            bookModel.setnPagine(resultSet.getInt(7));
            bookModel.setCommento(resultSet.getString(8));
        }catch (ErrorConnectionDbException| NoBookFoundException | SQLException e){
            e.printStackTrace();
        };
        return bookModel;
    }

    public static List<BookModel> searchLendedBook (String email) throws NoBookLendedException
    {
        {
            Statement stmt;
            ResultSet resultSet;
            List<BookModel> listBookModel= new ArrayList<>();
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
                    BookModel bookModel = new BookModel();
                    bookModel.setId(resultSet.getInt(1));
                    bookModel.setEmail(resultSet.getString(2));
                    bookModel.setTypeOfDisponibility(resultSet.getInt(3));
                    bookModel.setAutore(resultSet.getString(4));
                    bookModel.setArgomento(resultSet.getString(5));
                    bookModel.setTitolo(resultSet.getString(6));
                    bookModel.setnPagine(resultSet.getInt(7));
                    bookModel.setCommento(resultSet.getString(8));
                    bookModel.setDate_start(resultSet.getString(9));
                    String buffer =resultSet.getString(10);
                    bookModel.setDate_finish(buffer);
                    bookModel.setDaysRemaing(buffer);
                    bookModel.setEmailGiver(resultSet.getString(11));
                    listBookModel.add(bookModel);
                } while (resultSet.next());

                resultSet.close();

            } catch (ErrorConnectionDbException  |SQLException e) {
                e.printStackTrace();
            }
            return listBookModel;
        }
    }
    public static List<BookModel> searchGivenBook(String email) throws NoBookLendedException {
        Statement stmt;
        ResultSet resultSet;
        List<BookModel> listBookModel= new ArrayList<>();
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
                BookModel bookModel = new BookModel();
                bookModel.setId(resultSet.getInt(1));
                bookModel.setEmail(resultSet.getString(2));
                bookModel.setTypeOfDisponibility(resultSet.getInt(3));
                bookModel.setAutore(resultSet.getString(4));
                bookModel.setArgomento(resultSet.getString(5));
                bookModel.setTitolo(resultSet.getString(6));
                bookModel.setnPagine(resultSet.getInt(7));
                bookModel.setCommento(resultSet.getString(8));
                bookModel.setDate_start(resultSet.getString(9));
                String buffer =resultSet.getString(10);
                bookModel.setDate_finish(buffer);
                bookModel.setDaysRemaing(buffer);
                bookModel.setEmailTaker(resultSet.getString(11));
                listBookModel.add(bookModel);
            } while (resultSet.next());

            resultSet.close();

        } catch (ErrorConnectionDbException  |SQLException e) {
            e.printStackTrace();
        }
        return listBookModel;
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


