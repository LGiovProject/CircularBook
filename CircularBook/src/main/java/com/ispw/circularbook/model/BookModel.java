package com.ispw.circularbook.model;

import com.ispw.circularbook.engineering.Enums.Arguments;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BookModel {
    private int id;
    private String email;
    private int typeOfDisponibility;
    private String titolo;
    private String autore;
    private Arguments argomento;
    private int nPagine;
    private String commento;

    //info book
    private String date_start;
    private String date_finish;
    private String emailGiver;
    private String emailTaker;
    private long daysRemaing;

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

    public int getTypeOfDisponibility() { return typeOfDisponibility; }

    public void setTypeOfDisponibility(int typeOfDisponibility) { this.typeOfDisponibility = typeOfDisponibility; }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public Arguments getArgomento(){return  argomento;}

    public String getArgomentoString() {
        return argomento.getArgument();
    }

    public void setArgomento(String argomento) {

        for(Arguments arguments : Arguments.values())
        {
            if(arguments.getArgument().equals(argomento))
            {
                this.argomento=arguments;
            }
        }
    }
    public void setArgomento(Arguments argomento) {this.argomento=argomento;}

    public int getnPagine() {
        return nPagine;
    }

    public void setnPagine(int nPagine) {
        this.nPagine = nPagine;
    }

    public String getCommento() {
        return commento;
    }

    public void setCommento(String commento) {
        this.commento = commento;
    }

    public String getDate_start() {
        return date_start;
    }

    public void setDate_start(String date_start) {
        this.date_start = date_start;
    }

    public String getDate_finish() {
        return date_finish;
    }

    public void setDate_finish(String date_finish) {
        this.date_finish = date_finish;
    }

    public String getEmailGiver() { return emailGiver; }

    public void setEmailGiver(String emailGiver) { this.emailGiver = emailGiver; }

    public String getEmailTaker() { return emailTaker; }

    public void setEmailTaker(String emailTaker) { this.emailTaker = emailTaker; }

    public void setDaysRemaing(long daysRemaing)
    {
        this.daysRemaing=daysRemaing;
    }

    public void setDaysRemaing(String date_finish)
    {

        LocalDate nowDate = LocalDate.now();
        LocalDate finishDate = LocalDate.parse(date_finish);
        this.daysRemaing=nowDate.until(finishDate, ChronoUnit.DAYS);

    }

    public long getDaysRemaing()
    {
        return this.daysRemaing;
    }
}
