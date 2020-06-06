package br.com.kolibri.kolibri.airlines.route.controller;

import br.com.kolibri.kolibri.airlines.route.domain.Route;
import br.com.kolibri.kolibri.airlines.route.service.AirlineRoutes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<String> createRoute(@PathVariable String airlineId) {
        return new ResponseEntity<>(String.format("Create Route for Airline %s", airlineId), HttpStatus.OK);
    }

    @GetMapping(value = "/{airlineId}/routes")
    public ResponseEntity<List<Route>> getAirlineRoutes(@PathVariable String airlineId) {
        List<Route> routes = service.getAirlineRoutes(airlineId);
        if (routes.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(routes, HttpStatus.OK);
    }

    @PutMapping(value = "/{airlineId}/routes/{routeId}")
    public ResponseEntity<String> updateRoute(@PathVariable String airlineId, @PathVariable String routeId) {
        return new ResponseEntity<>(String.format("Update Route %s for Airline %s", routeId, airlineId), HttpStatus.OK);
    }
}