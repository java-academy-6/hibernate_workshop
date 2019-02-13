# Tryby pracy

**hibernate.hbm2ddl.auto**:

hbm2ddl.auto - automatycznie waliduje lub eksportuje DDL do bazy, kiedy tworzona jest SessionFactory

### Dostępne opcje :
Przechowywane w enum Action

- none - żadna akcja nie będzie wykonana 

- create-only - zostanie utworzona baza danych

- drop - zostanie wykonany drop bazy

- create - najpierw zostanie wykonany drop bazy, a pozniej jej stworzenie

- create-drop - usuwa schemat i tworzy go znowu gdy startuje SessionFactory, dodatkowo usuwa schemat gdy SessionFactory się kończy

- validate - waliduje schemat bazy

- update - uaktualnia bazę



### Jak definiować :
np:
hibernate.hbm2ddl.auto=create

 

