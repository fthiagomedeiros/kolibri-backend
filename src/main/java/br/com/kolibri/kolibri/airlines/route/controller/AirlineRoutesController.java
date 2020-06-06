package br.com.kolibri.kolibri.airlines.route.controller;

import br.com.kolibri.kolibri.airlines.route.domain.Route;
import br.com.kolibri.kolibri.airlines.route.request.RouteRequest;
import br.com.kolibri.kolibri.airlines.route.service.AirlineRoutes;
import br.com.kolibri.kolibri.airlines.route.service.exceptions.AirlineNotFound;
import br.com.kolibri.kolibri.airlines.route.service.exceptions.AirlineRouteNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/airline")
public class AirlineRoutesController {

    private final AirlineRoutes service;

    @Autowired
    public AirlineRoutesController(AirlineRoutes service) {
        this.service = service;
    }

    @PostMapping(value = "/{airlineId}/routes")
    public ResponseEntity<Route> createRoute(@PathVariable String airlineId,
                                             @RequestBody RouteRequest request) {
        try {
            Route newCreatedRoute = service.createRoute(airlineId, request);
            return new ResponseEntity<>(newCreatedRoute, HttpStatus.OK);
        } catch (AirlineNotFound exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (ParseException exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/{airlineId}/routes")
    public ResponseEntity<List<Route>> fetchRoutesBy(@PathVariable String airlineId) {
        List<Route> routes = service.getAirlineRoutes(airlineId);
        if (routes.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(routes, HttpStatus.OK);
    }

    @PutMapping(value = "/{airlineId}/routes/{routeId}")
    public ResponseEntity<Route> updateRoute(@PathVariable String airlineId,
                                             @PathVariable String routeId,
                                             @RequestBody RouteRequest request) {
        try {
            Route newUpdated = service.updateRoute(airlineId, routeId, request);
            return new ResponseEntity<>(newUpdated, HttpStatus.OK);
        } catch (AirlineRouteNotFound | ParseException airlineRouteNotFound) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}