package com.ispw.circularbook.engineering.dao;

import com.ispw.circularbook.engineering.connection.ConnectionDB;
import com.ispw.circularbook.engineering.dao.Queries.Queries;
import com.ispw.circularbook.engineering.exception.ErrorConnectionDbException;
import com.ispw.circularbook.model.LibraryModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LibraryDAO {

    public static LibraryModel searchLibraryByEmail(String email)
    {
        Statement stmt;
        LibraryModel libraryModel = new LibraryModel();
        try
        {
            stmt= ConnectionDB.getConnection();
            ResultSet resultSet = Queries.searchLibraryByEmail(stmt,email);
            if(!resultSet.first()) {
                throw new SQLException("errore");
            }
            resultSet.first();
            libraryModel= getLibraryInfo(resultSet);
            resultSet.close();
        } catch (SQLException| ErrorConnectionDbException e) {
            e.printStackTrace();
        }
        return libraryModel;
    }

    private static LibraryModel getLibraryInfo(ResultSet resultSet) throws SQLException {
        LibraryModel libraryModel= new LibraryModel(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getInt(5));

        return libraryModel;
    }

    public static void updateLibrary(String email,String camp,String newCamp)
    {
        Statement stmt;
        try
        {
            stmt=ConnectionDB.getConnection();
            Queries.updateLibrary(stmt,email,camp,newCamp);
        } catch (ErrorConnectionDbException | SQLException e) {
            e.printStackTrace();
        }
    }
}
