package com.ispw.circularbook.controller.appcontroller;

import com.ispw.circularbook.engineering.bean.UpdateInfoBean;
import com.ispw.circularbook.engineering.dao.UserDAO;
import com.ispw.circularbook.engineering.session.Session;

public class UserController {
    public void updateUser(UpdateInfoBean updateInfoBean)
    {
        UserDAO.updateUser(updateInfoBean);
        this.updateSession(updateInfoBean);

    }

    private void updateSession(UpdateInfoBean updateInfoBean)
    {
        Session.getCurrentSession().getUser().setNome(updateInfoBean.getNameUser());
        Session.getCurrentSession().getUser().setCognome(updateInfoBean.getSurname());
        Session.getCurrentSession().getUser().setUsername(updateInfoBean.getUsername());
        Session.getCurrentSession().getUser().setCity(updateInfoBean.getCity());
    }
}
