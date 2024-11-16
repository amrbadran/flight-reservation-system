package com.example.airport_ticket_booking.DTO.Flight;

import com.example.airport_ticket_booking.Entities.Flight.FlightClass;
import jakarta.validation.constraints.NotEmpty;

import java.util.Date;
import java.util.Map;

public record FlightDTO(
       @NotEmpty(message = "arrival airport id can't be empty") Long arrivalAirportId,
       @NotEmpty(message = "departure airport id can't be empty")  Long departureAirportId,
       @NotEmpty(message = "departure date can't be empty") Date departureDate,
        Map<FlightClass, Double> price
) {
}
