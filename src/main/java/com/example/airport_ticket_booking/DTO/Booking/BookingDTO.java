package com.example.airport_ticket_booking.DTO.Booking;

import com.example.airport_ticket_booking.Entities.Flight.FlightClass;
import jakarta.validation.constraints.NotEmpty;

public record BookingDTO(
        @NotEmpty(message = "flight id can't be empty") Long FlightId,
        @NotEmpty(message = "passenger id can't be empty") Long PassengerId,
        @NotEmpty(message = "flight class can't be empty") FlightClass flightClass
) {
}
