package com.labus.showcase.sourceInformation.htmlParser.ParseTransportFactory;

import com.labus.showcase.entity.Route;
import com.labus.showcase.entity.Showcase;
import com.labus.showcase.entity.Staying;
import com.labus.showcase.sourceInformation.htmlParser.PagePool;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Date;

public class ParseRoute {
    String url;
    PagePool pagePool = PagePool.getInstance();

    public ParseRoute(String url) {
        this.url = url;
    }

    protected Route[] getRoute() throws IOException {
        Route route[] = new Route[2];
        route[0] = new Route();
        route[1] = new Route();
        Document document = pagePool.getDocument(url);
        Route route1 = parseStaying(document);
        String[] s = document.baseUri().split("/");
        String str[] = document.select("button.view-more.js-sort-route").attr("onclick").replaceAll(".*\\(|\\).*", "").split(", ");
        String urlRoute2 = s[0]+"//"+s[2]+"/"+s[3]+"/"+s[4]+"/"+str[0]+(!str[1].equals("null")?"/"+str[1]:"");
        document = pagePool.getDocument(urlRoute2);
        Route route2 = parseStaying(document);
        return new Route[]{route1,route2};
    }

    public Route parseStaying(Document document) throws IOException {
        Route route = new Route();
        Elements listRoute = document.select("div.wrapp");
        route.setName(listRoute.select("div.schedule-top").select("div.title").select("div.number").text());
        for(Element elementStaying:listRoute.select("div.chosen-route.active").select("li")){
            String[] s = document.baseUri().split("/");
            String str[] = elementStaying.attr("onclick").replaceAll(".*\\(|\\).*", "").split(", ");
            String urlRoute2 = s[0]+"//"+s[2]+"/"+s[3]+"/"+s[4]+"/"+str[0]+(!str[1].equals("null")?"/"+str[1]:"");
            ParseShowCase parseShowCase = new ParseShowCase(urlRoute2);
            Staying staying = new Staying();
            staying.setShowCaseWorkingDays(parseShowCase.getShowCaseWorkingDays());
            staying.setShowCaseWeekend(parseShowCase.getShowCaseWeekend());
            staying.setTimeAfterStart(elementStaying.select("span").text());
            elementStaying.select("span").remove();
            staying.setName(elementStaying.text());
            route.add(staying);
        }
        return route;
    }

    public static void main(String[] args) {
        try {
            new ParseRoute("https://vn.rozklad.in.ua/home/schedule/8").getRoute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        String str = "https://vn.rozklad.in.ua/home/schedule/8";
        String[] s = str.split("/");
        System.out.println(s[0]+"//"+s[2]+"/"+s[3]+"/"+s[4]+"");*/
    }

}
