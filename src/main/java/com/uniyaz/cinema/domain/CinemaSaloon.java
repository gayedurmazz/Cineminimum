package com.uniyaz.cinema.domain;

import com.uniyaz.cinema.common.BaseDomain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CINEMA_SALOON")
public class CinemaSaloon extends BaseDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "SALOON_NAME", length = 50)
    private String saloonName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "SEANS")
    private Date seans;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CINEMA_CENTER", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "FK_CINEMA_SALOON_ID"))
    private CinemaCenter cinema;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSaloonName() {
        return saloonName;
    }

    public void setSaloonName(String saloonName) {
        this.saloonName = saloonName;
    }

    public Date getSeans() {
        return seans;
    }

    public void setSeans(Date seans) {
        this.seans = seans;
    }

    public CinemaCenter getCinema() {
        return cinema;
    }

    public void setCinema(CinemaCenter cinema) {
        this.cinema = cinema;
    }
}
