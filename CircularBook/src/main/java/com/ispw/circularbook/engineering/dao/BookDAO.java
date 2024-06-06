package com.ispw.circularbook.engineering.dao;


import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.bean.TakeBookBean;
import com.ispw.circularbook.engineering.bean.RegistrationBookBean;
import com.ispw.circularbook.engineering.connection.ConnectionDB;
import java.sql.CallableStatement;
import java.sql.SQLException;



public class BookDAO {


    public static void insertBook(RegistrationBookBean registrationBookBean) {
        try {
            CallableStatement callableStatement = ConnectionDB.insertBook();
            callableStatement.setString(1,registrationBookBean.getEmail());
            callableStatement.setInt(2,registrationBookBean.getTypeOfDisponibility());
            callableStatement.setString(3,registrationBookBean.getAuthor());
            callableStatement.setString(4,registrationBookBean.getArgument());
            callableStatement.setString(5,registrationBookBean.getTitle());
            callableStatement.setInt(6,registrationBookBean.getNPageInt());
            callableStatement.setString(7,registrationBookBean.getComment());
            callableStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static void insertLendBook(TakeBookBean takeBookBean) {

        CallableStatement callableStatement;
       try {

            if(takeBookBean.getTypeOfDisponiblity()==1) {
                callableStatement = ConnectionDB.takeLendBook();
                callableStatement.setInt(1, takeBookBean.getId());
                callableStatement.setString(2, takeBookBean.getEmailTaker());
                callableStatement.setString(3, takeBookBean.getEmailGiver());
                callableStatement.setString(4, takeBookBean.getDateStart());
                callableStatement.setString(5, takeBookBean.getDateFinish());
                callableStatement.execute();

            }
            else
            {
                callableStatement = ConnectionDB.takeGiftBook();
                callableStatement.setInt(1, takeBookBean.getId());
                callableStatement.setString(2, takeBookBean.getEmailTaker());
                callableStatement.setString(3, takeBookBean.getEmailGiver());
                callableStatement.setString(4, takeBookBean.getDateStart());
                callableStatement.execute();

            }
       } catch (SQLException e) {
            throw  new RuntimeException(e);
       }

    }

    public static void updateBook(BookBean bookBean){

        try {
            CallableStatement callableStatement = ConnectionDB.updateBook();
            callableStatement.setInt(1,bookBean.getId());
            callableStatement.setInt(2,bookBean.getTypeOfDisponibility());
            callableStatement.setString(3, bookBean.getAutore());
            callableStatement.setString(4, bookBean.getArgomentoString());
            callableStatement.setString(5, bookBean.getTitolo());
            callableStatement.setInt(6,bookBean.getNPagineInt());
            callableStatement.setString(7,bookBean.getCommento());
            callableStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void removeBook(int id)
    {
        try {
            CallableStatement callableStatement = ConnectionDB.removeBook();
            callableStatement.setInt(1,id);
            callableStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}