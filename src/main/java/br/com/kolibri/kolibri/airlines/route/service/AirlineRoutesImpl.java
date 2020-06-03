package br.com.kolibri.kolibri.airlines.route.service;

import br.com.kolibri.kolibri.airlines.route.domain.AirlineRoute;
import br.com.kolibri.kolibri.airlines.route.repository.AirlineRoutesRepository;
import org.springframework.stereotype.Service;

@Service
public class AirlineRoutesImpl implements AirlineRoutes {

    private AirlineRoutesRepository repository;

    public AirlineRoutesImpl(AirlineRoutesRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<AirlineRoute> getAirlineRoutes() {
        return repository.findAll();
    }
}
