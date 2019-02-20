## 5. Absolutne podstawy hibernate
Łączenie z bazą, podstawowe tworzenie tabel przez hibera.

Hibernate to biblioteka do realizacji warstwy dostępu do danych (ang. persistance layer), służącą do mapowania obiektowo-relacyjnego (ORM) oraz implementującą JPA.
Najprostrzym sposobem dodania Hibernate do Javowego projektu jest użycie mavena oraz dodanie odpowiedniej zależności, którą można znaleźć pod adresem http://hibernate.org/orm/releases/ wybierając odpowiednią wersję biblioteki.
Następnie trzeba go skonfigurować, na co jest kilka sposobów, jednym z nich jest dodanie pliku hibernate.properties do katalogu resources (w przypadku projektu mavenowego). w nim należy wskazać sterownik bazy danych, z którą chcemy się połączyć, jej adres, login hasło użytkownika bazodanowego oraz odpowiedni dialekt SQL właściwy dla bazy. Szablon takiego pliku wygląda następująco:

```hibernate.connection.driver_class = 
hibernate.connection.url = 
hibernate.connection.username = 
hibernate.connection.password = 
hibernate.dialect =
```
Gdy konfigurację mamy już za sobą i chcemy połączyć się z bazą danych z poziomu programu, to znowu mamy kilka możliwości, z których najprostszą i działającą, jest stworzenie obiektu typu Configuration, następnie zbudowaniu dzięki niemu SessionFactory i w końcu utworzenie z niego Session. Kod wygląda tak:

```Configuration config = new Configuration();
SessionFactory sessionFactory = config.buildSessionFactory();
Session session = sessionFactory.openSession();
```

### Zadanie

Korzystając z załączonego projektu mavenowego, połącz się z lokalną bazą danych. Zwróć uwagę na plik konfiguracyjny hibernate.properties i ewentualnie go zmodyfiku.
