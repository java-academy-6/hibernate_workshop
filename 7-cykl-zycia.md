#Cykl życia

Hibernate zajmuje się przechowywaniem obiektów z naszego programu.
Obiekty te mogą znajdować się w różnych stanach, które określają w jaki sposób hibernate będzie się nimi interesował i zajmował.


#### 4 stany
- transient - obiekty w tym stanie są niewidoczne dla hibera. 
Znajdują się tu wszystkie nowo stworzone obiekty, dopóki nie zapiszemy ich w bazie.

- persistent - obiekty przechodzą do tego stanu na czas zapisu lub odczytu, czyli kiedy odpalamy session.save(), load itp.
Pozostają w tym stanie do zamknięcia sesji. Obiekty w tym stanie są synchronizowane z bazą. Czyli nawet jeśli po zapisie zmienimy coś w obiekcie, to wpis w bazie zostanie zaktualizowany.
Ulubiony stan hibera

- detached - obiekty które były wcześniejw stanie persystencji, przechodzą tu po zamknięciu sesji. 

- removed - po usunięciu sesji  

![](object-states.JPG)
