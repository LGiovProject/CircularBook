package com.ispw.circularbook.model;

import java.util.List;

public class UserModel {

    private String email;
    private String username;
    private String name;
    private String cognome;
    private String citta;
    private List<BookModel> bookBeanTaked;

    private int[] bookInfo; //position: 0 , #of book registered; 1 , #of book lended;2 , #of book gifted; 3, #of book takeon lend; 4, #of book take on gift


    public UserModel(){}

    public UserModel(String email,String username,String name, String cognome, String citta)
    {
        this.setEmail(email);
        this.setUsername(username);
        this.setName(name);
        this.setCognome(cognome);
        this.setCitta(citta);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() { return username;}

    public void setUsername(String username) { this.username = username;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public int[] getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(int[] bookInfo) {
        this.bookInfo = bookInfo;
    }

    public void setBookBeanTaked(List<BookModel> bookBeanTaked){
        this.bookBeanTaked=bookBeanTaked;
    }

    public List<BookModel> getBookBeanTaked(){return this.bookBeanTaked;}
}
