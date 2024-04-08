package com.ispw.circularbook.model;

public class NotifyModel {

    private String emailSender;
    private String emailReceiver;
    private String message;
    private boolean notifyCheck;
    private int id_book;

    public NotifyModel(){}

    public NotifyModel(String emailSender, String message, boolean notifyCheck, int id_book) {
        this.emailSender = emailSender;
        this.message = message;
        this.notifyCheck = notifyCheck;
        this.id_book = id_book;
    }

    public NotifyModel(String emailSender,String emailReceiver, String message, boolean notifyCheck, int id_book) {
        this.emailSender = emailSender;
        this.emailReceiver=emailReceiver;
        this.message = message;
        this.notifyCheck = notifyCheck;
        this.id_book = id_book;
    }
    public String getEmailSender() {
        return emailSender;
    }

    public void setEmailSender(String emailSender) {
        this.emailSender = emailSender;
    }

    public String getEmailReceiver() {
        return emailReceiver;
    }

    public void setEmailReceiver(String emailReceiver) {
        this.emailReceiver = emailReceiver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isNotifyCheck() {
        return notifyCheck;
    }

    public void setNotifyCheck(boolean notifyCheck) {
        this.notifyCheck = notifyCheck;
    }

    public int getId_book() {
        return id_book;
    }

    public void setId_book(int id_book) {
        this.id_book = id_book;
    }
}
