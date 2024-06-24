package com.ispw.circularbook.model;


import com.ispw.circularbook.engineering.enums.City;

import java.util.List;

public class UserModel extends GenericAccountModel {

    private String email;
    private String username;
    private String password;
    private String nome;
    private String cognome;
    private City city;



    private boolean guest;

    private List<BookModel> bookTakedList;
    private List<BookModel> bookLastSearchList;
    private List<BookModel> bookOwnList;
    private List<BookModel> bookGivenList;
    private List<BookModel> bookLastViewedList;

    private List<SalesModel> salesModelList;

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

    public void setBookTakedList(List<BookModel> bookTakedList){
        this.bookTakedList = bookTakedList;
    }

    public List<BookModel> getBookTakedList(){return this.bookTakedList;}

    public List<BookModel> getBookLastSearch() {
        return bookLastSearchList;
    }

    public void setBookLastSearch(List<BookModel> listBookLastSearch) {
        this.bookLastSearchList = listBookLastSearch;
    }

    public List<BookModel> getBookOwnList() {
        return bookOwnList;
    }

    public void setBookOwnList(List<BookModel> listBookOwnList) {
        this.bookOwnList = listBookOwnList;
    }

    public List<BookModel> getBookLastViewedList() {
        return bookLastViewedList;
    }

    public void setBookLastViewedList(List<BookModel> bookLastViewedList) {
        this.bookLastViewedList = bookLastViewedList;
    }

    public List<BookModel> getBookGivenList() {
        return bookGivenList;
    }

    public void setBookGivenList(List<BookModel> bookGivenList) {
        this.bookGivenList = bookGivenList;
    }


    public boolean isGuest() {
        return guest;
    }

    public void setGuest(boolean guest) {
        this.guest = guest;
    }

    public List<SalesModel> getSalesModelList() {
        return salesModelList;
    }

    public void setSalesModelList(List<SalesModel> salesModelList) {
        this.salesModelList = salesModelList;
    }
}
