package com.ispw.circularbook.engineering.dao;

import com.ispw.circularbook.engineering.bean.LibraryBean;
import com.ispw.circularbook.engineering.bean.UpdateInfoBean;
import com.ispw.circularbook.engineering.connection.ConnectionDB;
import com.ispw.circularbook.engineering.dao.Queries.Queries;
import com.ispw.circularbook.engineering.exception.ErrorConnectionDbException;
import com.ispw.circularbook.model.LibraryModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LibraryDAO {

    public static LibraryBean searchLibraryByEmail(String email)
    {
        Statement stmt;
        LibraryBean libraryBean = new LibraryBean();
        try
        {
            stmt= ConnectionDB.getConnection();
            ResultSet resultSet = Queries.searchLibraryByEmail(stmt,email);
            if(!resultSet.first()) {
                throw new SQLException("errore");
            }
            resultSet.first();
            libraryBean= getLibraryInfo(resultSet);
            resultSet.close();
        } catch (SQLException| ErrorConnectionDbException e) {
            e.printStackTrace();
        }
        return libraryBean;
    }

    private static LibraryBean getLibraryInfo(ResultSet resultSet) throws SQLException {
        return new LibraryBean(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getInt(5));

    }

    public static void updateLibrary(UpdateInfoBean updateInfoBean)
    {
        Statement stmt;
        try
        {
            stmt=ConnectionDB.getConnection();
            Queries.updateLibrary(stmt,updateInfoBean.getEmail(),updateInfoBean.getCamp(), updateInfoBean.getNewValue());
        } catch (ErrorConnectionDbException | SQLException e) {
            e.printStackTrace();
        }
    }
}
