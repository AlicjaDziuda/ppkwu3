package com.example.demo.services;

import biweekly.Biweekly;
import biweekly.ICalendar;
import biweekly.component.VEvent;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@org.springframework.stereotype.Service

public class Service {
    //pliki_strony_kontroler/kalendarz.php?rok=" + rok + "&miesiac=" + miesiac + "&lang=" + lang;
    private static final String CALENDAR_ENDPOINT = "http://www.weeia.p.lodz.pl/pliki_strony_kontroler/kalendarz.php";
    public ResponseEntity<?> getCalendar(String year, String month) throws IOException {
        if(Integer.parseInt(month)>12 || Integer.parseInt(month)<1) {
            return  ResponseEntity.badRequest().body("Nie prawidłowy miesiąc");
        }
        //jsoup - biblioteka do pobierania danych z stron www

        //pobieranie źródła strony www
        Connection connect = Jsoup.connect(CALENDAR_ENDPOINT + "?rok=" + year + "&miesiac=" + month);
        Document document = connect.get();

        //wyciąganie informacji z dokumentu
        Elements daysElements = document.select("a.active");
        Elements eventNamesElements = document.select("div.InnerBox");

        //utworzenie kalendarza
        ICalendar ical = new ICalendar();
        for(int i = 0; i < daysElements.size(); i++) {
            String day = daysElements.get(i).text();
            String event = eventNamesElements.get(i).text();

            //utworzenie wydarzenia
            VEvent vEvent = new VEvent();

            //tytul wydarzenia
            vEvent.setSummary(event);

            //data wydarzenia - rok, miesiac, dzien
            Calendar date = Calendar.getInstance();
            date.set(Integer.parseInt(year), Integer.parseInt(month) - 1, Integer.parseInt(day));

            //czas
            vEvent.setDateStart(date.getTime());
            vEvent.setDateEnd(date.getTime());

            //dodanie wydarzenia do kalendarza
            ical.addEvent(vEvent);

        }

        File file = new File("Month" + month+ "Year"+ year + "Calendar.ics");
        Biweekly.write(ical).go(file);

        Resource fileStreamResource = new FileSystemResource(file);
        return ResponseEntity.ok()
                             .contentType(MediaType.parseMediaType("text/calendar"))
                             .body(fileStreamResource);
    }
}
