package com.ispw.circularbook.engineering.bean;

import com.ispw.circularbook.engineering.enums.Arguments;
import com.mysql.cj.util.StringUtils;

public class SearchBookBean {

   private String email;
   private String author;
   private Arguments argument;
   private String title;

    public SearchBookBean(String email) {
        this.email = email;
    }

    public SearchBookBean(String author, Arguments argument, String title, String email)
   {
       this.author= this.checkAuthor(author);
       setArgument(checkArguments(argument));
       this.title=this.checkTitle(title);
       this.email=email;
   }

    public SearchBookBean(String author, String argument, String title,String email) {
        this.author = author;
        setArgument(argument);
        this.title = title;
        this.email=email;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {

       this.author=author;

    }

    public String getArgument() {

       if(this.argument==null)
           return "null";
       else
           return this.argument.getArgument();

    }

    public void setArgument(String argomento){

        if(argomento==null)
        {
            this.argument=Arguments.Any;
        }
        else {
            for (Arguments arguments : Arguments.values()) {
                if (arguments.getArgument().equals(argomento)) {
                    this.argument = arguments;
                }
            }
        }
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

    private String checkAuthor(String author) {
        if (StringUtils.isEmptyOrWhitespaceOnly(author))
            return null;
        else
            return "'" + author + "'";
    }

    private Arguments checkArguments(Arguments arguments)
    {
        if(StringUtils.isEmptyOrWhitespaceOnly(arguments.getArgument()))
            return null;
        else
            return arguments;
    }

    private String checkTitle(String title)
    {
        if(StringUtils.isEmptyOrWhitespaceOnly(title))
            return null;
        else
            return "'"+title+"'";
    }


}
