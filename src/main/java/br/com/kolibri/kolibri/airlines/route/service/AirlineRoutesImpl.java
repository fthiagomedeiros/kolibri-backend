package br.com.kolibri.kolibri.airlines.route.service;

import br.com.kolibri.kolibri.airlines.route.domain.Route;
import br.com.kolibri.kolibri.airlines.route.repository.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AirlineRoutesImpl implements AirlineRoutes {

    private final RouteRepository repository;

    public AirlineRoutesImpl(RouteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Route> getAirlineRoutes(String uuid) {
        Optional<List<Route>> routes = repository.findAllByAirlineUuid(uuid);
        return routes.orElseGet(ArrayList::new);
    }
}
