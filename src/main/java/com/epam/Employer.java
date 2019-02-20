package com.epam;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Employer extends Person {
    Employer(String name, int age, int numberOfEmploees) {
        super(name, age);
        this.numberOfEmployees = numberOfEmploees;
    }

    @Column
    int numberOfEmployees;

    @Override
    public String toString() {
        return super.toString() +
                "{" +
                "numberOfEmploees=" + numberOfEmployees +
                '}';
    }
}
