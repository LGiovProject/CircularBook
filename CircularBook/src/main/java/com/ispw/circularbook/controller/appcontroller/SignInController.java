package com.ispw.circularbook.controller.appcontroller;

import com.ispw.circularbook.engineering.bean.SignInBean;
import com.ispw.circularbook.engineering.dao.SignInDAO;
import com.ispw.circularbook.engineering.exception.EmailUsedException;

import java.io.IOException;

public class SignInController {

    public void signInU(SignInBean signInBean)
    {
        SignInDAO.signInU(signInBean);
    }
    public void signInL(SignInBean signInBean) throws IOException {
        SignInDAO.signInL(signInBean);
    }

    public void CheckMail(String email) throws EmailUsedException {
        SignInDAO.checkEmailU(email);
    }
}
