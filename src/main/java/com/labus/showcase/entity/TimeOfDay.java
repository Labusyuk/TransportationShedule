package com.labus.showcase.entity;
///Существуют готовые классы времени. Но мне нужно лишь времья в интервале 24 часов.
public class TimeOfDay {
    private int hour = 0;
    private int minute = 0;
    private int second = 0;

    public TimeOfDay(String hour, String minute, String second) {
        setValue( hour,  minute,  second);
    }


    public String getValue() {
        return hour+":"+minute+":"+second;
    }

    public void setValue(String hour, String minute, String second) {
        this.hour = Integer.parseInt(hour.replaceAll("[^0-9]", ""));
        this.minute = Integer.parseInt(minute.replaceAll("[^0-9]", ""));
        this.second = Integer.parseInt(second.replaceAll("[^0-9]", ""));
    }

/*    @Override
    public String toString() {
        String time = new String("");
        int temp=0;
        temp=value/3600;
        time+=temp>9?temp:"0"+temp+":";
        temp=value/60;
        time+=temp>9?temp:"0"+temp;
        if((temp=value%60)>0)
            time+=":"+(temp>9?temp:"0"+temp);
        return time;
    }*/

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }
/*
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("00000");
        str.replace(1,4,"123");
        System.out.println(str);
    }*/
}
