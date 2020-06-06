package br.com.kolibri.kolibri.airlines.route.controller;

import br.com.kolibri.kolibri.airlines.route.domain.Route;
import br.com.kolibri.kolibri.airlines.route.request.RouteRequest;
import br.com.kolibri.kolibri.airlines.route.service.AirlineRoutes;
import br.com.kolibri.kolibri.airlines.route.service.exceptions.AirlineNotFound;
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

    @PutMapping(value = "/{airlineId}/route/{routeId}")
    public ResponseEntity<String> updateRoute(@PathVariable String airlineId, @PathVariable String routeId) {
        return new ResponseEntity<>(String.format("Update Route %s for Airline %s", routeId, airlineId), HttpStatus.OK);
    }
}