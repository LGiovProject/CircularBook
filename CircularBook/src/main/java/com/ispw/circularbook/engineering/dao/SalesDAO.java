package com.ispw.circularbook.engineering.dao;

import com.ispw.circularbook.engineering.bean.SalesBean;
import com.ispw.circularbook.engineering.bean.SearchSalesBean;
import com.ispw.circularbook.engineering.connection.ConnectionDB;
import com.ispw.circularbook.engineering.dao.queries.Queries;
import com.ispw.circularbook.engineering.exception.ErrorConnectionDbException;
import com.ispw.circularbook.model.SalesModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class SalesDAO {
    public static List<SalesModel> searchSales(SearchSalesBean searchSalesBean) {

            Statement stmt;
            ResultSet resultSet;
            List<SalesModel> salesModelList= new ArrayList<>();
            try {
                stmt = ConnectionDB.getConnection();
                resultSet= Queries.searchSales(stmt, searchSalesBean.getNameLib(),searchSalesBean.getMonth(),searchSalesBean.getTypeOfSales());
                if(!resultSet.first())
                {
                }

                resultSet.next();
                // Riposiziono il cursore sul primo record del result set
                resultSet.first();
                do{
                    SalesModel salesModel = new SalesModel();
                    salesModel.setId(resultSet.getInt(1));
                    salesModel.setEmail(resultSet.getString(2));
                    salesModel.setNameLib(resultSet.getString(3));
                    salesModel.setTypeOfSales(resultSet.getInt(4));
                    salesModel.setTitle(resultSet.getString(5));
                    salesModel.setDescription(resultSet.getString(6));
                    salesModel.setDate_start(resultSet.getString(7));
                    salesModel.setDate_finish(resultSet.getString(8));
                    salesModelList.add(salesModel);
                }while (resultSet.next());

                resultSet.close();
            } catch (SQLException| ErrorConnectionDbException e) {
                e.printStackTrace();
            }

            return salesModelList;

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
                salesBean.setTitle(resultSet.getString(4));
                salesBean.setDescription(resultSet.getString(5));
                salesBean.setDateStart(resultSet.getString(6));
                salesBean.setDateFinish(resultSet.getString(7));
                salesBeanList.add(salesBean);
            }while (resultSet.next());

            resultSet.close();
        } catch (SQLException | ErrorConnectionDbException | ParseException e) {
            throw new RuntimeException(e);
        }

        return salesBeanList;

    }
    public static void insertSales(SalesBean salesBean)
    {
        Statement stmt;
        try {
            stmt=ConnectionDB.getConnection();
            Queries.insertSales(stmt,salesBean.getEmail(), salesBean.getNameLib(), salesBean.getTitlePromotion(), salesBean.getTypeOfSalesInt(), salesBean.getDescription(), salesBean.getDateStart(), salesBean.getDateFinish());
        } catch (ErrorConnectionDbException | SQLException e) {
            e.printStackTrace();
        }
    }
}
