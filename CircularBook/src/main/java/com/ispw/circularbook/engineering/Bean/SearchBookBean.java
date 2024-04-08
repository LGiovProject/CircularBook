package com.ispw.circularbook.engineering.Bean;

import com.ispw.circularbook.engineering.Enums.Arguments;
import com.mysql.cj.util.StringUtils;

public class SearchBookBean {

   private String author;
   private Arguments argument;
   private String title;

   public SearchBookBean(String author,Arguments argument,String title)
   {
       setAuthor(author);
       setArgument(argument);
       setTitle(title);
   }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if(StringUtils.isEmptyOrWhitespaceOnly(author))
            this.author=null;
        else
           this.author="'"+author+"'";

    }

    public String getArgument() {
       if(StringUtils.isEmptyOrWhitespaceOnly(this.argument.getArgument()))
           return null;
       else
        return this.argument.getArgument();
    }

    public void setArgument(Arguments argument) {

            this.argument=argument;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(StringUtils.isEmptyOrWhitespaceOnly(title))
            this.title=null;
        else
            this.title="'"+title+"'";
    }



}
