package com.ispw.circularbook.engineering.dao;


import com.ispw.circularbook.engineering.bean.SignInBean;
import com.ispw.circularbook.engineering.connection.ConnectionDB;
import com.ispw.circularbook.engineering.dao.queries.Queries;
import com.ispw.circularbook.engineering.exception.ErrorConnectionDbException;
import com.ispw.circularbook.engineering.exception.EmailUsedException;



import java.sql.*;

public class SignInDAO {

    public static void signInL(SignInBean signInBean){

        try {
            CallableStatement callableStatement = ConnectionDB.insertLibrary();
            callableStatement.setString(1,signInBean.getEmail());
            callableStatement.setString(2,signInBean.getPassword());
            callableStatement.setString(3,signInBean.getNomeLib());
            callableStatement.setString(4,signInBean.getCittaString());
            callableStatement.setString(5, signInBean.getVia());
            callableStatement.setString(6,signInBean.getnTel());
            callableStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void signInU(SignInBean signInBean)
    {
        try {
            CallableStatement callableStatement = ConnectionDB.insertUser();
            callableStatement.setString(1,signInBean.getEmail());
            callableStatement.setString(2,signInBean.getPassword());
            callableStatement.setString(3,signInBean.getUsername());
            callableStatement.setString(4,signInBean.getNome());
            callableStatement.setString(5, signInBean.getCognome());
            callableStatement.setString(6,signInBean.getCittaString());
            callableStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void checkEmailU(String email) throws EmailUsedException
    {
        Statement stmt;
        ResultSet resultSet;
        try {
            stmt = ConnectionDB.getConnection();

             resultSet = Queries.checkEmailU(stmt,email);
             resultSet.first();

             if(resultSet.getInt(1)==1) {
                 throw new EmailUsedException();
             }

        } catch (ErrorConnectionDbException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

