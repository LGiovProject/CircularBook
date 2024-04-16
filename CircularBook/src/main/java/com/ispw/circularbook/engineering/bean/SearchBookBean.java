package com.ispw.circularbook.engineering.bean;

import com.ispw.circularbook.engineering.enums.Arguments;
import com.mysql.cj.util.StringUtils;

public class SearchBookBean {

   private String email;
   private String author;
   private Arguments argument;
   private String title;

   public SearchBookBean(String author,Arguments argument,String title,String email)
   {
       this.author= author;
       this.argument= argument;
       this.title=title;
       this.email=email;
   }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {

       this.author=author;

    }

    public String getArgument() {

       return this.argument.getArgument();

    }



    public void setArgument(Arguments argument) {

            this.argument=argument;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {

            this.title=title;

    }

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String email)
    {
        this.email=email;
    }


}
