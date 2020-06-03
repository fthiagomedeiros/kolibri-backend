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

    @OneToOne(fetch = FetchType.LAZY)
    private Airport origin;

    @OneToOne(fetch = FetchType.LAZY)
    private Airport destionation;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

}