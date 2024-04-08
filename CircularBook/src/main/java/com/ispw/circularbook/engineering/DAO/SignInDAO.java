package com.ispw.circularbook.engineering.DAO;


import com.ispw.circularbook.engineering.Connection.ConnectionDB;
import com.ispw.circularbook.engineering.DAO.Queries.Queries;
import com.ispw.circularbook.engineering.exception.ErrorConnectionDbException;
import com.ispw.circularbook.engineering.utils.BoxExcpetionMessage;
import com.ispw.circularbook.engineering.exception.EmailUsedException;
import com.ispw.circularbook.engineering.exception.ErrorRegistrationException;


import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

public class SignInDAO {

    public static void signInL(String email, String password, String nomeLib, String citta, String via, int nTel ){
        Statement stmt;
        try {
            stmt = ConnectionDB.getConnection();

           Queries.insertLogin(stmt, email, password);
           Queries.insertLibrary(stmt,email,nomeLib,citta,via,nTel);

        }catch (SQLException| ErrorConnectionDbException e)
            {
               e.printStackTrace();

            } catch (ErrorRegistrationException e) {
            BoxExcpetionMessage.PopUpsExcpetionMessage(e.getMessage());
        }
    }

    public static void signInU(String email,String username,String password, String nome, String cognome, String citta )
    {
        Statement stmt;
        try {
            stmt = ConnectionDB.getConnection();

            Queries.insertLogin(stmt, email, password);
            Queries.insertUser(stmt,email,username,nome,cognome,citta);

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

