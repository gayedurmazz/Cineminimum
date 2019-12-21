package com.uniyaz.cinema.domain;

import javax.persistence.*;

/// Many to many ilişkisini many to one olarak oluşturmak için.

@Entity
@Table(name = "MOVIE_SALOON")
public class MovieSaloon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "SALOON_ID", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "FK_MOVIE_SALOON"))
    private CinemaSaloon saloon;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MOVIE_ID", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "FK_SALOON_MOVIE"))
    private Movie movie;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CinemaSaloon getSaloon() {
        return saloon;
    }

    public void setSaloon(CinemaSaloon saloon) {
        this.saloon = saloon;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
