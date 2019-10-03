package com.labus.showcase.sourceInformation.htmlParser.ParseTransportFactory;

import com.labus.showcase.entity.Staying;
import org.jsoup.select.Elements;

public abstract class ParseStaying {
    public Staying getStaying(){
        return null;

    }
    protected abstract Elements getElements();

}
