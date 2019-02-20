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
@Table(name = "Umowa")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Umowa {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private String nazwa;

//    @Fetch(FetchMode.JOIN)
//    @OneToMany(fetch=FetchType.LAZY)
    @OneToMany
    @JoinColumn(name = "Adres")
    private Set<Adres> adresy;

    public Umowa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return nazwa;
    }
}
