package com.labus.showcase.sourceInformation.htmlParser.ParseTransportFactory;

import com.labus.showcase.entity.Route;
import com.labus.showcase.entity.Showcase;
import com.labus.showcase.entity.TimeOfDay;
import com.labus.showcase.sourceInformation.htmlParser.PagePool;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ParseShowCase {
    private String url;
    private PagePool pagePool = PagePool.getInstance();
    private Document document;

    public ParseShowCase(String url) {
        this.url = url;
    }

    public Showcase getShowCaseWorkingDays() throws IOException {
        document = pagePool.getDocument(url);
        return parseShowCase("div.column.working-days");
    }

    public Showcase getShowCaseWeekend() throws IOException {
        document = pagePool.getDocument(url);
        return parseShowCase("div.column.column.weekend");
    }

    private Showcase parseShowCase(String div){
        Showcase showcase = new Showcase();
        Elements elements = document.select("div.schedule-wrapp");
        Elements shedule = elements.select(div);
        String time[]=new String[3];
        time[0]="0";
        time[1]="0";
        time[2]="0";
        for(Element elementsTr : shedule.select("table").select("tr")){
            Element hourElement = elementsTr.select("td").first();
            if(hourElement!=null) {
                time[0] = hourElement.text();
                elementsTr.select("td").first().remove();
                for (Element elementTd : elementsTr.select("td")) {
                    if (elementTd.text().isEmpty()) continue;
                    time[1] = elementTd.text();
                    showcase.add(new TimeOfDay(time[0],time[1],time[2]));
                }
            }
        }
        return showcase;
    }

    public static void main(String[] args) {
        ParseShowCase parseShowCase = new ParseShowCase("https://vn.rozklad.in.ua/home/schedule/12/1457");
        try {
            System.out.println(parseShowCase.getShowCaseWeekend().getAfter(new TimeOfDay("20","47","00")).getValue());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
