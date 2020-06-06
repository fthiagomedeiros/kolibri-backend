package br.com.kolibri.kolibri.airports.repository;

import br.com.kolibri.kolibri.airports.domain.Airport;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportsRepository extends PagingAndSortingRepository<Airport, Long> {}
