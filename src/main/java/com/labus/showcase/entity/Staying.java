package com.labus.showcase.entity;

import java.io.Serializable;

public class Staying implements Serializable {
    private String name;
    private int timeAfterStart = 0;
    private Showcase ShowCaseWorkingDays, ShowCaseWeekend;

    public int getTimeAfterStart() {
        return timeAfterStart;
    }

    public void setTimeAfterStart(String timeAfterStart) {
        if(timeAfterStart.isEmpty())
            this.timeAfterStart = 0;
        else
            this.timeAfterStart = Integer.parseInt(timeAfterStart.substring(0,timeAfterStart.indexOf('’')));
    }

    public Staying() {
    }

    public Staying(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        return ((Staying)obj).getName().equals(name);
    }

    public Showcase getShowCaseWorkingDays() {
        return ShowCaseWorkingDays;
    }

    public void setShowCaseWorkingDays(Showcase showCaseWorkingDays) {
        ShowCaseWorkingDays = showCaseWorkingDays;
    }

    public Showcase getShowCaseWeekend() {
        return ShowCaseWeekend;
    }

    public void setShowCaseWeekend(Showcase showCaseWeekend) {
        ShowCaseWeekend = showCaseWeekend;
    }
}
