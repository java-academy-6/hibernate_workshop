Id - istotna sprawa w tabelach baz danych. Służy jako identyfikator rzędu. Taki oto identyfikator ma różne strategie, którym się trzeba bliżej przyjżeć, a mianowicie:
- IDENTITY
- SEQUENCE
- TABLE (SEQUENCE)


Jak to wygląda w Hiberze:

@Id - adnotacja naznaczająca kolumnę jako PRIMARY KEY w tabeli.
@GeneratedValue - adnotacja służąca do generowanie wartości id. Domyślnie jest to strategia, która automatycznie zwiększa wartość. czyli @GeneratedValue(strategy = GenerationType.IDENTITY) 


1. Generator IDENTITY - umożliwia automatyczną inkrementację kolumny typu integer na żądanie.

```@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;```

2. Generator SEQUENCE - sekwencja to obiekt bazy danych, który generuje przyrostowe liczby całkowite dla każdego kolejnego żądania. Sekwencje są znacznie bardziej elastyczne niż kolumny IDENTITY, ponieważ:

- sekwencja jest wolna od tabel, tę samą sekwencję mozna przypisać do wielu kolumn lub tabel

- sekwencja może wstępnie przydzielać wartości, aby poprawić wydajność


Więcej info dla zainteresowanych tematem: 
https://vladmihalcea.com/hibernate-identity-sequence-and-table-sequence-generator/
https://www.youtube.com/watch?v=a0ScR_JAKfI
Uwaga hindu, trener Javy, Pan Kishan: https://www.youtube.com/watch?v=yq0MGphGiMY
