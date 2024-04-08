package com.ispw.circularbook.engineering.Enums;

public enum Month {
    Cerca_in_tutti_i_mesi(0,""),January(1,"January"), February(2,"February"), March(3,"March"), April(4,"April"), May(5,"May"), June(6,"June"), July(7,"July"), August(8,"August"), September(9,"September"), October(10,"October"), November(11,"November"), December(12,"December");
    private final int id;
    private final String month;
    Month(int id,String month)
    {
        this.id=id;
        this.month=month;
    }

    public int getId()
    {
        return id;
    }
    public String getMonth()
    {
        return month;
    }

}


