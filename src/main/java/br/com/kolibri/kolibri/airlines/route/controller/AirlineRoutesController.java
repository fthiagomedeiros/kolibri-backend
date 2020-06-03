package br.com.kolibri.kolibri.airlines.route.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

@RestController
@RequestMapping("/airline-routes")
public class AirlineRoutesController {

    @PostMapping
    public ResponseEntity<String> createRoute() {
        return new ResponseEntity<>("createRoute", HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<String> getAirlineRoutes(
            @RequestParam(
                    value = "page",
                    required = false,
                    defaultValue = "0") int page,
            @RequestParam(
                    value = "size",
                    required = false,
                    defaultValue = "10") int size) {
        return new ResponseEntity<>("getAirlineRoutes", HttpStatus.OK);
    }

}
