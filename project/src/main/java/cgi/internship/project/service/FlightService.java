package cgi.internship.project.service;

import cgi.internship.project.entity.Flight;
import cgi.internship.project.mapper.FlightDtoMapper;
import cgi.internship.project.repository.FlightRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

    public ResponseEntity<?> getFlightDetails(long id){
        Flight flight = flightRepository.findById(id).orElse(null);
        if (flight == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(flightDtoMapper.fromFlightToDTO(flight));
    }
}
