package br.com.kolibri.kolibri.airlines.route.domain;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Route {

    @Id
    private String uuid = UUID.randomUUID().toString();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "airline_uuid")
    private Airline airline;

    private int cargo;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }
}