package com.epam;

import javax.persistence.*;


@Entity
public class Person {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "FULL_NAME")
    private String name;
    private int age;

    @Enumerated(EnumType.STRING)
    @Column(length = 15)
    private Plec plec;

    public Person() {};

    public Person(String name, int age, Plec plec) {
        this.name = name;
        this.age = age;
        this.plec = plec;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", plec=" + plec +
                '}';
    }
}