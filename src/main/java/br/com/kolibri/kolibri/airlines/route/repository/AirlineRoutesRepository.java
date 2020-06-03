package br.com.kolibri.kolibri.airlines.route.repository;

import br.com.kolibri.kolibri.airlines.route.domain.AirlineRoute;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRoutesRepository extends PagingAndSortingRepository<AirlineRoute, Long> {}
