## 5. Absolutne podstawy hibernate

Łączenie z bazą, podstawowe tworzenie tabel przez hibera.

#### Czym jest Hibernate

Hibernate to biblioteka do realizacji warstwy dostępu do danych (ang. persistance layer), służącą do mapowania obiektowo-relacyjnego (ORM) oraz implementującą JPA.

#### Konfiguracja

Najprostrzym sposobem dodania Hibernate do Javowego projektu jest użycie mavena oraz dodanie odpowiedniej zależności, którą można znaleźć pod adresem http://hibernate.org/orm/releases/ wybierając odpowiednią wersję biblioteki.
Następnie trzeba go skonfigurować, na co jest kilka sposobów, jednym z nich jest dodanie pliku hibernate.properties do katalogu resources (w przypadku projektu mavenowego). w nim należy wskazać sterownik bazy danych, z którą chcemy się połączyć, jej adres, login hasło użytkownika bazodanowego, odpowiedni dialekt SQL właściwy dla bazy oraz strategię określającą jak i czy Hibernate ma modyfikować bazę danych. Szablon takiego pliku wygląda następująco:

```hibernate.connection.driver_class = 
hibernate.connection.url = 
hibernate.connection.username = 
hibernate.connection.password = 
hibernate.dialect =
hibernate.hbm2ddl.auto = 
```
Gdy konfigurację mamy już za sobą i chcemy połączyć się z bazą danych z poziomu programu, to znowu mamy kilka możliwości, z których najprostszą i działającą, jest stworzenie obiektu typu Configuration, następnie zbudowaniu dzięki niemu SessionFactory i w końcu utworzenie z niego Session. Kod wygląda tak:

```Configuration config = new Configuration();
SessionFactory sessionFactory = config.buildSessionFactory();
Session session = sessionFactory.openSession();
```

#### Tworzenie encji

Aby utworzyć encję potrzebujemy oznaczyć klasę adnotacją @Entity, w której parametrze możemy ręcznie nadać nazwę tablicy utworzonej przez Hibernate na podstawie tej klasy. Dodatkowo każde z pól klasy, które chcemy odwzorować jako kolumnę w bazie danych, możemy oznaczyć adnotacją @Column, w parametrze której możemy podać nazwę tworzonej kolumny. Każda encja musi posiadać klucz główny, który oznaczamy adnotacją @Id. Na koniec, jeśli korzystamy z konfiguracji przedstawionej wyżej, należy dodać utworzoną encję do konfiguracji.

```config.addAnnotatedClass(EncjaOsoba.class);
```

#### Mapowanie

Na podstawie encji, Hibernate generuje kwerendę do bazy danych, która tworzy tablicę oraz kolumny. Bez podania nazwy tabeli jako parametru w @Entity (lub @Table), zostanie przypisana nazwa identyczna do nazwy klasy. W przypadku nie podania nazwy katalogu lub schematu jako parametrów adnotacji @Table, Hibernate użyje domyślnych wartości właściwych dla obecnej bazy danych. Adnotacja @Id identyfikuje pole klasy jako klucz główny tabeli, Hibernate oraz JPA zakładają, że kolumna posiada również następujące modyfikatory: UNIQUE, NOT NULL oraz IMMUTABLE. Jeśli chodzi zaś o mapowania typów, to pełną ich listę można znaleźć w dokumentacji Hibernate pod adresem: http://docs.jboss.org/hibernate/orm/5.4/userguide/html_single/Hibernate_User_Guide.html#basic.

### Zadanie 1

Korzystając z załączonego projektu mavenowego, połącz się z lokalną bazą danych. Zwróć uwagę na plik konfiguracyjny hibernate.properties i ewentualnie go zmodyfikuj.

### Zadanie 2

Korzystając z załączonego projektu mavenowego i po wykonaniu poprzedniego zadania, utwórz kilka encji, a następnie zobacz jak są one odzwierciedlone w bazie danych.
