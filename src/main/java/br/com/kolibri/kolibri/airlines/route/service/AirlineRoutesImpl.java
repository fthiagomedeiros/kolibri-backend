package br.com.kolibri.kolibri.airlines.route.service;

import br.com.kolibri.kolibri.airlines.route.domain.AirlineRoute;
import br.com.kolibri.kolibri.airlines.route.repository.AirlineRoutesRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AirlineRoutesImpl implements AirlineRoutes {

    private final AirlineRoutesRepository repository;

    public AirlineRoutesImpl(AirlineRoutesRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AirlineRoute> getAirlineRoutes(String company) {
        Optional<List<AirlineRoute>> companies = repository.findAllByCompany(company);
        return companies.orElseGet(ArrayList::new);
    }
}
