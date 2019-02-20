WARSZTATY Z HIBERNATE

# Strategie dziedziczenia
3 strategie dziedziczenia
- 'Table per concrete class'
- 'Table per class hierarchy'
- 'Table per subclass'

## Table per concrete class:
czyli każdej nieabstrakcyjnej klasie odpowiada tabela w bazie danych. Jest to podejście najprostsze, ale jednocześnie
najmniej eleganckie. Na poziomie bazodanowym zapominamy tu bowiem o jakimkolwiek związku między klasami dziedziczącymi.

##### Wady:
To podejście nie jest polecane z kilku względów:
+ jeśli jakiś obiekt jest związany z przykładową Osobą, nie można zamieścić w nim jednego obcego klucza
 (bo nie wiadomo czy Osoba będzie Pracownikiem czy Pracodawcą)
+ jeśli Hibernate dostanie zapytanie o Osoby spełniające pewne warunki, będzie musiał wygenerować selecta na każdą podklasę.
 W naszym przypadku będzie to jedynie jedno dodatkowe zapytanie, ale podklas może być kilkadziesiąt, a każde kolejne
 odwołanie do bazy danych negatywnie wpływa na wydajność.
+ zmiana typu jednego pola w nadklasie powoduje konieczność ręcznego zrobienia tej zmiany we wszystkich podklasach.
+ implementacja więzów integralności (integrity constraints) danych nadklasy staje się niezwykle uciążliwa


## Table per class hierarchy:
czyli utworzenie jednej tabeli dla wszystkich podklas. Taka tabela zawiera kolumny odpowiadające wszystkim trwałym
(persistent) atrybutom wszystkich podklas. Dodatkowo, potrzebna jest jedna kolumna nazywana discriminator, która
określa, do jakiej podklasy należy obiekt odpowiadający danemu rekordowi w tabeli. Kolumna ta jest potrzebna
Hibernate'owi, ale dla użytkownika z poziomu Javy jest niewidoczna.
To podejście, choć może wyglądać nieelegancko, jest zazwyczaj najlepsze i polecane.
##### Wady:
+ wszystkie atrybuty muszą być zadeklarowane Hibernate'owi jako nullable.


## Table per subclass:
czyli wierne odwzorowanie modelu do tabel. Tworzymy tabelę dla nadklasy, oraz po jednej tabeli dla każdej podklasy,
przy czym tabela reprezentująca podklasę nie powiela żadnego pola, które wystąpiło w nadklasie. Jak zatem znaleźć
rekord z tabeli nadklasy odpowiadający temu z podklasy? Otóż klucz w każdej tabeli podklasy jest jednocześnie kluczem
obcym tabeli nadklasy.

##### Zalety:
+ najlepsza normalizacja tabel
+ przejrzystość oraz zachowanie modelu obiektowego
+ modelowanie więzów spójności również nie sprawia tu żadnych dodatkowych problemów.

##### Wady:
+ gdy chcemy otrzymać wszystkie osoby spełniające pewne warunki, musi zostać wykonane złączenie zewnętrzne (outer-join),
przy którym sięgamy do wielu tabel
+ uniemożliwiamy sobie, lub co najmniej bardzo utrudniamy, wykorzystanie czystego kodu SQL w połączeniu z Hibernate'em
 - dla bardziej złożonych hierarchii klas ręczne napisanie prawidłowych outer- oraz inner-joinów (inner-join jest
  wykorzystywany gdy szukamy obiektów z podklasy) jest bardzo trudne



## Zadanie
Wykorzustując przykład dziecziczenia Pracownik extends Osoba i Pracodawca extends Osoba, zaimplementuj 3 strategie 
dziedziczenia w Hibernate. Zobacz odziweciedlenie każdego rozwiązania w bazie danych.