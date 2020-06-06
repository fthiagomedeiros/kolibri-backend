package br.com.kolibri.kolibri.airlines.route.service;

import br.com.kolibri.kolibri.airlines.route.domain.Route;
import br.com.kolibri.kolibri.airlines.route.request.RouteRequest;
import br.com.kolibri.kolibri.airlines.route.service.exceptions.AirlineNotFound;

import java.text.ParseException;
import java.util.List;

public interface AirlineRoutes {
    Route createRoute(String airlineId, RouteRequest request) throws AirlineNotFound, ParseException;
    List<Route> getAirlineRoutes(String uuid);
    Route updateRoute(String airlineId, String routeId);

}
