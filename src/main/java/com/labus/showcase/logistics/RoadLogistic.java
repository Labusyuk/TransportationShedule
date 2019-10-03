package com.labus.showcase.logistics;

import com.labus.showcase.entity.Route;
import com.labus.showcase.entity.Staying;
import com.labus.showcase.entity.Ways;
import com.labus.showcase.sourceInformation.htmlParser.ParseTransportFactory.ParseTransport;
import com.labus.showcase.sourceInformation.htmlParser.TransportPool;
import com.labus.showcase.entity.Transport;
import org.apache.commons.collections.CollectionUtils;

import java.io.IOException;
import java.util.*;

public class RoadLogistic implements Logistic {
    TransportPool transportPool = TransportPool.getInstance();
    List<Transport> transports;

    public RoadLogistic() {
        try {
            transports = transportPool.getTransport();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Ways> buildWays(Staying a, Staying b){
        List<Ways> ways = new ArrayList<>();
        Route myRoute;
        //Построения маршрута без пересадок
        for(Transport transport:transports){
                /*int indexA = transport.getRoute().indexOf(a),
                        indexB = transport.getRoute().indexOf(b);
                if(indexA<indexB && indexA !=-1 && indexB !=-1){
                    List<Transport> transports1 = new LinkedList<>();
                    Route route = new Route(transport.getRoute().subList(indexA,indexB));
                    Transport transport1 = new Transport("as", )*/
                    if((myRoute = transport.buildRoute(a,b))!=null){
                        Ways way = new Ways();
                        way.add(new Transport(transport.getNameType(), myRoute));
                        ways.add(way);
                    }
        }
        //Построения маршрутов с одной пересадкой
        if(ways.size()<=1){
            List<Transport> transportsA = new ArrayList<>(), transportsB = new ArrayList<>();
            for(Transport transport:transports) {
                if (transport.containsStaying(a))
                    transportsA.add(transport);
                if (transport.containsStaying(b))
                    transportsB.add(transport);
            }

            for(Transport transportA:transportsA){
                for(Transport transportB:transportsB){
                    Route jointRoute;
                    //У каждого транспорта по 2 маршрута.
                    outer:for(int i=0;i<2;i++)
                        for(int k=0;k<2;k++)
                    if((jointRoute = new Route(CollectionUtils.retainAll(transportA.getRoute()[i], transportB.getRoute()[k]))).size()>=1){
                        //System.out.println(jointRoute.getFirst().getName());
                        Ways way = new Ways();
                        Route route1 = transportA.buildRoute(a,jointRoute.getFirst()),
                                route2 = transportB.buildRoute(jointRoute.getFirst(),b);
                        //System.out.println(route1+" "+route2);
                        if(route1==null || route2==null)
                            continue ;
                        Transport transport1 = new Transport(transportA.getNameType(),route1),
                                transport2 = new Transport(transportB.getNameType(),route2);
                        way.add(transport1);
                        way.add(transport2);
                        ways.add(way);
                        break outer;
                    }
                }
            }
        }
        return ways;
    }

    public List<Ways>  buildWays(Staying a, Staying b, Date date) {
        List<Ways> ways = buildWays(a,b);


        return null; //TODO
    }

    public static void main(String[] args) {
        /*try {
            Set<Staying> stayings = TransportPool.getInstance().getStaying();
            for(Staying staying:stayings)
                System.out.println(staying.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        for(Ways ways:new RoadLogistic().buildWays(new Staying("вул. Воїнів Інтернаціоналістів"), new Staying("Педколедж"))){
            for(Transport transport: ways){
                System.out.print(transport.getName()+" ["+transport.getForward().getDuration()+"] "+transport.getForward().getFirst().getName()+" "+transport.getForward().getLast().getName()+" --- ");
            }
            System.out.println();
        }
    }
}
