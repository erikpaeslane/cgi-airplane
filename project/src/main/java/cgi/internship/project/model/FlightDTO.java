package cgi.internship.project.model;

import java.time.LocalDateTime;

public record FlightDTO(
        long id,
        LocalDateTime departureTime,
        LocalDateTime arrivalTime,
        String departurePlace,
        String arrivalPlace,
        boolean[][] seats
) {}
