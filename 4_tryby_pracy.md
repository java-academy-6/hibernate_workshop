# Tryby pracy

**hibernate.hbm2ddl.auto**:

hbm2ddl.auto - automatycznie waliduje lub eksportuje DDL do bazy, kiedy tworzona jest SessionFactory

### Dostępne opcje :
Przechowywane w enum Action

- none - żadna akcja nie będzie wykonana 

- create-only - zostanie utworzona baza danych

- drop - zostanie wykonany drop bazy

- create - najpierw zostanie wykonany drop bazy, a pozniej jej stworzenie

- create-drop - usuwa schemat i tworzy go znowu gdy startuje SessionFactory, dodatkowo usuwa schemat gdy SessionFactory się kończy, stosowane przy testowaniu

- validate - waliduje schemat bazy

- update - uaktualnia bazę


### Jak definiować :
W pliku hibernate.properties:
hibernate.hbm2ddl.auto=create

W pliku hibernate.cfg.xml
 <property name="hbm2ddl.auto">create</property>
 
 UWAGA ! 
 W konfiguracji xml IntelliJ podkreśla na czerwono niektóre opcje konfiguracji np: create-drop, nie należy się tym przejmować.
 
 
 ### ZADANIE
 Zmień gałązkę na hibernate_połączenie_Filip i w pliku hibernate.properties pozmieniaj opcję hibernate.hbm2ddl.auto na te podane wyżej, sprawdź jakie komunikaty się pojawiają. 


 

