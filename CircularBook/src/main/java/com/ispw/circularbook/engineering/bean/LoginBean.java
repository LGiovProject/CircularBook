package com.ispw.circularbook.engineering.bean;

import com.ispw.circularbook.engineering.exception.WrongEmailFormattException;

import java.util.regex.Pattern;

public class LoginBean {

    private String password;
    private String email;
    private static int type=0 ;
    //Costruttore LoginBean prende due stringhe e inizializza con esse le due variabili private che possiede
    //utilizzando i suoi metodi set
    public LoginBean(String password, String email) throws WrongEmailFormattException {
        this.password=password;
        this.email=this.checkEmail(email);
    }

    public LoginBean(){}

    //Metodo get che ritorna il valore della variabile privata email
    public String getEmail()
    {
        return this.email;
    }
    //Metodo set che imposta la variabile privata mail con la stringa in ingresso
    public void setEmail(String email) throws WrongEmailFormattException {this.email = email;}
    //Metodo get che ritorna il valore della  variabile privata passoword
    public String getPassword()
    {
        return this.password;
    }
    //Metodo set che imposta la variabile privata password con la stringa in ingresso
    public void setPassword(String password) {
        this.password = password;
    }
    //Metodo set autorizzazione per la sessione, viene impostata da loginController
    public  void setType(int typeAccount){type=typeAccount;}
    //Metodo get Autorizazzione per la sessione,
    public int getType(){return type;}

    private String checkEmail(String email) throws WrongEmailFormattException {
        String checkMail = "[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}";
        if (!Pattern.compile(checkMail).matcher(email).matches())
            throw new WrongEmailFormattException(email);
        return email;
    }
}
