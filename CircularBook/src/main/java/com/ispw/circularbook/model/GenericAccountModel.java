package com.ispw.circularbook.model;

import com.ispw.circularbook.engineering.enums.City;

import java.util.List;

public abstract class GenericAccountModel {

    private String email;
    private String password;
    private List<BookModel> bookOwnList;

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

    public void setBookOwnList(List<BookModel> bookOwnList) {
        this.bookOwnList = bookOwnList;
    }

    public List<BookModel> getBookOwnList() {
        return bookOwnList;
    }
}
