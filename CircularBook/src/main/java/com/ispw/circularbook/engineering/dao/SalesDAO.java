package com.ispw.circularbook.engineering.DAO;

import com.ispw.circularbook.engineering.Connection.ConnectionDB;
import com.ispw.circularbook.engineering.DAO.Queries.Queries;
import com.ispw.circularbook.engineering.exception.ErrorConnectionDbException;
import com.ispw.circularbook.model.SalesModel;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SalesDAO {
    public static List<SalesModel> searchSales(String nameLib,Integer month,Integer typeOfSales) {

            Statement stmt;
            ResultSet resultSet;
            List<SalesModel> salesModelList= new ArrayList<>();
            try {
                stmt = ConnectionDB.getConnection();
                resultSet= Queries.searchSales(stmt,nameLib,month,typeOfSales);
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
    public static List<SalesModel> searchSales(String email) {

        Statement stmt;
        ResultSet resultSet;
        List<SalesModel> salesModelList= new ArrayList<>();
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
        } catch (SQLException|ErrorConnectionDbException e) {
            e.printStackTrace();
        }

        return salesModelList;

    }
    public static void insertSales(String email,String nameLib,String title,int typeOfSales,String description,String dateStart,String dateFinish)
    {
        Statement stmt;
        System.out.println(dateStart);
        System.out.println(dateFinish);
        try {
            stmt=ConnectionDB.getConnection();
            Queries.insertSales(stmt,email,nameLib,title,typeOfSales,description,dateStart,dateFinish);
        } catch (ErrorConnectionDbException | SQLException e) {
            e.printStackTrace();
        }
    }
}
