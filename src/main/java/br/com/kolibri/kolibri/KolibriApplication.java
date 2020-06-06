package br.com.kolibri.kolibri;

import br.com.kolibri.kolibri.airlines.route.domain.Airline;
import br.com.kolibri.kolibri.airlines.route.domain.Route;
import br.com.kolibri.kolibri.airlines.route.repository.AirlineRepository;
import br.com.kolibri.kolibri.airlines.route.repository.RouteRepository;
import br.com.kolibri.kolibri.airports.domain.Airport;
import br.com.kolibri.kolibri.airports.repository.AirportsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Calendar;
import java.util.GregorianCalendar;

@SpringBootApplication
public class KolibriApplication {

    public static void main(String[] args) {
        SpringApplication.run(KolibriApplication.class, args);
    }

    @Bean
    public CommandLineRunner populate(AirlineRepository airlineRepository,
                                      RouteRepository routeRepository,
                                      AirportsRepository airportsRepository) {
        return args -> {

            //Populating database with mocked data
            Airline airline1 = new Airline();
            airline1.setName("LATAM");
            airline1.setUuid("50000");
            airlineRepository.save(airline1);

            Airline airline2 = new Airline();
            airline2.setName("GOL");
            airline2.setUuid("60000");
            airlineRepository.save(airline2);

            Route r1 = new Route();
            r1.setCargo(150);
            r1.setDepartureTime(new GregorianCalendar(2020, Calendar.JULY, 15, 22, 0));
            r1.setArrivalTime(new GregorianCalendar(2020, Calendar.JULY, 16, 1, 0));
            r1.setAirline(airline1);
            r1.setDestinationIcao("SBGR");
            r1.setOriginIcao("SBKG");
            routeRepository.save(r1);

            Route r2 = new Route();
            r2.setCargo(1550);
            r2.setDepartureTime(new GregorianCalendar(2020, Calendar.JULY, 15, 22, 0));
            r2.setArrivalTime(new GregorianCalendar(2020, Calendar.JULY, 16, 1, 0));
            r2.setAirline(airline2);
            r2.setDestinationIcao("SBGR");
            r2.setOriginIcao("SBRF");
            routeRepository.save(r2);

            Route r3 = new Route();
            r3.setCargo(100);
            r3.setDepartureTime(new GregorianCalendar(2020, Calendar.JULY, 15, 22, 0));
            r3.setArrivalTime(new GregorianCalendar(2020, Calendar.JULY, 16, 1, 0));
            r3.setAirline(airline2);
            r3.setDestinationIcao("SBKG");
            r3.setOriginIcao("SBGR");
            routeRepository.save(r3);

            //Populate airports
            Airport a1 = new Airport();
            a1.setCity("Campina Grande");
            a1.setCountry("Brasil");
            a1.setIcao("SBKG");
            a1.setLatitude(10);
            a1.setLongitude(15);
            a1.setState("PB");
            airportsRepository.save(a1);

            Airport a2 = new Airport();
            a2.setCity("Recife");
            a2.setCountry("Brasil");
            a2.setIcao("SBRF");
            a2.setLatitude(11);
            a2.setLongitude(16);
            a2.setState("PE");
            airportsRepository.save(a2);

            Airport a3 = new Airport();
            a3.setCity("Guarulhos");
            a3.setCountry("Brasil");
            a3.setIcao("SBGR");
            a3.setLatitude(15);
            a3.setLongitude(22);
            a3.setState("SP");
            airportsRepository.save(a3);

        };
    }

}
