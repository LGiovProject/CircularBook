package com.ispw.circularbook.controller.appcontroller;

import com.ispw.circularbook.engineering.bean.UpdateInfoBean;
import com.ispw.circularbook.engineering.dao.UserDAO;

public class UserController {
    public void updateUser(UpdateInfoBean updateInfoBean)
    {
        UserDAO.updateUser(updateInfoBean);
    }
}
