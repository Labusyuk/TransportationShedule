package com.labus.showcase.sourceInformation.htmlParser.ParseTransportFactory;

import com.labus.showcase.entity.TimeOfDay;
import org.jsoup.select.Elements;

import javax.xml.bind.Element;

public abstract class ParseTimeOfDay {
    public TimeOfDay getTimeOfDay(){
        return null;
    }

    protected abstract Elements getElements();
}
