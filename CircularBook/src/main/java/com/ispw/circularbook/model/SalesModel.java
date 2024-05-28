package com.ispw.circularbook.model;

import com.ispw.circularbook.engineering.enums.TypeOfSales;

import java.time.LocalDate;

public class SalesModel {

    private int id;
    private String email;
    private String nameLib;
    private TypeOfSales typeOfSales;
    private String dateStart;
    private String dateFinish;
    private String description;
    private String title;

    public SalesModel(){}

    public SalesModel(int id, String email, String nameLib, int typeOfSales, String description, String title, String dateStart, String dateFinish) {
        this.id = id;
        setTypeOfSales(typeOfSales);
        this.email = email;
        this.nameLib = nameLib;
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
        this.description = description;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTypeOfSalesInt()
    {
        return typeOfSales.getId();
    }

    public String getTypeOfSalesString()
    {
        return typeOfSales.getType();
    }

    public void setTypeOfSales(TypeOfSales typeOfSales) {
        this.typeOfSales = typeOfSales;
    }

    public void setTypeOfSales(int typeOfSales) {

        switch (typeOfSales)
        {
            case 1:
            {
                this.typeOfSales=TypeOfSales.Event;
                break;
            }
            case 2:
            {
                this.typeOfSales=TypeOfSales.Promotion;
                break;

            }
            default: this.typeOfSales=TypeOfSales.Any;
        }
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

    public String getDateStartString() {
        return dateStart;
    }

    public LocalDate getDateStart(){

        return LocalDate.parse(dateStart);
    }
    public void setDateStart(String date_start) {
        this.dateStart = date_start;
    }

    public String getDateFinishString() {
        return dateFinish;
    }

    public LocalDate getDateFinish(){ return LocalDate.parse(dateFinish);}

    public void setDateFinish(String date_finish) {
        this.dateFinish = date_finish;
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
