package com.epam.table_per_concrete_class;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Employee extends Person {
    public Employee(String name, int age, int salary) {
        super(name, age);
        this.salary = salary;
    }

    @Column
    int salary;
}
