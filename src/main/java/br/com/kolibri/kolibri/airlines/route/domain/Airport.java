package br.com.kolibri.kolibri.airlines.route.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
public @Data
@NoArgsConstructor
class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 4, nullable = false, unique = true)
    private String icao;

    private String city;

    private String state;

    private String country = "BR";

    private double latitude;

    private double longitude;
}
