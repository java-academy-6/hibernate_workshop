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

    public Person() {};

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}