package com.ispw.circularbook.engineering.dao;

import com.ispw.circularbook.engineering.bean.NotifyBean;
import com.ispw.circularbook.engineering.connection.ConnectionDB;
import com.ispw.circularbook.engineering.dao.Queries.Queries;
import com.ispw.circularbook.engineering.exception.ErrorConnectionDbException;
import com.ispw.circularbook.engineering.exception.NoNotifyFoundException;
import com.ispw.circularbook.model.NotifyModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NotifyDAO {

    public static void insertNotify(NotifyBean notifyBean) {
        NotifyModel notifyModel = new NotifyModel(notifyBean.getEmailSender(),notifyBean.getEmailReceiver(),notifyBean.getMessage(),notifyBean.isNotifyCheck(),notifyBean.getId_book());
        try {
            Statement stmt;
            stmt = ConnectionDB.getConnection();
            Queries.insertNotify(stmt, notifyModel.getEmailSender(), notifyModel.getEmailReceiver(), notifyBean.getMessage(), notifyBean.getId_book());
        } catch (SQLException| ErrorConnectionDbException e) {
            e.printStackTrace();

        }
    }

    public static List<NotifyModel> searchNotify(String email)
    {
        ResultSet resultSet;
        List<NotifyModel> notifyModelList = new ArrayList<>();
        try {
        Statement stmt;
        stmt = ConnectionDB.getConnection();
        resultSet=Queries.searchNotify(stmt,email);
        if(!resultSet.first()) {
            throw new NoNotifyFoundException();
        }

        resultSet.first();
        NotifyModel notifyModel = new NotifyModel();
        notifyModel.setEmailSender(resultSet.getString(1));
        notifyModel.setMessage(resultSet.getString(2));
        notifyModel.setNotifyCheck(resultSet.getBoolean(3));
        notifyModelList.add(notifyModel);
        resultSet.close();

        }catch (SQLException| ErrorConnectionDbException | NoNotifyFoundException e) {
            e.printStackTrace();
        }
        return notifyModelList;
    }
}
