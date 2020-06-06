package br.com.kolibri.kolibri.airlines.route.service;

import br.com.kolibri.kolibri.airlines.route.domain.Route;

import java.util.List;

public interface AirlineRoutes {
    List<Route> getAirlineRoutes(String uuid);
}
