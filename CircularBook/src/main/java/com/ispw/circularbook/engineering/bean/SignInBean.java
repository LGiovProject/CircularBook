package com.ispw.circularbook.engineering.bean;

import com.ispw.circularbook.engineering.enums.City;
import com.ispw.circularbook.engineering.exception.CityCampRequiredException;
import com.ispw.circularbook.engineering.exception.NoMatchPasswordException;
import com.ispw.circularbook.engineering.exception.PasswordCampRequiredException;
import com.ispw.circularbook.engineering.exception.WrongEmailFormattException;
import com.mysql.cj.util.StringUtils;

import java.util.regex.Pattern;

public class SignInBean {

    private String email;
    private String username;
    private String password;
    private String nome;
    private String cognome;
    private City citta;
    private String via;
    private String nomeLib;
    private int nTel;

    public SignInBean(String email, String password, String repassword, String nomeLib, String via, City citta, int nTel) throws WrongEmailFormattException, NoMatchPasswordException, PasswordCampRequiredException, CityCampRequiredException {
        this.setEmail(email);
        this.setPassword(password,repassword);
        this.setCitta(citta);
        this.via = via;
        this.nomeLib = nomeLib;
        this.nTel=nTel;
    }

    public SignInBean(String email,String username,String password,String repassword, String nome, String cognome, City citta) throws WrongEmailFormattException, NoMatchPasswordException, PasswordCampRequiredException, CityCampRequiredException {
        this.setEmail(email);
        this.username=username;
        this.setPassword(password,repassword);
        this.nome = nome;
        this.cognome = cognome;
        this.setCitta(citta);

    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws WrongEmailFormattException {
        String checkMail="[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}";
        if(!Pattern.compile(checkMail).matcher(email).matches())
            throw new WrongEmailFormattException(email);
        this.email = email;
    }

    public String getUsername(){ return username;}

    public void setUsername(String username){this.username=username;}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password, String repassword) throws NoMatchPasswordException, PasswordCampRequiredException {

        if(StringUtils.isEmptyOrWhitespaceOnly(password))
            throw new PasswordCampRequiredException();

        if(!password.equals(repassword))
            throw new NoMatchPasswordException();
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCittaString() {
        return this.citta.getCity();
    }

    public City getCittaCity()
    {
        return this.citta;
    }

    public void setCitta(City city) throws CityCampRequiredException {

        if(city==City.Any)
                throw new CityCampRequiredException();
            this.citta=city;



    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getNomeLib() {
        return nomeLib;
    }

    public void setNomeLib(String nomeLib) {
        this.nomeLib = nomeLib;
    }

    public void setnTel(int nTel){this.nTel=nTel;}

    public int getnTel(){return nTel;}



}
