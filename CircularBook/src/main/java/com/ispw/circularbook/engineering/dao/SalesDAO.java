package com.ispw.circularbook.engineering.dao;

import com.ispw.circularbook.engineering.bean.SalesBean;
import com.ispw.circularbook.engineering.bean.SearchSalesBean;
import com.ispw.circularbook.engineering.connection.ConnectionDB;
import com.ispw.circularbook.engineering.dao.queries.CRUDQueries;
import com.ispw.circularbook.engineering.dao.queries.Queries;
import com.ispw.circularbook.engineering.exception.ErrorConnectionDbException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class SalesDAO {
    public static List<SalesBean> searchSales(SearchSalesBean searchSalesBean) {

            Statement stmt;
            ResultSet resultSet;
            List<SalesBean> salesBeanList= new ArrayList<>();
            try {
                stmt = ConnectionDB.getConnection();
                resultSet= Queries.searchSales(stmt, searchSalesBean);
                if(!resultSet.first())
                {
                }

                resultSet.next();
                // Riposiziono il cursore sul primo record del result set
                resultSet.first();
                do{
                    SalesBean salesBean = new SalesBean();
                    salesBean.setId(resultSet.getInt(1));
                    salesBean.setEmail(resultSet.getString(2));
                    salesBean.setNameLib(resultSet.getString(3));
                    salesBean.setTypeOfSales(resultSet.getInt(4));
                    salesBean.setTitlePromotion(resultSet.getString(5));
                    salesBean.setDescription(resultSet.getString(6));
                    salesBean.setDateStart(resultSet.getString(7));
                    salesBean.setDateFinish(resultSet.getString(8));
                    salesBeanList.add(salesBean);
                }while (resultSet.next());

                resultSet.close();
            } catch (SQLException | ErrorConnectionDbException  e) {
                throw  new RuntimeException(e);
            }

        return salesBeanList;

    }

    public static List<SalesBean> searchSales(String email) {

        Statement stmt;
        ResultSet resultSet;
        List<SalesBean> salesBeanList= new ArrayList<>();
        try {
            stmt = ConnectionDB.getConnection();
            resultSet= Queries.searchSales(stmt,email);
            if(!resultSet.first())
            {
            }

            resultSet.next();
            // Riposiziono il cursore sul primo record del result set
            resultSet.first();
            do{
                SalesBean salesBean = new SalesBean();
                salesBean.setId(resultSet.getInt(1));
                salesBean.setEmail(resultSet.getString(2));
                salesBean.setTypeOfSales(resultSet.getInt(3));
                salesBean.setTitlePromotion(resultSet.getString(4));
                salesBean.setDescription(resultSet.getString(5));
                salesBean.setDateStart(resultSet.getString(6));
                salesBean.setDateFinish(resultSet.getString(7));
                salesBeanList.add(salesBean);
            }while (resultSet.next());

            resultSet.close();
        } catch (SQLException | ErrorConnectionDbException e) {
            throw new RuntimeException(e);
        }

        return salesBeanList;

    }

    public static void insertSales(SalesBean salesBean){
        Statement stmt;
        try {
            stmt=ConnectionDB.getConnection();
            CRUDQueries.insertSales(stmt,salesBean.getEmail(), salesBean.getTitlePromotion(), salesBean.getTypeOfSalesInt(), salesBean.getDescription(), salesBean.getDateStart(), salesBean.getDateFinish());
        } catch (ErrorConnectionDbException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateSales(SalesBean salesBean) {
        Statement stmt;
        try {
            stmt=ConnectionDB.getConnection();
            CRUDQueries.updateSales(stmt,salesBean.getId(), salesBean.getNameLib(),salesBean.getDescription(), salesBean.getDateStart(), salesBean.getDateFinish());
        }catch (ErrorConnectionDbException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void removeSales(SalesBean salesBean){

        Statement stmt;
        try {
            stmt=ConnectionDB.getConnection();
            CRUDQueries.removeSales(stmt,salesBean.getId());
        } catch (ErrorConnectionDbException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
