package br.com.kolibri.kolibri.airlines.route.service;

import br.com.kolibri.kolibri.airlines.route.domain.AirlineRoute;

public interface AirlineRoutes {
    Iterable<AirlineRoute> getAirlineRoutes();
}
