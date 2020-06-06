package br.com.kolibri.kolibri.airlines.route.service;

import br.com.kolibri.kolibri.airlines.route.domain.Airline;
import br.com.kolibri.kolibri.airlines.route.domain.Route;
import br.com.kolibri.kolibri.airlines.route.repository.AirlineRepository;
import br.com.kolibri.kolibri.airlines.route.repository.RouteRepository;
import br.com.kolibri.kolibri.airlines.route.request.RouteRequest;
import br.com.kolibri.kolibri.airlines.route.service.exceptions.AirlineNotFound;
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

            Route route = new Route();
            Calendar departureTime = extractDate(request.getDepartureTime());
            Calendar arrivalTime = extractDate(request.getArrivalTime());
            route.setDepartureTime(departureTime);
            route.setArrivalTime(arrivalTime);
            route.setOriginIcao(request.getOriginIcao());
            route.setDestinationIcao(request.getDestinationIcao());
            route.setCargo(request.getCargo());
            route.setAirline(airline.get());
            route.setFlightId(request.getFlightId());
            routesRepo.save(route);

            return route;
        }
        throw new AirlineNotFound(String.format("There is no airline with id %s", airlineId));
    }

    public Calendar extractDate(String strDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date date = sdf.parse(strDate);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    @Override
    public List<Route> getAirlineRoutes(String uuid) {
        Optional<List<Route>> routes = routesRepo.findAllByAirlineUuid(uuid);
        return routes.orElseGet(ArrayList::new);
    }
}
