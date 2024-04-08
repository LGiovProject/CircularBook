package com.ispw.circularbook.engineering.Enums;

public enum Arguments {
    Any(" "), Historical("Storico"), Biography("biografia"), Auto_Biography("Auto Biografico"), Thriller("Thriller"), Adventure("Avventura"), Action("Azione"), Science_fiction("Science_fiction"), Fantasy("Fantasy"), Horror("Horror"), Romance("Romantico"), Comic_book("Comico"), Other("Altro");

    private final String argument;
    Arguments(String argument)
    {
        this.argument=argument;
    }
    public String getArgument()
    {
        return argument;
    }

}