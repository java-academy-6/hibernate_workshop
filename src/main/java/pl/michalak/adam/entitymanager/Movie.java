package pl.michalak.adam.entitymanager;

import javax.persistence.*;

@Entity
@Table
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String movieName;

    @Column
    private Integer releaseYear;

    @Column
    private String language;

    Movie(String movieName, int releaseYear, String language){
        this.movieName = movieName;
        this.releaseYear = releaseYear;
        this.language = language;
    }

    public Movie() {
    }
}
