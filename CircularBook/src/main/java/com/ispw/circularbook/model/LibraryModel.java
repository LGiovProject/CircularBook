package com.ispw.circularbook.model;

public class LibraryModel {
    private String email;
    private String nomeLib;
    private int telNumber;
    private String citta;
    private String via;
    private int[] bookInfo; //position: 0 , #of book registered; 1 , #of book lended;

    public LibraryModel(){}


    public LibraryModel(String email, String nomeLib, String citta, String via, int telNumber) {
        this.setEmail(email);
        this.setNomeLib(nomeLib);
        this.setCitta(citta);
        this.setVia(via);
        this.telNumber=telNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomeLib() {
        return nomeLib;
    }

    public void setNomeLib(String nomeLib) {
        this.nomeLib = nomeLib;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getVia() {
        return via;
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
}
