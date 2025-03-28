package cgi.internship.project.mapper;

import cgi.internship.project.entity.Flight;
import cgi.internship.project.model.FlightDTO;
import org.springframework.stereotype.Component;

@Component
public class FlightDtoMapper {

    public FlightDTO fromFlightToDTO(Flight flight) {
        return new FlightDTO(
                flight.getId(),
                flight.getDepartureTime(),
                flight.getArrivalTime(),
                flight.getDeparturePlace(),
                flight.getArrivalPlace(),
                flight.getSeats()
        );
    }

    public static Flight fromDtoToFlight(FlightDTO flightDTO) {
        return Flight.builder()
                .id(flightDTO.id())
                .departureTime(flightDTO.departureTime())
                .arrivalTime(flightDTO.arrivalTime())
                .departurePlace(flightDTO.departurePlace())
                .arrivalPlace(flightDTO.arrivalPlace())
                .seats(flightDTO.seats())
                .build();
    }
}
