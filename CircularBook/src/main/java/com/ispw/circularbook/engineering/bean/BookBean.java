package com.ispw.circularbook.engineering.bean;

import com.ispw.circularbook.engineering.enums.Arguments;
import com.ispw.circularbook.engineering.exception.WrongNpageFormatException;
import com.mysql.cj.util.StringUtils;
import java.time.LocalDate;
import java.time.Period;
//import java.time.temporal.ChronoUnit;


public class BookBean {
    private int id;
    private String email;
    private String username;
    private int typeOfDisponibility;
    private String titolo;
    private String autore;
    private Arguments argomento;
    private String nPagine;
    private String commento;

    private String emailPutter;
    private String usernamePutter;
    private String emailTaker;
    private String usernameTaker;

    //info book
    private String date_start;
    private String date_finish;
    private String emailInfo;


    private int daysRemaing;





    public BookBean() {

    }


    public BookBean(String titolo, String autore, String emailInfo, int daysRemaing) {
        this.titolo = titolo;
        this.autore = autore;
        this.emailInfo = emailInfo;
        this.daysRemaing = daysRemaing;
    }

    public BookBean(String email, int typeOfDisponibility, String titolo, String autore, Arguments argomento, String nPagine, String commento) throws WrongNpageFormatException {
        this.email = email;
        this.typeOfDisponibility = typeOfDisponibility;
        this.titolo = titolo;
        this.autore = autore;
        setArgomento(argomento);
        setNPagine(nPagine);
        this.commento = commento;
    }

    public BookBean(int id, String email, int typeOfDisponibility,String titolo, String autore, Arguments argomento,  String nPagine, String commento) {

        this.id = id;
        this.email = email;
        this.typeOfDisponibility = typeOfDisponibility;
        this.titolo = titolo;
        this.autore = autore;
        setArgomento(argomento);
        setNPagine(nPagine);
        this.commento = commento;
    }
    public BookBean(int id, String email, int typeOfDisponibility,String titolo, String autore, String argomento, String nPagine, String commento) throws WrongNpageFormatException {

        this.id = id;
        this.email = email;
        this.typeOfDisponibility = typeOfDisponibility;
        this.titolo = titolo;
        this.autore = autore;
        setArgomento(argomento);
        setNPagine(nPagine);
        this.commento = commento;
    }

    public BookBean(int id, String email, int typeOfDisponibility, String titolo, String autore, Arguments argomento, String nPagine, String commento, String date_start, String date_finish,int daysRemaing ,String emailInfo) {
        this.id = id;
        this.email = email;
        this.typeOfDisponibility = typeOfDisponibility;
        this.titolo = titolo;
        this.autore = autore;
        setArgomento(argomento);
        setNPagine(nPagine);
        this.commento = commento;
        this.date_start = date_start;
        this.date_finish = date_finish;
        this.daysRemaing=daysRemaing;
        this.emailInfo=emailInfo;
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

    public void setTypeOfDisponibility(int typeOfDisponibility){this.typeOfDisponibility=typeOfDisponibility;}

    public int getTypeOfDisponibility() {
        return typeOfDisponibility;
    }

    public String getTypeOfDisponibilityString () {

        return switch (this.typeOfDisponibility) {
        case 1 -> "E' messo in prestito";
        case 2 -> "E' messo in regalo";
        case 3 -> "E' stato prestato";
        case 4 -> "E' stato regalato";
        default -> "Errore con questo libro";
        };
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return this.autore==null?"":autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public Arguments getArgomento(){return  argomento;}
    public String getArgomentoString() {
        return this.argomento==Arguments.Any?"":this.argomento.getArgument();
    }

    public void setArgomento(Arguments argomento) {
        this.argomento=argomento==null?Arguments.Any:argomento;
    }

    public void setArgomento(String argomento){

        if(argomento==null)
        {
            this.argomento=Arguments.Any;
        }
        else {
            for (Arguments arguments : Arguments.values()) {
                if (arguments.getArgument().equals(argomento)) {
                    this.argomento = arguments;
                }
            }
        }
    }

    public String getNPagine() {
        return nPagine;
    }

    public int getNPagineInt(){return Integer.parseInt(nPagine);}

    public void setNPagine(int nPagine)
    {
        this.nPagine=String.valueOf(nPagine);
    }

    public void setNPagine(String nPagine)
    {
        if(!nPagine.isEmpty() || !nPagine.isBlank())
            this.nPagine= nPagine;
        else
            this.nPagine="0";
    }

    public String getNpagineString()
    {
        return (String.valueOf(this.nPagine));
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

    public String getEmailInfo() {  return emailInfo;  }

    public void setEmailInfo(String emailInfo) { this.emailInfo = emailInfo; }

    public long getDaysRemaing()
    {
        return this.daysRemaing;
    }

    public void setDaysRemaing(String date_finish)
    {

        LocalDate nowDate = LocalDate.now();
        LocalDate finishDate = LocalDate.parse(date_finish);
        Period period = Period.between(nowDate, finishDate);
        this.daysRemaing= period.getDays();


    }
    public void setDaysRemaing(int daysRemaing){ this.daysRemaing=daysRemaing;}

    public String getEmailGiver() {
        return emailPutter;
    }

    public void setEmailGiver(String emailGiver) {
        this.emailPutter = emailGiver;
    }

    public String getEmailTaker() {
        return emailTaker;
    }

    public void setEmailTaker(String emailTaker) {
        this.emailTaker = emailTaker;
    }

    public String getUsernamePutter() {
        return usernamePutter;
    }

    public void setUsernamePutter(String usernameGiver) {
        this.usernamePutter = usernameGiver;
    }

    public String getUsernameTaker() {
        return usernameTaker;
    }

    public void setUsernameTaker(String usernameTaker) {
        this.usernameTaker = usernameTaker;
    }
}
