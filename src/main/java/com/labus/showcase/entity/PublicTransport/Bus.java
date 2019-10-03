package com.labus.showcase.entity.PublicTransport;

import com.labus.showcase.entity.Transport;

public class Bus extends Transport {
public Bus(){
    nameType = "Автобус";
    }
    public Transport getTransport(){
        return new Transport(nameType);
    }

}
