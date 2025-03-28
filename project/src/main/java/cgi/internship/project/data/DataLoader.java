package cgi.internship.project.data;

import cgi.internship.project.entity.Flight;
import cgi.internship.project.repository.FlightRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataLoader {

    private final FlightRepository flightRepository;

    public DataLoader(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @PostConstruct
    public void init() {
        createFlights();
    }

    public void createFlights(){
        flightRepository.save(
                new Flight(LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(2),
                        "Tallinn", "Paris")
        );
        flightRepository.save(
                new Flight(LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(2),
                        "Tallinn", "Frankfurt")
        );
        flightRepository.save(
                new Flight(LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(2),
                        "Tallinn", "Helsinki")
        );
    }
}
