package com.example.airport_ticket_booking.Entities.Booking;

import com.example.airport_ticket_booking.Entities.Flight.Flight;
import com.example.airport_ticket_booking.Entities.Flight.FlightClass;
import com.example.airport_ticket_booking.Entities.Passenger.Passenger;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_gen")
    @SequenceGenerator(name = "booking_gen", sequenceName = "booking_seq", initialValue = 4000, allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight;

    @ManyToOne
    @JoinColumn(name = "passenger_id", nullable = false)
    private Passenger passenger;

    @Enumerated(EnumType.STRING)
    private FlightClass flightClass;

}
