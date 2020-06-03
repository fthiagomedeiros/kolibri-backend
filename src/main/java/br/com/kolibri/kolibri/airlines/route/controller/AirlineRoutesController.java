package br.com.kolibri.kolibri.airlines.route.controller;

import br.com.kolibri.kolibri.airlines.route.domain.AirlineRoute;
import br.com.kolibri.kolibri.airlines.route.service.AirlineRoutes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/airline-routes")
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


    @GetMapping
    public ResponseEntity<Iterable<AirlineRoute>> getAirlineRoutes(
            @RequestParam(
                    value = "page",
                    required = false,
                    defaultValue = "0") int page,
            @RequestParam(
                    value = "size",
                    required = false,
                    defaultValue = "10") int size) {
        return new ResponseEntity<>(service.getAirlineRoutes(), HttpStatus.OK);
    }

}
