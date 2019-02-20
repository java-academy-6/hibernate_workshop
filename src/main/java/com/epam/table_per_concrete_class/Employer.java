package com.epam.table_per_concrete_class;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Employer extends Person {
    public Employer(String name, int age, int numberOfEmploees) {
        super(name, age);
        this.numberOfEmploees = numberOfEmploees;
    }

    @Column
    int numberOfEmploees;
}
