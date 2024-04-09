package com.ispw.circularbook.engineering.Enums;

public enum City {
    Any(""),Ancona("Ancona"),Aosta("Aosta"),Bari("Bari"),Bologna("Bologna"),Cagliari("Cagliari"),Campobasso("Campobasso"),Catanzaro("Catanzaro"),Firenze("Firenze"),Genova("Genova"),Aquila("L'aquila"),Milano("Milano"),Napoli("Napoli"),Palermo("Palermo"),Perugia("Perugia"),Potenza("Potenza"), Torino("Torino"),Roma("Roma"),Trento("Trento"), Trieste("Trieste"), Venezia("Venezia");

    private final String city;

    City(String city){
        this.city=city;
    }

    public String getCity()
    {
        return this.city;
    }

}
