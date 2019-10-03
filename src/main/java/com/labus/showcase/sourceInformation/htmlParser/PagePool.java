package com.labus.showcase.sourceInformation.htmlParser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.sql.Time;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PagePool {
    private static boolean isCreated = false;
    private static PagePool poolInstance;
    private static Date dateCreated;
    private static long actualIntervalTime= 60*60*100;
    private Map<String, Document> pages = new HashMap<>();

    public static PagePool getInstance() {
        if (!isCreated) {
            synchronized (PagePool.class) {
                poolInstance = new PagePool();
                isCreated = true;
                dateCreated = new Date();
            }
        }
        return poolInstance;
    }
    public Document getDocument(String url) throws IOException {
        if(new Date().getTime()-dateCreated.getTime()>actualIntervalTime) {
            pages.clear();
            dateCreated = new Date();
        }
        if(pages.containsKey(url))
            return pages.get(url);
        Document document = Jsoup.connect(url)
                .userAgent("Chrome/4.0.249.0 Safari/532.5")
                .referrer("http://www.google.com")
                .get();
        pages.put(url, document);
        return document;
    }



}
