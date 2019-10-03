package com.labus.showcase.entity;

import org.apache.commons.collections.list.TreeList;

import java.util.*;

public class Showcase extends LinkedList<TimeOfDay> {
    public Showcase() {
    }
    public TimeOfDay getAfter(TimeOfDay timeOfDay){
                Iterator<TimeOfDay> iterator = super.iterator();
        while(iterator.hasNext()){
            TimeOfDay tempTimeOfDay = iterator.next();
            if(timeOfDay.getHour()<=tempTimeOfDay.getHour())
                if(timeOfDay.getMinute()<=tempTimeOfDay.getMinute())
                    if(timeOfDay.getSecond()<=tempTimeOfDay.getSecond())
                        return tempTimeOfDay;
        }
        return null;
    }

    public void sort(){
        sort((x1,x2)->{
            if(x1.getHour()-x2.getHour()==0)
                return x1.getMinute()-x2.getMinute();
            else return x1.getHour()-x2.getHour();
        });
    }
}
