package br.com.kolibri.kolibri.airlines.route.controller;

import br.com.kolibri.kolibri.airlines.route.domain.Route;
import br.com.kolibri.kolibri.airlines.route.service.AirlineRoutes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airlines")
public class AirlineRoutesController {

    private final AirlineRoutes service;

    @Autowired
    public AirlineRoutesController(AirlineRoutes service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> createRoute() {
        return new ResponseEntity<>("createRoute", HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/routes")
    public ResponseEntity<List<Route>> getAirlineRoutes(@PathVariable String id) {
        List<Route> routes = service.getAirlineRoutes(id);
        if (routes.size() == 0) {
            return new ResponseEntity<>(routes, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(routes, HttpStatus.OK);
    }

}