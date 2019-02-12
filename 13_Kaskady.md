#### KASKADY

Pojęcie kaskad jest jednym ze składowych związków między encjami. Zatem:

1) Związki między encjami

a) liczność

Hibernate wspiera następujące typy asocjacji między obiektami klas trwałych:
- 1:1 (@OneToOne)
- 1:N (@OneToMany)
- N:1 (@ManyToOne)
- N:M (@ManyToMany)

Asocjacje N:M zawsze **wykorzystują tabelę pośrednią** w bazie danych do reprezentacji powiązań. Asocjacje 1:1, N:1 i 1:N typowo są **implementowane bez tabeli pośredniej**, ale Hibernate umożliwia wykorzystanie tabeli
pośredniej również dla nich.

b) kierunkowość

Asocjacje mogąbyć:
- jednokierunkowe

lub
- dwukierunkowe.

Kierunkowość determinuje możliwość nawigacji między powiązanymi instancjami klas trwałych.
Asocjacja dwukierunkowa jest definiowana jako para asocjacji jednokierunkowych, ze wskazaniem dla jednej z nich, że
definiuje ona drugi kierunek nawigacji dla dwukierunkowej asocjacji.

c) kaskada operacji

Dla asocjacji istnieje możliwość zlecenia kaskadowej propagacji operacji na obiekty zależne.
**Domyślnie kaskadowa propagacja nie zachodzi.** Kaskada jest często definiowana dla związków 1:N mających charakter związku kompozycji.

Dostępne wartości atrybutu „cascade” opisującego asocjację to:
 
- none (brak propagacji)
- all (propagacja wszystkich operacji)
- save-update (propagacja utrwalania i uaktualniania)
- delete (propagacja usuwania)
- all-delete-orphan (propagacja wszystkich operacji i dodatkowo usuwanie obiektów zależnych, nie posiadających powiązania z obiektem nadrzędnym)

