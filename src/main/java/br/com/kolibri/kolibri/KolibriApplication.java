package br.com.kolibri.kolibri;

import br.com.kolibri.kolibri.airlines.route.domain.Airport;
import br.com.kolibri.kolibri.airlines.route.repository.AirportRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KolibriApplication {

    public static void main(String[] args) {
        SpringApplication.run(KolibriApplication.class, args);
    }

    @Bean
    public CommandLineRunner demoData(AirportRepository repo) {
        return args -> {
            Airport a = new Airport();
            a.setIcao("SBKG");
            a.setCity("Campina Grande");
            a.setState("PB");
            repo.save(a);
        };
    }

}
