package com.ispw.circularbook.engineering.bean;

import com.ispw.circularbook.engineering.enums.City;

import java.util.List;

public class UserBean {

    private String email;
    private String username;
    private String password;
    private String nome;
    private String cognome;
    private String city;

    public UserBean(){};

    public UserBean(String email,String username,String password, String nome, String cognome, String city) {
        this.email=email;
        this.username=username;
        this.password=password;
        this.nome=nome;
        this.cognome=cognome;
        setCity(city);
    }

    public UserBean(String email,String username,String nome, String cognome, String city) {
        this.email=email;
        this.username=username;
        this.nome=nome;
        this.cognome=cognome;
        setCity(city);
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() { return username;}
    public void setUsername(String username) { this.username = username;}

    public String getPassword() {
        return password;
    }

    public String getName() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setBookInfo(){}
    public void getBookInfo(){}

}
