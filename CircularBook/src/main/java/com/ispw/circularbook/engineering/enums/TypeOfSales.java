package com.ispw.circularbook.engineering.enums;

public enum TypeOfSales {

    Any(0,"Non Specificato"),Event(1,"Evento"),Promotion(2,"Promozione");
    private final int id;
    private final String type;
    TypeOfSales(int id, String type)
    {
        this.id=id;
        this.type=type;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}
