package br.com.kolibri.kolibri.airlines.route.repository;

import br.com.kolibri.kolibri.airlines.route.domain.Route;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RouteRepository extends CrudRepository<Route, String> {
    Optional<List<Route>> findAllByAirlineUuid(String uuid);
}
