package com.ispw.circularbook.engineering.bean;

import javafx.util.converter.LocalDateStringConverter;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LenderBookBean {
    private int id;
    private String email;
    private String username;
    private String dateStart;
    private String dateFinish;

    public LenderBookBean(int id, String email, String username, LocalDate dateStart) {
        this.id = id;
        this.email = email;
        this.username = username;
        setDateStart(dateStart);
        setDateFinish();
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
