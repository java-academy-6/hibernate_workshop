package com.epam;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Pracownik extends Osoba {
    Pracownik(String imię, int wiek, int pensja) {
        super(imię, wiek);
        this.pensja = pensja;
    }

    @Column
    int pensja;

    @Override
    public String toString() {
        return super.toString() +
                "{" +
                "pensja=" + pensja +
                '}';
    }
}
