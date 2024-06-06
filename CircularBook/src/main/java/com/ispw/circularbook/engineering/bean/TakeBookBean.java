package com.ispw.circularbook.engineering.bean;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TakeBookBean {
    private int id;
    private String emailGiver; //chi ha reso disponibile il libro
    private String username;
    private int typeOfDisponiblity;
    private String emailTaker;
    private String usernameTaker;

    private String dateStart;
    private String dateFinish;

    public TakeBookBean(int id, String emailGiver, String emailTaker, int typeOfDisponiblity , LocalDate dateStart) {
        this.id = id;
        this.emailGiver = emailGiver;
        this.emailTaker=emailTaker;
        this.typeOfDisponiblity=typeOfDisponiblity;

        setDateStart(dateStart);
        setDateFinish();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmailGiver() {
        return emailGiver;
    }

    public void setEmailGiver(String emailGiver) {
        this.emailGiver = emailGiver;
    }

    public String getEmailTaker() {
        return emailTaker;
    }

    public void setEmailTaker(String emailTaker) {
        this.emailTaker = emailTaker;
    }

    public String getUsernameTaker() {
        return usernameTaker;
    }

    public void setUsernameTaker(String usernameTaker) {
        this.usernameTaker = usernameTaker;
    }


    public int getTypeOfDisponiblity() {
        return typeOfDisponiblity;
    }

    public void setTypeOfDisponiblity(int type_of_disponiblity) {
        this.typeOfDisponiblity = type_of_disponiblity;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public String getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish() {
        LocalDate dateStart = LocalDate.parse(this.dateStart,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate dateFinish =dateStart.plusMonths(2);
        this.dateFinish = dateFinish.toString();
    }
}
