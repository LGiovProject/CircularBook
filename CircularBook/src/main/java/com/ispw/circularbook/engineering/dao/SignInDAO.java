package com.ispw.circularbook.engineering.dao;


import com.ispw.circularbook.engineering.bean.SignInBean;
import com.ispw.circularbook.engineering.connection.ConnectionDB;
import com.ispw.circularbook.engineering.dao.Queries.Queries;
import com.ispw.circularbook.engineering.exception.ErrorConnectionDbException;
import com.ispw.circularbook.engineering.utils.BoxExcpetionMessage;
import com.ispw.circularbook.engineering.exception.EmailUsedException;
import com.ispw.circularbook.engineering.exception.ErrorRegistrationException;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

public class SignInDAO {

    public static void signInL(SignInBean signInBean){
        Statement stmt;
        try {
            stmt = ConnectionDB.getConnection();

            Queries.insertLogin(stmt, signInBean.getEmail(), signInBean.getPassword());
           Queries.insertLibrary(stmt,signInBean.getEmail(),signInBean.getNomeLib(),signInBean.getCittaString(),signInBean.getVia(),signInBean.getnTel());

        }catch (SQLException| ErrorConnectionDbException e)
            {
               e.printStackTrace();

            } catch (ErrorRegistrationException e) {
            BoxExcpetionMessage.PopUpsExcpetionMessage(e.getMessage());
        }
    }

    public static void signInU(SignInBean signInBean)
    {
        Statement stmt;
        try {
            stmt = ConnectionDB.getConnection();

            Queries.insertLogin(stmt, signInBean.getEmail(), signInBean.getPassword());
            Queries.insertUser(stmt,signInBean.getEmail(),signInBean.getUsername(),signInBean.getNome(),signInBean.getCognome(),signInBean.getCittaString());

        } catch (SQLIntegrityConstraintViolationException e)
        {
               BoxExcpetionMessage.PopUpsExcpetionMessage(e.getMessage());
        } catch ( SQLException|ErrorConnectionDbException e)
        {
            e.printStackTrace();

        } catch (ErrorRegistrationException e) {
            BoxExcpetionMessage.PopUpsExcpetionMessage(e.getMessage());
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
            e.printStackTrace();
        }
    }
}

