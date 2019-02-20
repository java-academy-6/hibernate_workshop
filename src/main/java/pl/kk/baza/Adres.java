package pl.kk.baza;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Osoba")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Adres {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private String miasto;

    @Column
    private String ulica;

    @Column
    private int numer;

    public Adres(String miasto, String ulica, int numer) {
        this.miasto = miasto;
        this.ulica = ulica;
        this.numer = numer;
    }

    @Override
    public String toString() {
        return  miasto + " ul. " + ulica + ' ' + numer;
    }
}
