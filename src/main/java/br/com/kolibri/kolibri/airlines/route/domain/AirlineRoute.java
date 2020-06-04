package br.com.kolibri.kolibri.airlines.route.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public @Data
@NoArgsConstructor
class AirlineRoute {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Airport origin;

    @OneToOne
    private Airport destination;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime departureTime;

    private String company;

    private int cargo;

}