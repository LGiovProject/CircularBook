package com.ispw.circularbook.engineering.bean;

import com.ispw.circularbook.engineering.enums.Arguments;
import com.ispw.circularbook.engineering.exception.WrongArgumentInsertException;
import com.ispw.circularbook.engineering.utils.MessageSupport;
import com.mysql.cj.util.StringUtils;

public class SearchBookBean {

   private String email;
   private String author;
   private String argument;
   private String title;

    public SearchBookBean(String email) {
        this.email = email;
    }

    public SearchBookBean(String author, Arguments argument, String title, String email) {
       this.author= this.checkAuthor(author);
       setArgument(argument);
       this.title=this.checkTitle(title);
       this.email=email;
   }

    public SearchBookBean(String author, String argument, String title,String email) throws WrongArgumentInsertException {
        this.author= this.checkAuthor(author);
        setArgument(checkArguments(argument));
        this.title=this.checkTitle(title);
        this.email=email;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {

       this.author=checkAuthor(author);

    }

    public String getArgument() {

        return this.argument;

    }

    public void setArgument(String argument) throws WrongArgumentInsertException {

        this.argument = checkArguments(argument);
    }

    public void setArgument(Arguments argument) {

            this.argument=checkArguments(argument);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {

        this.title=checkTitle(title);

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
            return "null";
        else
            return "'" + author + "'";
    }

    private String checkArguments(Arguments arguments)
    {
        if(arguments==Arguments.Any)
            return "null";
        else
            return "'"+arguments.getArgument()+"'";
    }

    private String checkArguments(String arguments) throws WrongArgumentInsertException {

        String check=null;

        if(StringUtils.isEmptyOrWhitespaceOnly(arguments))
            return "null";
        else {
            for (Arguments arguments1 : Arguments.values()) {
                if (arguments1.getArgument().equals(arguments))
                      check=arguments1.getArgument();
            }
            if (check==null)
                throw new WrongArgumentInsertException();
            else
                return "'" + check + "'";
        }


    }

    private String checkTitle(String title)
    {
        if(StringUtils.isEmptyOrWhitespaceOnly(title))
            return "null";
        else
            return "'"+title+"'";
    }


}
