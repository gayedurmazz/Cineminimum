package com.uniyaz.cinema.domain;

import com.uniyaz.cinema.common.BaseDomain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MOVIE")
public class Movie extends BaseDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "MOVIE_NAME")
    private String movieName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "VISION_DATE")
    private Date visionDate;

    @Override
    public String toString() {
        return String.valueOf(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Date getVisionDate() {
        return visionDate;
    }

    public void setVisionDate(Date visionDate) {
        this.visionDate = visionDate;
    }
}
