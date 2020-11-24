## MOBILNY KALENDARZ WEEIA

## Co robi usługa ? 
Usługa generuje kalendarz w formacie ics dla kalendarza ze strony http://www.weeia.p.lodz.pl/.

## Aby użyć tego api należy wpisać:
```
http://localhost:8080/api/calendar/2020/03
```
## Otrzymana odpowiedź:
### Wygenerowany plik isc w którm zapisano wszystkie wydarzenia oznaczone na kalendarzu ze strony http://www.weeia.p.lodz.pl/ w podanym miesiącu i roku.

##### Konieczne jest aby miesiące od stycznia do września poprzedzać 0, wprowadzając np,
```
http://localhost:8080/api/calendar/2020/3
```
##### Otrzymamy plik nie zawierający żadnych wydarzeń 

## Jeżeli użytkownik wprowadzi miesiąc który nie istnieje, np 0, 00, -54, 243 to otrzyma informacje :	
```
Nie prawidłowy miesiąc
```

