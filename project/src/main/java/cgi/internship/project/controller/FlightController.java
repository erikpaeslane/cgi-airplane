package cgi.internship.project.controller;

import cgi.internship.project.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightController {

    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/api/flights")
    public ResponseEntity<?> getAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/api/flights/{id}")
    public ResponseEntity<?> getFlightDetails(@PathVariable long id){
        return flightService.getFlightDetails(id);
    }
}
