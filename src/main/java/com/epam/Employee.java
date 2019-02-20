package com.epam;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Employee extends Person {
    Employee(String name, int age, int salary) {
        super(name, age);
        this.salary = salary;
    }

    @Column
    int salary;

    @Override
    public String toString() {
        return super.toString() +
                "{" +
                "salary=" + salary +
                '}';
    }
}
