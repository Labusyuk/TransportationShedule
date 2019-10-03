package com.labus.showcase.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class Ways extends ArrayList<Transport> implements Serializable {
    public Ways(Collection<? extends Transport> c) {
        super(c);
    }

    public Ways() {
    }

    @Override
    public boolean add(Transport transport) {
        return super.add(transport);
    }
}
