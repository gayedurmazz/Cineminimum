package com.uniyaz.cinema.domain;

import com.uniyaz.cinema.common.BaseDomain;

import javax.persistence.*;

@Entity
@Table(name = "CINEMA_CENTER")
public class CinemaCenter extends BaseDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "CINEMA_NAME", length = 100)
    private String cinemaName;



}
