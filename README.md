# MOBILNY KALENDARZ WEEIA
Usługa generuje kalendarz w formacie ics dla kalendarza ze strony [wydziału EEIA](http://www.weeia.p.lodz.pl/).

## Poprawny sposób użycia
### Zapytanie:


```
http://localhost:8080/api/calendar/2020/03
```

### Odpowiedź:

##### Wygenerowany plik ics dla podanego mięsiąca i roku, w którym zapisano wszystkie wydarzenia oznaczone na kalendarzu ze strony [wydziału EEIA](http://www.weeia.p.lodz.pl/).

### Przykładowy plik:
[plik dla marca 2020 roku](https://raw.githubusercontent.com/AlicjaDziuda/ppkwu3/master/demo/demo/Month03Year2020Calendar.ics)

## Uwagi:

### 1. Niepoprawna forma miesiąca:
#### Konieczne jest aby miesiące od stycznia do września poprzedzać zerem.
#### Przykład:
##### Zapytanie typu :  
```
http://localhost:8080/api/calendar/2020/3
```
##### Wygeneruje plik nie zawierający żadnych wydarzeń 

### 2. Podanie nieistniejącego miesiąca:
#### Wprowadzenie miesiąca, który nie istnieje, np. 0, 00, -54, 243 to otrzyma informacje :
#### Przykład:
##### Zapytanie typu :  
```
http://localhost:8080/api/calendar/2020/-32
```
##### Nie wygeneruje żadnego pliku. Pojawi się tylko komunikat: 
```bash
Nie prawidłowy miesiąc
```  
