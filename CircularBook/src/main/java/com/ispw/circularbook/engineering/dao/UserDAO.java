package com.ispw.circularbook.engineering.dao;

import com.ispw.circularbook.engineering.connection.ConnectionDB;
import com.ispw.circularbook.engineering.dao.Queries.Queries;
import com.ispw.circularbook.engineering.exception.ErrorConnectionDbException;
import com.ispw.circularbook.model.UserModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {

    public static UserModel searchUserByEmail(String email)
    {
        Statement stmt;
        UserModel userModel=null;

        try {
            stmt = ConnectionDB.getConnection();

            ResultSet resultSet =Queries.searchUserByMail(stmt,email);
            if(!resultSet.first()) {
                throw new SQLException("errore");
            }
             resultSet.first();
             userModel=getUserInfo(resultSet);
             resultSet.close();
        }catch (SQLException| ErrorConnectionDbException e) {
            System.out.println(e);
        }
        return userModel;
    }

    public static void updateUser(String email,String camp,String newCamp)
    {
        Statement stmt;
        try
        {
            stmt=ConnectionDB.getConnection();
            Queries.updateUser(stmt,email,camp,newCamp);
        } catch (ErrorConnectionDbException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static UserModel getUserInfo(ResultSet resultSet) throws SQLException {

        UserModel userModel;
        userModel = new UserModel(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5));


        return userModel;
    }


}
