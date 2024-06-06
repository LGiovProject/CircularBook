package com.ispw.circularbook.engineering.bean;

public class InfoBookBean {

    private String username;
    private String email;

    private int registerBook;
    private int lendedBook;
    private int giftedBook;
    private int lendedBookTaked;
    private int giftedBooktaked;
    private int salesInsert;

    public InfoBookBean(){}

    public InfoBookBean(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRegisterBook() {
        return registerBook;
    }

    public void setRegisterBook(int registerBook) {
        this.registerBook = registerBook;
    }

    public int getLendedBook() {
        return lendedBook;
    }

    public void setLendedBook(int lendedBook) {
        this.lendedBook = lendedBook;
    }

    public int getGiftedBook() {
        return giftedBook;
    }

    public void setGiftedBook(int giftedBook) {
        this.giftedBook = giftedBook;
    }

    public int getLendedBookTaked() {
        return lendedBookTaked;
    }

    public void setLendedBookTaked(int lendedBookTaked) {
        this.lendedBookTaked = lendedBookTaked;
    }

    public int getGiftedBooktaked() {
        return giftedBooktaked;
    }

    public void setGiftedBooktaked(int giftedBooktaked) {
        this.giftedBooktaked = giftedBooktaked;
    }

    public int getSalesInsert() {
        return salesInsert;
    }

    public void setSalesInsert(int salesInsert) {
        this.salesInsert = salesInsert;
    }
}
