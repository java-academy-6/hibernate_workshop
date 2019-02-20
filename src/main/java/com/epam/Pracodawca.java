package com.epam;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Pracodawca extends Osoba {
    Pracodawca(String imię, int wiek, int liczbaPracowników) {
        super(imię, wiek);
        this.liczbaPracowników = liczbaPracowników;
    }

    @Column
    int liczbaPracowników;

    @Override
    public String toString() {
        return super.toString() +
                "{" +
                "liczbaPracowników=" + liczbaPracowników +
                '}';
    }
}
