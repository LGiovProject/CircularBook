package com.ispw.circularbook.engineering.bean;

import com.ispw.circularbook.engineering.enums.Arguments;
import com.ispw.circularbook.engineering.exception.TitleCampRequiredException;
import com.ispw.circularbook.engineering.exception.WrongNpageFormatException;

public class RegistrationBookBean {
    String email;
    int typeOfDisponibility;
    String title;
    String author;
    Arguments argument;
    String nPage;
    String comment;

    public RegistrationBookBean(String email,int typeOfDisponibility,String title, String author, Arguments argument, String nPage, String comment) throws TitleCampRequiredException, WrongNpageFormatException {
        this.email = email;
        this.typeOfDisponibility= typeOfDisponibility;
        this.setTitle(title);
        this.setAuthor(author);
        this.argument=argument;
        this.setNPage(nPage);
        this.setComment(comment);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTypeOfDisponibility() {
        return typeOfDisponibility;
    }

    public void setTypeOfDisponibility(int typeOfDisponibility) {
        this.typeOfDisponibility = typeOfDisponibility;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws TitleCampRequiredException {
        if(title.isBlank() || title.isEmpty())
            throw new TitleCampRequiredException();
        else
        {
            this.title= title;
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if(author.isEmpty() || author.isBlank())
            this.author = "None";
        else
            this.author= author;
    }

    public String getArgument() {
        return argument.getArgument();
    }

    public void setArgument(Arguments argument) {
        if(argument.getArgument().isEmpty() || argument.getArgument().isBlank())
            this.argument=Arguments.None;
        else
            this.argument=argument;
    }

    public String getNPage() {
        return this.nPage;
    }

    public int getNPageInt(){
        return Integer.parseInt(this.nPage);
    }

    public void setNPage(String nPage) throws WrongNpageFormatException {
        if(nPage.isEmpty() || nPage.isBlank())
            this.nPage = "0";
        else
            if(nPage.matches("^\\d+$"))
                this.nPage=nPage;
            else
                throw new WrongNpageFormatException();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        if(comment.isBlank()|| comment.isEmpty())
            this.comment = "no comment";
        else
            this.comment=comment;
    }
}
