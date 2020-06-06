package br.com.kolibri.kolibri.airlines.route.domain;

import javax.persistence.*;
import java.util.Calendar;
import java.util.UUID;

@Entity
public class Route {

    @Id
    private final String uuid = UUID.randomUUID().toString();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "airline_uuid")
    private Airline airline;

    private Calendar departureTime;

    private Calendar arrivalTime;

    @Column(length = 4)
    private String originIcao;

    @Column(length = 4)
    private String destinationIcao;

    private int cargo;

    public String getUuid() {
        return uuid;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public Calendar getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Calendar departureTime) {
        this.departureTime = departureTime;
    }

    public Calendar getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Calendar arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getOriginIcao() {
        return originIcao;
    }

    public void setOriginIcao(String originIcao) {
        this.originIcao = originIcao;
    }

    public String getDestinationIcao() {
        return destinationIcao;
    }

    public void setDestinationIcao(String destinationIcao) {
        this.destinationIcao = destinationIcao;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }
}