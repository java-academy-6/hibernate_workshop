#### Podstawowe adnotacje w Hibernate 12.02.2019

Oparte na:

https://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html

import javax.persistence.*;

##### Używane w encjach:

- @Entity : określa, że klasa jest encją. Ma opcjonalny parametr name dzięki czemu możemy określić nazwę encji.
- @Table : definiuje podstawową tabele dla encji (czyli używana jest wspólnie z adnotacją @Entity).
- @Basic : Jest najprostszym rodzajem mapowania metod i pól na kolumne w bazach danych.
Ogólnie adnotacja @Basic może być zignorowana ponieważ jest ustawiana na każdej metodzie i polu domyślnie.
Dlatego oba poniższe fragmenty kodu są identyczne:

```java
@Entity(name = "Product")
public class Product {

   @Id
   @Basic
   private Integer id;

   @Basic
   private String sku;

   @Basic
   private String name;

   @Basic
   private String description;
}
```
```java
@Entity(name = "Product")
public class Product {

   @Id
   private Integer id;

   private String sku;

   private String name;

   private String description;
}
```
- @Column : jest używana do mapowania metod/pól na kolumny w bazie danych.
Więc jaka jest różnica między @Basic, a @Column?

- @Basic - oznacza, że atrybut ma zostać utrwalony i należy użyć standardowego mapowania.
Ma parametry, które pozwalają ci określić, czy atrybut ma być ładowany leniwie i czy jest on zerowy.

- @Column - pozwala na zdefiniowanie nazwy kolumny.
```java
@Entity(name = "Product")
public class Product {

    @Id
    private Integer id;

    private String sku;

    private String name;

    @Column( name = "NOTES" )
    private String description;
}
```
- @Id : definiuje klucz główny dla encji. Może być zdefiniowana na polu, które ma jeden z poniższych typów:
- jakikolwiek javowy prymityw (+ wrappery)
- String
- java.util.Date; 
- java.sql.Date; 
- java.math.BigDecimal; 
- java.math.BigInteger.
- @GeneratedValue : 
```java
@Id
     @GeneratedValue(strategy=SEQUENCE, generator="CUST_SEQ")
     @Column(name="CUST_ID")
     public Long getId() { return id; }
```

```java
@Id
     @GeneratedValue(strategy=TABLE, generator="CUST_GEN")
     @Column(name="CUST_ID")
     Long id;
```
- @Embeddable - 
                 

##### Używane do relacji i złączeń

- @OneToOne	
- @ManyToOne
- @OneToMany
- @ManyToMany
- @PrimaryKeyJoinColumn
- @JoinColumn
- @JoinTable
- @MapsId