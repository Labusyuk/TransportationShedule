package com.labus.showcase.logistics;

import com.labus.showcase.entity.Staying;
import com.labus.showcase.entity.Ways;

import java.util.Date;
import java.util.List;

public interface Logistic {
    public List<Ways> buildWays(Staying a, Staying b);
    public List<Ways>  buildWays(Staying a, Staying b, Date date);
}
