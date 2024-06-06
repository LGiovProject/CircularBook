package com.ispw.circularbook.engineering.dao;

import com.ispw.circularbook.engineering.bean.LibraryBean;
import com.ispw.circularbook.engineering.bean.UpdateInfoBean;
import com.ispw.circularbook.engineering.connection.ConnectionDB;
import com.ispw.circularbook.engineering.dao.queries.CRUDQueries;
import com.ispw.circularbook.engineering.dao.queries.Queries;
import com.ispw.circularbook.engineering.exception.ErrorConnectionDbException;

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
                throw new SQLException();
            }
            resultSet.first();
            libraryBean= getLibraryInfo(resultSet);
            resultSet.close();
        } catch (SQLException| ErrorConnectionDbException e) {
            throw new RuntimeException(e);
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
            CRUDQueries.updateLibrary(stmt,updateInfoBean.getEmail(),updateInfoBean.getNameLibrary(), updateInfoBean.getVia(),updateInfoBean.getNumberPhoneString(),updateInfoBean.getCityString());
        } catch (ErrorConnectionDbException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
