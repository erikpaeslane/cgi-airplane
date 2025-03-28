package cgi.internship.project.service;

import cgi.internship.project.entity.Flight;
import cgi.internship.project.mapper.FlightDtoMapper;
import cgi.internship.project.repository.FlightRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FlightService {

    private final FlightRepository flightRepository;
    private final FlightDtoMapper flightDtoMapper;

    public FlightService(FlightRepository flightRepository, FlightDtoMapper flightDtoMapper) {
        this.flightRepository = flightRepository;
        this.flightDtoMapper = flightDtoMapper;
    }

    public ResponseEntity<?> getAllFlights() {
        return ResponseEntity.ok(
                flightRepository.findAll().stream().map(flightDtoMapper::fromFlightToDTO));
    }
}
