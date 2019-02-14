package pl.kk;

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
class Osoba {

    @Id
    @GeneratedValue
    int id;
    @Column(name = "IMIE")
    String imię;

    Osoba(String imię) {
        this.imię = imię;
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "id=" + id +
                ", imię='" + imię + '\'' +
                '}';
    }
}

