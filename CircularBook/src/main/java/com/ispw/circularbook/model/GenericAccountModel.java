package com.ispw.circularbook.model;

import com.ispw.circularbook.engineering.enums.City;

public abstract class GenericAccountModel {

    private String email;
    private String password;
    private City city;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public City getCity() {
        return city;
    }

    public String getCityString(){return this.city.getCity();}

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
}
