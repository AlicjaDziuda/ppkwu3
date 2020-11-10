package com.example.demo.services;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service

public class Service {
    //pliki_strony_kontroler/kalendarz.php?rok=" + rok + "&miesiac=" + miesiac + "&lang=" + lang;
    private static final String CALENDAR_ENDPOINT = "http://www.weeia.p.lodz.pl/pliki_strony_kontroler/kalendarz.php";
    public List<String> getCalendar(int year, int month) throws IOException {
        //jsoup - biblioteka do pobierania danych z stron www

        //pobieranie źródła strony www
        Connection connect = Jsoup.connect(CALENDAR_ENDPOINT + "?rok=" + year + "&miesiac=" + month);
        Document document = connect.get();

        //wyciąganie informacji z dokumentu
        Elements daysElements = document.select("a.active");
        Elements eventNamesElements = document.select("div.InnerBox");
        

        //lista glowna
        List<String> events = new ArrayList<>();

        for(int i = 0; i < daysElements.size(); i++) {
            String day = daysElements.get(i).text();
            String event = eventNamesElements.get(i).text();
            events.add(day+" "+event);
        }
        return events;
    }
}
