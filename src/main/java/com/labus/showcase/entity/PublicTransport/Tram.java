package com.labus.showcase.entity.PublicTransport;

import com.labus.showcase.entity.Transport;

public class Tram extends Transport {
    public Tram(){
        nameType = "Трамвай";
    }
    public Transport getTransport(){
        return new Transport(nameType);
    }
}
