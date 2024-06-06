package com.ispw.circularbook.engineering.dao;

import com.ispw.circularbook.engineering.bean.UpdateInfoBean;
import com.ispw.circularbook.engineering.bean.UserBean;
import com.ispw.circularbook.engineering.connection.ConnectionDB;
import com.ispw.circularbook.engineering.dao.queries.CRUDQueries;
import com.ispw.circularbook.engineering.dao.queries.Queries;
import com.ispw.circularbook.engineering.exception.ErrorConnectionDbException;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {

    public static UserBean searchUserByEmail(String email)
    {
        Statement stmt;
        UserBean userBean;

        try {
            stmt = ConnectionDB.getConnection();

            ResultSet resultSet =Queries.searchUserByMail(stmt,email);
            if(!resultSet.first()) {
                throw new SQLException("errore");
            }
             resultSet.first();
             userBean = new UserBean(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5));


            resultSet.close();
        }catch (SQLException| ErrorConnectionDbException e) {
            throw new RuntimeException(e);
        }
        return userBean;
    }

    public static void updateUser(UpdateInfoBean updateInfoBean)
    {
        Statement stmt;
        try
        {
            stmt=ConnectionDB.getConnection();
            CRUDQueries.updateUser(stmt,updateInfoBean.getEmail(),updateInfoBean.getNameUser(), updateInfoBean.getSurname(), updateInfoBean.getUsername(), updateInfoBean.getCityString());
        } catch (ErrorConnectionDbException | SQLException e) {
            throw new RuntimeException(e);
        }
//        try {
//            CallableStatement callableStatement = ConnectionDB.updateUser();
//            callableStatement.setString(1,updateInfoBean.getEmail());
//            callableStatement.setString(2,updateInfoBean.getUsername());
//            callableStatement.setString(3,updateInfoBean.getNameUser());
//            callableStatement.setString(4,updateInfoBean.getSurname());
//            callableStatement.setString(5, updateInfoBean.getCityString());
//            callableStatement.execute();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

    }

//    private static UserBean getUserInfo(ResultSet resultSet) throws SQLException {
//
//        UserBean userBean;
//        userBean = new UserBean(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5));
//
//
//        return userBean;
//    }


}
