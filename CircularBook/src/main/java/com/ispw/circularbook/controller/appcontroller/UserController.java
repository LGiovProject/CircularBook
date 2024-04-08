package com.ispw.circularbook.controller.appcontroller;

import com.ispw.circularbook.engineering.DAO.UserDAO;

public class UserController {
    public void updateUser(String email,String camp,String newValue)
    {
        UserDAO.updateUser(email,camp,newValue);
    }
}
