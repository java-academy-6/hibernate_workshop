# ENTITY MANAGER

Nakładka na projekt Hibernate Core wprowadzająca EntityManager jako centralną klasę, z poziomu której wykonywana jest komunikacja z bazą danych. Połączenie podprojektów Hibernate EntityManager oraz Hibernate Annotations pozwala posługiwać się techniką mapowania obiektowo-relacyjnego zgodnie ze standardem Java Persistence API. 

EntityManager wywołuje pod spodem hibernatową sesję (Session) i w przeciwieństwie do niej spełnia standard JPA. Ciekawostka: aby z rządcy encji wyciągnąć sesję należy zrobić tak:
`Session session = entityManager.unwrap(Session.class);`

Aby skorzystać w Hibernate z perzystancji, w folderze resources/META-INF zamiast pliku hibernate.    properties należy umieścić plik persistence.xml. Jego treść jest zależna od bazy danych, której      użyjesz. [Tutaj znajdziesz pliki persistence.xml dla większości używanych baz danych](https://       www.javatips.net/blog/hibernate-jpa-with-h2-database)

Aby użyć rządcy encji nie potrzebna jest żadna dodatkowa zależność, ponieważ znajduje się on w zależności hibernate-core. Rządcę encji można zainicjalizować na dwa sposoby:
1. Poprzez kontener - tutaj to kontener stworzy rządcę encji korzystając z fabryki zakulisowo:
`@PersistenceContext
EntityManager entityManager;`

2. Poprzez fabrykę zarządzaną z poziomu aplikacji:
`EntityManagerFactory emf = Persistence.createEntityManagerFactory("nazwa jednostki perzystancji");
EntityManager em = emf.createEntityManager();`
parametr podawany do metody createEntityManagerFactory jest zdefiniowany w pliku persistence.xml pod znacznikiem <persistence-unit name = >



 


