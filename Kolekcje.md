https://docs.jboss.org/hibernate/orm/3.5/api/org/hibernate/mapping/PersistentClass.html

Nazwa | Znane podklasy | Opis
:-------------------:|:-------------------|-------------------:
org.hibernate.mapping.Collection | Bag, IdentifierCollection, IndexedCollection, Set|Mapowanie dla kolekcji. Podklasy specjalizują się w poszczególnych typach kolekcji.
org.hibernate.mapping.Bag | |Torba pozwala na duplikaty, więc nie ma klucza podstawowego
org.hibernate.mapping.IdentifierCollection |IdentifierBag |Kolekcja z syntetyczną kolumną "identyfikator"
org.hibernate.mapping.IdentifierBag |  |Identyfikator ma klucz podstawowy składający się z kolumny identyfikującej
org.hibernate.mapping.IndexedCollection |List, Map|Zindeksowane kolekcje obejmują listy, mapy, tablice i prymitywne tablice.
org.hibernate.mapping.List |Array|Mapowanie list ma klucz podstawowy składający się z kolumn kluczowych + kolumna indeksowa.
org.hibernate.mapping.Map | |Mapa ma klucz podstawowy składający się z kolumn kluczowych + kolumn indeksu.
org.hibernate.mapping.Set | |Zestaw bez kolumn z elementem zerowalnym. Będzie miał klucz podstawowy składający się ze wszystkich kolumn tabeli (np. Kolumny kluczowe + kolumny elementów).