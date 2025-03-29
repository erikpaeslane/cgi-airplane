package cgi.internship.project.entity;

import cgi.internship.project.utils.SeatsGenerator;
import cgi.internship.project.utils.SeatsMatrixConverter;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "flights")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder @ToString
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "departure_time")
    private LocalDateTime departureTime;
    @Column(name = "arrival_time")
    private LocalDateTime arrivalTime;
    @Column(name = "departure_place")
    private String departurePlace;
    @Column(name = "arrival_place")
    private String arrivalPlace;
    @Column(name = "seats", columnDefinition = "TEXT")
    @Convert(converter = SeatsMatrixConverter.class)
    private boolean[][] seats;

    public Flight(LocalDateTime departureTime, LocalDateTime arrivalTime, String departureAirport, String arrivalPlace) {
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.departurePlace = departureAirport;
        this.arrivalPlace = arrivalPlace;
        this.seats = SeatsGenerator.fillSeats(25, 4);
    }
}
