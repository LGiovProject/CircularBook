package com.ispw.circularbook.engineering.bean;

import com.ispw.circularbook.engineering.enums.City;

import java.util.List;

public class UserBean {

    private String email;
    private String username;
    private String password;
    private String nome;
    private String cognome;
    private City city;
    private List<BookBean> bookBeanTaked;
    private List<BookBean> bookLastSearch;
    private List<BookBean> bookOwnList;

    private int[] bookInfo; //position: 0 , #of book registered; 1 , #of book lended;2 , #of book gifted; 3, #of book takeon lend; 4, #of book take on gift

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

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public City getCity() {
        return city;
    }

    public String getCityString(){return this.city.getCity();}

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

    public void setCity(City city) {
        this.city = city;
    }

    public void setCity(String city) {
        for(City city1: City.values())
        {
            if(city1.getCity().equals(city))
            {
                this.city=city1;
            }
        }
    }

    public int[] getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(int[] bookInfo) {
        this.bookInfo = bookInfo;
    }

    public void setBookBeanTaked(List<BookBean> bookBeanTaked){
        this.bookBeanTaked=bookBeanTaked;
    }

    public List<BookBean> getBookBeanTaked(){return this.bookBeanTaked;}

    public List<BookBean> getBookLastSearch() {
        return bookLastSearch;
    }

    public void setBookLastSearch(List<BookBean> bookLastSearch) {
        this.bookLastSearch = bookLastSearch;
    }

    public List<BookBean> getBookOwnList() {
        return bookOwnList;
    }

    public void setBookOwnList(List<BookBean> bookOwnList) {
        this.bookOwnList = bookOwnList;
    }
}
