package pl.kk.baza;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
    String imię;

    @Fetch(FetchMode.JOIN)
    @OneToMany(fetch=FetchType.EAGER)
//    @OneToMany
    @JoinColumn(name = "Umowa")
    private Set<Umowa> umowas;


    public Osoba(String imie) {
        this.imię = imie;
    }


    @Override
    public String toString() {
        return "Osoba{" +
            "id=" + id +
            ", imię='" + imię + '\'' +
            ", umowas=" + umowas +
            '}';
    }
}

