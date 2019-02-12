#### KASKADY - teoria

Pojęcie kaskad jest jednym ze składowych związków między encjami. Zatem:

1) Związki między encjami

a) LICZNOŚĆ

Hibernate wspiera następujące typy asocjacji między obiektami klas trwałych:
- 1:1 (@OneToOne)
- 1:N (@OneToMany)
- N:1 (@ManyToOne)
- N:M (@ManyToMany)

Asocjacje N:M zawsze **wykorzystują tabelę pośrednią** w bazie danych do reprezentacji powiązań. Asocjacje 1:1, N:1 i 1:N typowo są **implementowane bez tabeli pośredniej**, ale Hibernate umożliwia wykorzystanie tabeli
pośredniej również dla nich.

b) KIERUNKOWOŚĆ

Asocjacje mogąbyć:
- jednokierunkowe

lub
- dwukierunkowe.

Kierunkowość determinuje możliwość nawigacji między powiązanymi instancjami klas trwałych.
Asocjacja dwukierunkowa jest definiowana jako para asocjacji jednokierunkowych, ze wskazaniem dla jednej z nich, że
definiuje ona drugi kierunek nawigacji dla dwukierunkowej asocjacji.

c) KASKADA OPERACJI

Dla asocjacji istnieje możliwość zlecenia kaskadowej propagacji operacji na obiekty zależne.
**Domyślnie kaskadowa propagacja nie zachodzi.** Kaskada jest często definiowana dla związków 1:N mających charakter związku kompozycji.

Dostępne wartości atrybutu „cascade” opisującego asocjację to:
 
- none (brak propagacji)
- all (propagacja wszystkich operacji)
- save-update (propagacja utrwalania i uaktualniania)
- delete (propagacja usuwania)
- all-delete-orphan (propagacja wszystkich operacji i dodatkowo usuwanie obiektów zależnych, nie posiadających powiązania z obiektem nadrzędnym)

##### KASKADY - jak skonfigurować?

1) za pomocą XML

`<set name="nazwa" cascade="save-update, delete" table="nazwa_tabeli" ...>
    <key>
        <column name="column_name" not-null="true" />
    </key>
    <one-to-many class="path.to.our.Class" />
</set>`

2) za pomocą adnotacji

`@OneToMany(mappedBy = "name")
@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
    public Set<SomeClass> getSomeClassRecords() {
        return this.SomeClassRecords;
        }`
        
##### KASKADY - krótkie podsumowanie

Kaskady dają nam bardzo wygodną funkcjonalnośc do automatycznego zarządzania stanem obiektów zależnych.
Jednak ta funkcjonalność ma swoją cenę. Jeśli nie użyjesz jej mądrze to (np. stosując propagację utrwalania) wygenerujesz
wiele niepotrzebnych efektów kaskadowych spowalniając tym samym efektywność aplikacji albo 
(np. stosując propagację usuwania) usuniesz niektóre dane kiedy tego po prostu niezamierzałeś.