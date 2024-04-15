package com.ispw.circularbook.engineering.bean;

public class UpdateInfoBean {

    String email;
    String camp;
    String newValue;


    public UpdateInfoBean(String email, String camp, String newValue) {
        this.email = email;
        this.camp = camp;
        this.newValue = newValue;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCamp() {
        return camp;
    }

    public void setCamp(String camp) {
        this.camp = camp;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }
}
