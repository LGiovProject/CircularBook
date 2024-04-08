package com.ispw.circularbook.controller.appcontroller;

import com.ispw.circularbook.engineering.Bean.BookBean;
import com.ispw.circularbook.engineering.Bean.NotifyBean;
import com.ispw.circularbook.engineering.DAO.NotifyDAO;
import com.ispw.circularbook.model.NotifyModel;

import java.util.ArrayList;
import java.util.List;

public class NotifyController {

   public void insertNotify(String emailSender, BookBean bookBean, String message ) {
       NotifyBean notifyBean = new NotifyBean(emailSender,bookBean.getEmail(),message,bookBean.getId());
       NotifyDAO.insertNotify(notifyBean);
   }

   public List<NotifyBean> readNotify(String email) {

       List<NotifyModel> notifyModelList=NotifyDAO.searchNotify(email);
       List<NotifyBean> notifyBeanList = new ArrayList<>();

       for(NotifyModel notifyModel: notifyModelList) {
           NotifyBean notifyBean = new NotifyBean(notifyModel.getEmailSender(), notifyModel.getMessage(), notifyModel.isNotifyCheck(), notifyModel.getId_book());
           notifyBeanList.add(notifyBean);
       }
        return notifyBeanList;

   }
}
