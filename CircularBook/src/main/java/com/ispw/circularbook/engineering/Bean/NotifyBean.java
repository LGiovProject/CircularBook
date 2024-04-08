package com.ispw.circularbook.engineering.Bean;

public class NotifyBean {

    private String emailSender;
    private String emailReceiver;
    private BookBean bookBean;
    private String message;
    private boolean notifyCheck;
    private int id_book;

    public NotifyBean(String emailSender, BookBean bookBean, String message, boolean notifyCheck, int id_book) {
        this.emailSender = emailSender;
        this.bookBean = bookBean;

        this.message = message;
        this.notifyCheck = notifyCheck;
        this.id_book = id_book;
    }

    public NotifyBean(BookBean bookBean,String message)
    {
        this.bookBean=bookBean;
        this.message=message;
    }

    public NotifyBean(String emailSender, String emailReceiver, String message, int id_book) {
        this.emailSender = emailSender;
        this.emailReceiver = emailReceiver;

        this.message = message;
        this.id_book = id_book;
    }

    public NotifyBean(String emailSender, String message, boolean notifyCheck, int id_book) {
        this.emailSender = emailSender;

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
