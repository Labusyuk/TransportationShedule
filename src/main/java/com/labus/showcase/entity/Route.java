package com.labus.showcase.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Route extends LinkedList<Staying> implements Serializable {
    private String name;
    private int duration = 0;
    private TimeOfDay startTime, FinishTime;

    public Route(Collection<? extends Staying> c, String name) {
        super(c);
        this.name = name;
    }
    public Route(Collection<? extends Staying> c) {
        super(c);
        this.name = name;
    }

    public Route() {
    }

    public Route(Staying... stayings) {
        for(Staying staying:stayings)
            add(staying);
    }

    public Route(List<Staying> stayings){
        addAll(stayings);
    }

    public Route(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Route subList(int fromIndex, int toIndex) {
        return new Route(super.subList(fromIndex, toIndex));
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public TimeOfDay getStartTime() {
        return startTime;
    }

    public void setStartTime(TimeOfDay startTime) {
        this.startTime = startTime;
    }

    public TimeOfDay getFinishTime() {
        return FinishTime;
    }

    public void setFinishTime(TimeOfDay finishTime) {
        FinishTime = finishTime;
    }
}
