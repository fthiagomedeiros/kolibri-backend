package br.com.kolibri.kolibri.airlines.route.service;

import br.com.kolibri.kolibri.airlines.route.domain.Airline;
import br.com.kolibri.kolibri.airlines.route.domain.Route;
import br.com.kolibri.kolibri.airlines.route.repository.AirlineRepository;
import br.com.kolibri.kolibri.airlines.route.repository.RouteRepository;
import br.com.kolibri.kolibri.airlines.route.request.RouteRequest;
import br.com.kolibri.kolibri.airlines.route.service.exceptions.AirlineNotFound;
import br.com.kolibri.kolibri.airlines.route.service.exceptions.AirlineRouteNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class AirlineRoutesImpl implements AirlineRoutes {

    private final RouteRepository routesRepo;
    private final AirlineRepository airlineRepo;

    @Autowired
    public AirlineRoutesImpl(RouteRepository routesRepo,
                             AirlineRepository airlineRepo) {
        this.routesRepo = routesRepo;
        this.airlineRepo = airlineRepo;
    }

    @Override
    public Route createRoute(String airlineId, RouteRequest request) throws AirlineNotFound, ParseException {
        Optional<Airline> airline = airlineRepo.findById(airlineId);
        if (airline.isPresent()) {
            Route route = createRoute(new Route(), request);
            route.setAirline(airline.get());
            routesRepo.save(route);
            return route;
        }
        throw new AirlineNotFound(String.format("There is no airline with id %s", airlineId));
    }

    @Override
    public List<Route> fetchRoutes(String uuid) {
        Optional<List<Route>> routes = routesRepo.findAllByAirlineUuid(uuid);
        return routes.orElseGet(ArrayList::new);
    }

    @Override
    public Route updateRoute(String airlineId, String routeId, RouteRequest request) throws AirlineRouteNotFound, ParseException {
        Optional<Route> value = routesRepo.findByUuid(routeId);
        if (value.isPresent()) {
            Route aRoute = value.get();

            if (airlineId.equalsIgnoreCase(aRoute.getAirline().getUuid())) {
                Route route = createRoute(value.get(), request);
                routesRepo.save(route);
                return route;
            }
        }
        throw new AirlineRouteNotFound(String.format("The route %s does not belong to airline %s", routeId, airlineId));
    }

    private Route createRoute(Route route, RouteRequest request) throws ParseException {
        Calendar departureTime = extractDate(request.getDepartureTime());
        Calendar arrivalTime = extractDate(request.getArrivalTime());
        route.setDepartureTime(departureTime);
        route.setArrivalTime(arrivalTime);
        route.setOriginIcao(request.getOriginIcao());
        route.setDestinationIcao(request.getDestinationIcao());
        route.setCargo(request.getCargo());
        route.setFlightId(request.getFlightId());
        return route;
    }

    public Calendar extractDate(String strDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = sdf.parse(strDate);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }
}
