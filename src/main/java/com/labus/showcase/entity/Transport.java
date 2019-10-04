package com.labus.showcase.entity;

import java.io.Serializable;
import java.sql.Time;

public class Transport implements Serializable {
    protected String name, nameType, nameRoute;
    protected Route forward, backward;

    public Transport() {
    }

    public Transport(String nameType) {
        this.nameType = nameType;
    }

    public Transport(String nameType, Route myRoute) {
        this.nameType = nameType;
        forward = myRoute;
    }

    public Transport getTransport(){
        return new Transport(nameType);
    }

    public Route buildRoute(Staying a, Staying b){
        int indexA, indexB;
        for(int i=0;i<getRoute().length;i++){
            indexA = getRoute()[i].indexOf(a);
            indexB = getRoute()[i].indexOf(b);
            if(indexA>=0 && indexB>=0 && indexA<indexB) {
                Route route = getRoute()[i].subList(indexA, indexB+1);
                route.setName(getRoute()[i].getName());
                route.setDuration(route.getLast().getTimeAfterStart()-route.getFirst().getTimeAfterStart());
                //System.out.println(getRoute()[i].getLast().getTimeAfterStart()+"-"+getRoute()[i].getFirst().getTimeAfterStart()+"="+(getRoute()[i].getLast().getTimeAfterStart()-route.getFirst().getTimeAfterStart()));
                return route;
            }
        }
        return null;
    }

    public Route getForward() {
        return forward;
    }

    public void setForward(Route forward) {
        this.forward = forward;
    }

    public Route[] getRoute() {
        return new Route[]{forward,backward};
    }

    public void setRoute(Route[] route){
        forward = route[0];
        backward = route[1];
    }

    public boolean containsStaying(Staying staying){
        return forward.contains(staying) || backward.contains(staying);
    }

    public Route getBackward() {
        return backward;
    }

    public void setBackward(Route backward) {
        this.backward = backward;
    }

    public String getName() {
        if(forward!=null)return "["+forward.getName()+" "+getNameType()+"]";
        else return "["+backward.getName()+" "+getNameType()+"]";
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public String getNameRoute() {
        return nameRoute;
    }

    public void setNameRoute(String nameRoute) {
        this.nameRoute = nameRoute;
    }
}
