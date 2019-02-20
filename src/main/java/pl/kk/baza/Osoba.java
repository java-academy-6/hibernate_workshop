package pl.kk.baza;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Osoba")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Osoba {

    @Id
    @GeneratedValue
    int id;
    @Column(name = "IMIE")
    String imie;

//    @OneToMany(fetch=FetchType.EAGER)
    @OneToMany
    @JoinColumn(name = "Umowa")
    private Set<Umowa> umowas;


    public Osoba(String imie) {
        this.imie = imie;
    }


    @Override
    public String toString() {
        return "Osoba{" +
            "id=" + id +
            ", imię='" + imie + '\'' +
            ", umowas=" + umowas +
            '}';
    }
}

