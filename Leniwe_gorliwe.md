Są dwa podejścia do ładowania danych:
- gorliwe
- leniwe

Różnica polega na podejściu do ładowania z bazy danych zależności między encjami.

W Hibernate można ustawiać poprzez adnotację @Fetch na polu klasy będącym inną encją.


##Gorliwe:
1. adnotacja: @Fetch(FetchMode.JOIN) 
1. Podczas uruchomienia programu ładuje instancję obiektu oraz wszystkie zależne instancje.
2. Zapytanie do bazy budowane przez JOIN
3. Wyciąga wszystkie potrzebne dane z bazy i ładuje od razu do pamięci aplikacji wszystkie zależności.
4. Zalety:
+ po załadowaniu wszystkiego, aplikacja działa szybko, mniejsze ryzyko spowolnień
5. Wady:
+ zwiększa czas ładowania danych, powodując problemy z dostępnością aplikacji
+ mocno obciąża bazę danych

##Leniwe: 
1. Adnotacja: @Fetch(FetchMode.SELECT)
1. Obiekt jest ładowany, ale wszystkie zależności są ściągane z bazy danych dopiero gdy są potrzebne (np. wywołując getCośtam()).
2. Domyślne ustawienie Hibernate
3. Wtedy gdy jest potrzebne, zapytanie do bazy budowane jest przez SELECT
4. Zalety: 
+ szybsza inicjalizacja
+ mniejsze obciążenie bazy danych
+ mniejsze zużycie pamięci
5. Wady:
+ Może spowodować spowolnienia w trakcie działania aplikacji
+ W niektórych przypadkach trzeba ostrożnie obchodzić się z leniwie ładowanymi obiektami, 
by uniknąć wyjątków.

##Błędy:
###org.hibernate.LazyInitializationException
Powstaje, gdy próbujemy załadować leniwie obiekty już po zamknięciu EntityManagera 
(? - nie wiem), więc aplikacja nie ma połączenia z bazą i nie może dociągnąć danych.
###n+1 Select Problem
+ Problem wydajnościowy występujący przy listach zagnieżdżonych i leniwym ładowaniu.
+ Mamy tabelę z użytkownikami. Każdy użytkownik ma kilka zawrtych przez siebie umów (jeden-do-wielu).
Chcemy wyświetlić (wylistować) wszystkie osoby wraz z umowami, jakie posiadają.
+ Pobieramy listę osób i dla każdej osoby listę jej umów
+ Hibernate tworzy 1 zapytanie wyciągające z bazy listę n-osób i (leniwie) dla każdej osoby 
zapytanie wyciągające listę jej umów. Razem mamy n + 1 zapytań
+ SQL pozwala nam takie dane wyciągnąć 1 zapytaniem - o wiele wydajniej!
+ Rozwiązania:
1. "podejście gorliwe" - niezbyt właściwe: kolekcje ładować gorliwie. Źle, bo zazwyczaj nie jest to potrzebne.
2. "na szybko" - pobieranie paczek, np. po 10 sztuk, adnotacja: @BatchSize(size=10)
3. Właściwe: szyć na miarę zapytania gdy jest to potrzebne, tworząc kwerendy tak, by ładować przez JOIN