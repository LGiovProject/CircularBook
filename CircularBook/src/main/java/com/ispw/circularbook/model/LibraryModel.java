package com.ispw.circularbook.model;

import com.ispw.circularbook.engineering.bean.BookBean;
import com.ispw.circularbook.engineering.enums.City;

import java.util.List;

public class LibraryModel {
    private String email;

    private String password;
    private String nomeLib;
    private City city;
    private int telNumber;
    private String via;

    private List<BookModel> bookOwnList;


    private int[] bookInfo; //position: 0 , #of book registered; 1 , #of book lended;2




    public LibraryModel(){}

    public LibraryModel(String email, String nomeLib, City citta, String via)
    {
        this.email=email;
        this.nomeLib=nomeLib;
        this.city=citta;
        this.via=via;
    }

    public LibraryModel(String email, String nomeLib, String citta, String via, int telNumber)
    {
        this.email=email;
        this.nomeLib=nomeLib;
        setCity(citta);
        this.via=via;
        this.telNumber=telNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNomeLib() {
        return nomeLib;
    }

    public String getCityString() {
        return this.city.getCity();
    }

    public City getCity(){return this.city;}

    public String getVia() {
        return via;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNomeLib(String nome) {
        this.nomeLib = nome;
    }

    public void setCity(City city) {this.city = city;}

    public void setCity(String city)
    {
        for(City city1: City.values())
        {
            if(city1.getCity().equals(city))
            {
                this.city=city1;
            }
        }
    }
    public void setVia(String via) {
        this.via = via;
    }

    public int[] getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(int[] bookInfo) {
        this.bookInfo = bookInfo;
    }

    public int getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(int telNumber) {
        this.telNumber = telNumber;
    }

    public List<BookModel> getBookOwnList() {
        return bookOwnList;
    }

    public void setBookOwnList(List<BookModel> bookOwnList) {
        this.bookOwnList = bookOwnList;
    }
}
