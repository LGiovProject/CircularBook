package com.ispw.circularbook.engineering.bean;

import com.ispw.circularbook.engineering.enums.Month;
import com.ispw.circularbook.engineering.enums.TypeOfSales;
import com.mysql.cj.util.StringUtils;

import java.text.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class SalesBean {
    private int id;
    private String titlePromotion;
    private String email;
    private String nameLib;
    private TypeOfSales typeOfSales;
    private String description;
    private LocalDate dateStart;
    private LocalDate dateFinish;
    private Month month;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");



    public SalesBean(){}


    public SalesBean(int id){
        this.id=id;
    }

    public SalesBean(int id, String titlePromotion, String description, LocalDate dateStart, LocalDate dateFinish) {
        this.id = id;
        this.titlePromotion = titlePromotion;
        this.description = description;
        setDateStart(dateStart);
        setDateFinish(dateFinish);
    }



    public SalesBean(String email, String titlePromotion, TypeOfSales typeOfSales, String description  , String dateStart, String dateFinish) throws Exception {

        this.email = email;
        setTypeOfSales(typeOfSales);
        this.titlePromotion = titlePromotion;
        this.description=description;
        setDateStart(dateStart);
        setDateFinish(dateFinish,dateStart);
    }




    public SalesBean(int id, String email, String nameLib, int typeOfSales, String titlePromotion, String description , String dateStart, String dateFinish) throws Exception {
        this.id = id;
        this.email = email;
        this.nameLib=nameLib;
        setTypeOfSales(typeOfSales);
        this.titlePromotion = titlePromotion;
        this.description=description;
        setDateStart(dateStart);
        setDateFinish(dateFinish,dateStart);


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        this.typeOfSales=typeOfSales;
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

    public void setTypeOfSales(String typeOfSales) {
        switch (typeOfSales)
        {
            case "Event":
            {
                this.typeOfSales=TypeOfSales.Event;
                break;
            }
            case "Promotion":
            {
                this.typeOfSales=TypeOfSales.Promotion;
                break;
            }
            default: this.typeOfSales=TypeOfSales.Any;
        }
    }

    public String getTitlePromotion() {
        return titlePromotion;
    }

    public void setTitlePromotion(String titlePromotion) {
        this.titlePromotion = titlePromotion;
    }

    public String getDateStart() {
        return dateStart.format(dateTimeFormatter);
    }

    public void setDateStart(LocalDate dateStart){this.dateStart=dateStart;}

    public void setDateStart(String dateStart) {

        this.dateStart=StringUtils.isEmptyOrWhitespaceOnly(dateStart)?null:LocalDate.parse(dateStart);


    }

    public String getDateFinish() {
        return dateFinish.format(dateTimeFormatter);
    }

    public void setDateFinish(LocalDate dateFinish){this.dateFinish= dateFinish;}

    public void setDateFinish(String dateFinish, String dateStart) throws Exception {

        this.dateFinish = StringUtils.isEmptyOrWhitespaceOnly(dateFinish)?null:LocalDate.parse(dateFinish);
        if(!(dateFinish==null))
            if(this.dateFinish.isBefore(LocalDate.parse(dateStart)))
                throw new Exception("Error");

    }

    public void setDateFinish(LocalDate dateStart, LocalDate dateFinish) throws Exception {
        this.dateFinish =dateFinish;
        if(this.dateFinish.isBefore(dateStart))
            throw new Exception("error");
    }

    public void setDateFinish(String dateFinish)
    {
        this.dateFinish=LocalDate.parse(dateFinish);
    }

    public String getNameLib() {
        return nameLib;
    }

    public void setNameLib(String nameLib) {
        this.nameLib = nameLib;
    }

    public int getMonthInt() {
       return this.month.getId();
    }

    public String getMonthString()
    {
        return this.month.getMonth();
    }

    public void setMonth(Month mounth) {
        this.month = mounth;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
