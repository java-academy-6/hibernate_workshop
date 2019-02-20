package com.epam;

import javax.persistence.*;

@Entity
public abstract class Osoba {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String imię;
    @Column
    private int wiek;

    Osoba(String imię, int wiek) {
        this.imię = imię;
        this.wiek = wiek;
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "id=" + id +
                ", imię='" + imię + '\'' +
                ", wiek=" + wiek +
                '}';
    }
}
