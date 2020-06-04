package br.com.kolibri.kolibri.airlines.route.service;

import br.com.kolibri.kolibri.airlines.route.domain.AirlineRoute;

import java.util.List;

public interface AirlineRoutes {
    List<AirlineRoute> getAirlineRoutes(String company);
}
