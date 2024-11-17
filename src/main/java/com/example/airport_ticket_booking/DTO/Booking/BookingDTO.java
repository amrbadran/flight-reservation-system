package com.example.airport_ticket_booking.DTO.Booking;

import com.example.airport_ticket_booking.Entities.Flight.FlightClass;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookingDTO {

    @NotNull(message = "flight id can't be empty")
    private Long flightId;

    @NotNull(message = "passenger id can't be empty")
    private Long passengerId;

    @NotNull(message = "flight class can't be empty")
    private FlightClass flightClass;

    public BookingDTO(Long flightId, Long passengerId, FlightClass flightClass) {
        this.flightId = flightId;
        this.passengerId = passengerId;
        this.flightClass = flightClass;
    }
}
