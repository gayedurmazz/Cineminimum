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

    private String movieName;
    private Date visionDate;


}
