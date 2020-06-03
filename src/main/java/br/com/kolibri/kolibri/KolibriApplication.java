package br.com.kolibri.kolibri;

import br.com.kolibri.kolibri.airlines.route.domain.AirlineRoute;
import br.com.kolibri.kolibri.airlines.route.domain.Airport;
import br.com.kolibri.kolibri.airlines.route.repository.AirlineRoutesRepository;
import br.com.kolibri.kolibri.airlines.route.repository.AirportsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class KolibriApplication {

    public static void main(String[] args) {
        SpringApplication.run(KolibriApplication.class, args);
    }

    @Bean
    public CommandLineRunner demoData(AirportsRepository airportRepo, AirlineRoutesRepository routeRepo) {
        return args -> {
            Airport a = new Airport();
            a.setIcao("SBKG");
            a.setCity("Campina Grande");
            a.setState("PB");
            airportRepo.save(a);

            Airport a2 = new Airport();
            a2.setIcao("SBGR");
            a2.setCity("Guarulhos");
            a2.setState("SP");
            airportRepo.save(a2);

            Airport a3 = new Airport();
            a3.setIcao("SBBR");
            a3.setCity("Brasilia");
            a3.setState("DF");
            airportRepo.save(a3);

            AirlineRoute route1 = new AirlineRoute();
            route1.setOrigin(a);
            route1.setDestination(a2);
            route1.setCompany("LATAM");
            route1.setCreatedAt(LocalDateTime.now());
            route1.setDepartureTime(LocalDateTime.of(2020, 6, 10, 22, 22, 0));
            route1.setAvailableWeight(1000);
            routeRepo.save(route1);

            AirlineRoute route2 = new AirlineRoute();
            route2.setOrigin(a3);
            route2.setDestination(a2);
            route2.setCompany("LATAM");
            route2.setCreatedAt(LocalDateTime.now());
            route2.setDepartureTime(LocalDateTime.of(2020, 7, 10, 22, 22, 0));
            route2.setAvailableWeight(500);
            routeRepo.save(route2);

        };
    }

}
