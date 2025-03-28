package cgi.internship.project.controller;

import cgi.internship.project.service.FlightService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/api/flights")
    public ResponseEntity<?> getAllFlights() {
        return flightService.getAllFlights();
    }
}
