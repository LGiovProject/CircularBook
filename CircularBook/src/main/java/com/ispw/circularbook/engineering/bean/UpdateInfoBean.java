package com.ispw.circularbook.engineering.bean;

import com.ispw.circularbook.engineering.enums.City;

public class UpdateInfoBean {

    String email;
    String nameUser;
    String surname;
    String username;

    String nameLibrary;
    String via;
    int numberPhone;

    City city;


    public UpdateInfoBean(String email, City city) {
        this.email = email;
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNameLibrary() {
        return nameLibrary;
    }

    public void setNameLibrary(String nameLibrary) {
        this.nameLibrary = nameLibrary;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public int getNumberPhone() {
        return numberPhone;
    }

    public String getNumberPhoneString(){
        return String.valueOf(numberPhone);
    }

    public void setNumberPhone(int numberPhone) {
        this.numberPhone = numberPhone;
    }

    public void setNumberPhone(String numberPhone){
        this.numberPhone = Integer.parseInt(numberPhone);
    }

    public City getCity() {
        return city;
    }

    public String getCityString()
    {
        return city.getCity();
    }

    public void setCity(City city) {
        this.city = city;
    }
}
