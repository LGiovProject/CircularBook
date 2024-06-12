/*
 *    Copyright (C) 2022 Guglielmo De Angelis (a.k.a. Gulyx)
 *
 *    This file is part of the contents developed for the course
 * 	  ISPW (A.Y. 2022-2023) at Università di Tor Vergata in Rome.
 *
 *    This is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU Lesser General Public License as
 *    published by the Free Software Foundation, either version 3 of the
 *    License, or (at your option) any later version.
 *
 *    This software is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU Lesser General Public License for more details.
 *
 *    You should have received a copy of the GNU Lesser General Public License
 *    along with this source.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package com.ispw.circularbook.engineering.dao.queries;

import com.ispw.circularbook.engineering.bean.SearchBookBean;
import com.ispw.circularbook.engineering.bean.SearchSalesBean;
import com.ispw.circularbook.engineering.bean.UserBean;
import com.ispw.circularbook.engineering.exception.ErrorInsertBookException;
import com.ispw.circularbook.engineering.exception.ErrorRegistrationException;
import com.ispw.circularbook.engineering.exception.ErrorRemoveBookException;
import com.ispw.circularbook.engineering.exception.ErrorUpdateBookException;
import com.ispw.circularbook.engineering.utils.MessageSupport;

import java.sql.*;

public class Queries {
        //costruttore privato
        private Queries() {}

        public static ResultSet checkLogin(Statement stmt, String email, String password) throws SQLException {
        String sql = "SELECT CASE WHEN EXISTS (SELECT email FROM users WHERE email IN (SELECT email FROM login WHERE email = '" + email + "' AND password='" + password + "')) THEN 1 WHEN EXISTS (SELECT email FROM library WHERE email IN (SELECT email FROM login WHERE email = '" + email + "' AND password='" + password + "')) THEN 2 END" ;

        return stmt.executeQuery(sql);

        }

        public static ResultSet checkEmailU(Statement stmt, String email) throws SQLException {
            String sql="SELECT COUNT(*) FROM users WHERE email='"+email+"';";
            return stmt.executeQuery(sql);
        }

        public static void insertUser(Statement stmt, String email,String username,String nome, String cognome, String citta) throws SQLException, ErrorRegistrationException {

            String sql = "INSERT INTO users (email,username,nome,cognome,citta) VALUES ('"+email+"',\""+username+"\",\""+nome+"\",\""+cognome+"\",'"+citta+"')";
            if(stmt.executeUpdate(sql)==0)
                throw new ErrorRegistrationException();
        }

        public static void insertLibrary(Statement stmt,String email, String nomeLib,String citta,String via, int ntel) throws SQLException, ErrorRegistrationException {

            String sql = "INSERT INTO library (email, nomeLib,citta,via, ntel) VALUES ('"+email+"',\""+nomeLib+"\",'"+citta+"',\""+via+"\", "+ntel+")";
            if(stmt.executeUpdate(sql)==0)
                throw new ErrorRegistrationException();

        }
        public static void insertLogin(Statement stmt,String email,String password) throws SQLException, ErrorRegistrationException {
            String sql="INSERT INTO login (email,password) VALUES('"+email+"','"+password+"')";
            if(stmt.executeUpdate(sql)==0)
                throw new ErrorRegistrationException();
        }

        public static void insertBook(Statement stmt,String email,int type, String title,String author,String argument, int nPages,String comment) throws SQLException, ErrorInsertBookException {
            System.out.println("Ci sono entrato...");
            System.out.println("\n|mail: "+email+" |type: "+type+" |title: "+title+" |author: "+author+" |argument: "+argument+" |npage: "+nPages+" |comment: "+comment +"  queries insertBook\n");
            String sql ="INSERT INTO book (email,type_of_disponibility,title,author,argument,npag,comment) VALUES('"+email+"',"+type+",\""+title+"\",\""+author+"\",'"+argument+"',"+nPages+", \""+comment+"\");" ;
            if(stmt.executeUpdate(sql)==0)
                throw new ErrorInsertBookException();

        }

        public static void insertNotify(Statement stmt, String emailSender, String emailReceiver, String message, int id_book) throws SQLException {
            String sql="INSERT INTO alert (emailSender,emailReceiver,message,id_book) VALUES('"+emailSender+"','"+emailReceiver+"','"+message+"',"+id_book+");";
            stmt.executeUpdate(sql);
        }

        public static void registerLendBook(Statement stmt,int id,String emailLender,String usernameGetter,String dateStart,String dateFinish) throws SQLException, ErrorInsertBookException {
        String sql ="INSERT INTO lended_book (id, email_lend, username_take,date_start,date_finish) VALUES("+id+",'"+emailLender+"','"+usernameGetter+"','"+dateStart+"','"+dateFinish+"');";
        if(stmt.executeUpdate(sql)==0)
            throw new ErrorInsertBookException();
        sql="UPDATE book SET type_of_disponibility=3 WHERE id="+id+";";
        if(stmt.executeUpdate(sql)==0)
            throw new ErrorInsertBookException();
        }


        public static ResultSet searchUserByMail(Statement stmt,String email) throws SQLException {
            String sql="SELECT email ,username, nome ,cognome, citta FROM users WHERE email= '"+email+"'";
            return stmt.executeQuery(sql);
        }

        public static ResultSet searchLibraryByEmail(Statement stmt,String email) throws SQLException
        {
            String sql="SELECT email , nomeLib ,citta, via, nTel FROM library WHERE email= '"+email+"'";
            return stmt.executeQuery(sql);
        }

        public static ResultSet searchAvailableBook(Statement stmt, SearchBookBean searchBookBean) throws SQLException {
            String sql="SELECT * FROM book_available_info WHERE (author = COALESCE("+searchBookBean.getAuthor()+", author) AND argument = COALESCE("+searchBookBean.getArgument()+", argument) AND title= COALESCE("+searchBookBean.getTitle()+",title)) and (email!='"+searchBookBean.getEmail()+"')";
            return stmt.executeQuery(sql);
        }

        public static ResultSet searchMyAvailableBook(Statement stmt, String email) throws SQLException {
            String sql="SELECT id,type_of_disponibility,author,argument,title,npage,comment FROM book_available_info WHERE email = '"+email+"';";
            return stmt.executeQuery(sql);
        }
        public static ResultSet searchBookById(Statement stmt,int id) throws SQLException {
            String sql="SELECT * FROM book_available_info WHERE id = "+id+";";
            return stmt.executeQuery(sql);
        }

        public static ResultSet searchTakedBook(Statement stmt,String email) throws SQLException {

            String sql="SELECT id,username_putter,author,argument,title,npage,comment,type,date_taked,date_finish from book_taked where email_take='"+email+"';";
            return stmt.executeQuery(sql);
        }

        public static ResultSet searchGivenBook(Statement stmt,String email) throws SQLException{
            String sql="SELECT id,username_take,author,argument,title,npage,comment,type,date_taked,date_finish from book_taked where email_putter='"+email+"';";
            return stmt.executeQuery(sql);
        }

        public static ResultSet searchSales(Statement stmt, SearchSalesBean searchSalesBean) throws SQLException {

            String sql="SELECT * FROM sales_info WHERE (nomeLib = COALESCE("+searchSalesBean.getNameLib()+", nomeLib)AND TypeOfSales = COALESCE("+searchSalesBean.getTypeOfSales()+" , TypeOfSales) AND month(date_start) <= COALESCE("+searchSalesBean.getMonth()+",month(date_start)) and month(date_finish)>=coalesce("+searchSalesBean.getMonth()+",month(date_finish))) ;";
            return stmt.executeQuery(sql);
        }

        public static ResultSet searchSales(Statement stmt,String email) throws SQLException {

            String sql="SELECT * FROM sales WHERE email='"+email+"' ;";
            return stmt.executeQuery(sql);
        }

        public static ResultSet searchBookUserInfo(Statement stmt, String email, String username) throws SQLException {
            String sql="SELECT count(*) as B, (SELECT count(*) from book where email='"+email+"' and type_of_disponibility=1) as B_L, (SELECT count(*) from book where email='"+email+"' and type_of_disponibility=2) as B_G,(SELECT count(*) from gifted_book where username_taker='"+username+"' ) as g_b,(select count(*) from lended_book where username_take='"+username+"' ) from book where email='"+email+"' ;";
            return stmt.executeQuery(sql);
        }

         public static ResultSet searchBookLibraryInfo(Statement stmt, String email) throws SQLException {
            String sql="SELECT count(*) as B,(select count(*) from lended_book where email_lend='"+email+"' ),(SELECT count(*) from sales where email='"+email+"' ) from book where email='"+email+"' ;";
            return stmt.executeQuery(sql);
        }

        public static ResultSet searchNotify(Statement stmt, String email) throws SQLException {

            String sql="SELECT emailSender,message ,notifyCheck FROM alert WHERE emailReceiver='"+email+"';";
            return stmt.executeQuery(sql);
        }


        public static void updateBook(Statement stmt,int id,int type, String title,String author,String argument, int nPages,String comment) throws SQLException, ErrorUpdateBookException {
            String sql="UPDATE book_data SET type_of_disponibility="+type+", author=\""+author+"\",argument='"+argument+"',title=\""+title+"\",npag="+nPages+",comment=\""+comment+"\" WHERE id="+id+";";
            if(stmt.executeUpdate(sql)==0)
                throw new ErrorUpdateBookException();
        }

        public static void updateUser(Statement stmt,String email,String camp,String newCamp) throws SQLException {
            String sql="UPDATE users SET "+camp+"='"+newCamp+"' WHERE email='"+email+"';";
            stmt.executeUpdate(sql);
        }

        public static void updateLibrary(Statement stmt,String email,String camp,String newCamp) throws SQLException {
            String sql="UPDATE library SET "+camp+"='"+newCamp+"' WHERE email='"+email+"';";
            stmt.executeUpdate(sql);
        }

        public static void removeBook(Statement stmt, String id) throws SQLException, ErrorRemoveBookException {
            String sql="DELETE FROM book WHERE id='"+id+"' and type_of_disponibility<3";
            if(stmt.executeUpdate(sql)==0)
                throw new ErrorRemoveBookException();
        }




}
