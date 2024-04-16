package com.ispw.circularbook.model;

public class SalesModel {

    private int id;
    private String email;
    private String nameLib;
    private int typeOfSales;
    private String date_start;
    private String date_finish;
    private String description;
    private String title;

    public SalesModel(){}

    public SalesModel(int id, String email, String nameLib,int typeOfSales, String date_start, String date_finish, String description, String title) {
        this.id = id;
        this.typeOfSales = typeOfSales;
        this.email = email;
        this.nameLib = nameLib;
        this.date_start = date_start;
        this.date_finish = date_finish;
        this.description = description;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTypeOfSales() {
        return typeOfSales;
    }

    public void setTypeOfSales(int typeOfSales) {
        this.typeOfSales = typeOfSales;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNameLib() {
        return nameLib;
    }

    public void setNameLib(String nameLib) {
        this.nameLib = nameLib;
    }

    public String getDate_start() {
        return date_start;
    }

    public void setDate_start(String date_start) {
        this.date_start = date_start;
    }

    public String getDate_finish() {
        return date_finish;
    }

    public void setDate_finish(String date_finish) {
        this.date_finish = date_finish;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
