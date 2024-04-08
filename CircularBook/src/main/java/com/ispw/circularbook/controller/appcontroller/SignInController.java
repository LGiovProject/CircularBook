package com.ispw.circularbook.controller.appcontroller;

import com.ispw.circularbook.engineering.Bean.SignInBean;
import com.ispw.circularbook.engineering.DAO.SignInDAO;
import com.ispw.circularbook.engineering.exception.EmailUsedException;

import java.io.IOException;

public class SignInController {

    public void signInU(SignInBean signInBean)
    {
        SignInDAO.signInU(signInBean.getEmail(),signInBean.getUsername(),signInBean.getPassword(), signInBean.getNome(), signInBean.getCognome(), signInBean.getCittaString());
    }
    public void signInL(SignInBean signInBean) throws IOException {
        SignInDAO.signInL(signInBean.getEmail(),signInBean.getPassword(),signInBean.getNomeLib(),signInBean.getCittaString(),signInBean.getVia(),signInBean.getnTel());
    }

    public void CheckMail(String email) throws EmailUsedException {
        SignInDAO.checkEmailU(email);
    }
}