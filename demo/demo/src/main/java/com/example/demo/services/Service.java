package com.example.demo.services;

@org.springframework.stereotype.Service

public class Service {
    //pliki_strony_kontroler/kalendarz.php?rok=" + rok + "&miesiac=" + miesiac + "&lang=" + lang;
    private static final String CALENDAR_ENDPOINT = "http://www.weeia.p.lodz.pl/pliki_strony_kontroler/kalendarz.php";
    public String getCalendar(int year, int month) {
        //jsoup - biblioteka do pobierania danych z stron www
        return "year: " + year + " month: "+month;
    }
}
