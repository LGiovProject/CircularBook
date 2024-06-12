package com.ispw.circularbook.engineering.bean;

import com.ispw.circularbook.engineering.enums.City;
import com.ispw.circularbook.engineering.exception.*;
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

    public SignInBean(){}

    public SignInBean(String email, String password, String nomeLib, String via, City citta, int nTel) throws WrongEmailFormattException, NoMatchPasswordException, PasswordCampRequiredException, CityCampRequiredException {
        setEmail(email);
        this.password=password;
        this.citta=citta;
        this.via = via;
        this.nomeLib = nomeLib;
        this.nTel=nTel;
    }

    public SignInBean(String email,String username,String password, String nome, String cognome, City citta) throws WrongEmailFormattException, NoMatchPasswordException, PasswordCampRequiredException, CityCampRequiredException {
        setEmail(email);
        this.username=username;
        this.password=password;
        this.nome = nome;
        this.cognome = cognome;
        this.citta=citta;

    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws WrongEmailFormattException {
        String checkMail="[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}";
        if(!Pattern.compile(checkMail).matcher(email).matches())
            throw new WrongEmailFormattException(email);
        this.email=email;
    }

    public String getUsername(){ return username;}

    public void setUsername(String username){this.username=username;}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password){
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

    public void setCitta(City city){
            this.citta=city;
    }

    public void setCitta(String citta) throws WrongCityInsertException {
        for (City city : City.values())
        {
            if(city.getCity().equals(citta))
                this.citta= city;
        }
        if(this.citta==null)
            throw new WrongCityInsertException();

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

    public void setnTel(String nTel){this.nTel=Integer.parseInt(nTel);}

    public int getnTel(){return nTel;}



}
