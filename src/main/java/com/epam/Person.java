package com.epam;

import javax.persistence.*;

@Entity
public abstract class Person {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String name;
    @Column
    private int age;

    Person(String name, int age) {
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
