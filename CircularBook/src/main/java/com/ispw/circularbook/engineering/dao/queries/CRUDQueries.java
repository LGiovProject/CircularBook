package com.ispw.circularbook.engineering.dao.queries;

import java.sql.SQLException;
import java.sql.Statement;

public class CRUDQueries {

    public static void updateUser(Statement stmt, String email, String camp, String newCamp) throws SQLException {
        String sql="UPDATE users SET "+camp+"='"+newCamp+"' WHERE email='"+email+"';";
        stmt.executeUpdate(sql);
    }

    public static void updateLibrary(Statement stmt,String email,String camp,String newCamp) throws SQLException {
        String sql="UPDATE library SET "+camp+"='"+newCamp+"' WHERE email='"+email+"';";
        stmt.executeUpdate(sql);
    }

    public static void updateSales(Statement stmt,int id, String name,String description,String dateStart,String dateFinish) throws SQLException {
        String sql="UPDATE sales SET nameSales="+name+", descriptionSales="+description+",date_start="+dateStart+",date_finish="+dateFinish+" WHERE id="+id+";";
        stmt.executeUpdate(sql);
    }

    public static void insertSales(Statement stmt, String email,String title,int typeOfSales,String description,String dateStart,String dateFinish) throws SQLException {
        String sql="INSERT INTO sales (email,nameSales,typeOfSales,descriptionSales,date_start,date_finish) VALUES('"+email+"',\""+title+"\","+typeOfSales+",\""+description+"\",'"+dateStart+"','"+dateFinish+"');";
        stmt.executeUpdate(sql);
    }

    public static void removeSales(Statement stmt, int id) throws SQLException {
        String sql="DELETE FROM sales WHERE id='"+id+"';";
        stmt.executeUpdate(sql);
    }
}