package com.ispw.circularbook.model;

import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.enums.City;

import java.util.List;

public class UserModel {

    private String email;
    private String username;
    private String password;
    private String nome;
    private String cognome;
    private City city;
    private List<BookModel> listBookTaked;
    private List<BookModel> listBookLastSearch;
    private List<BookModel> listBookOwnList;

    private InfoBookModel infoBookModel;
    public UserModel(){};

    public UserModel(String email,String username,String password, String nome, String cognome, String city) {
        this.email=email;
        this.username=username;
        this.password=password;
        this.nome=nome;
        this.cognome=cognome;
        setCity(city);
    }

    public UserModel(String email,String username,String nome, String cognome, String city) {
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

    public InfoBookModel getBookInfo() {
        return infoBookModel;
    }

    public void setBookInfo(InfoBookModel infoBookModel) {
        this.infoBookModel = infoBookModel;
    }

    public void setListBookTaked(List<BookModel> listBookTaked){
        this.listBookTaked=listBookTaked;
    }

    public List<BookModel> getListBookTaked(){return this.listBookTaked;}

    public List<BookModel> getBookLastSearch() {
        return listBookLastSearch;
    }

    public void setBookLastSearch(List<BookModel> listBookLastSearch) {
        this.listBookLastSearch = listBookLastSearch;
    }

    public List<BookModel> getBookOwnList() {
        return listBookOwnList;
    }

    public void setBookOwnList(List<BookModel> listBookOwnList) {
        this.listBookOwnList = listBookOwnList;
    }
}
