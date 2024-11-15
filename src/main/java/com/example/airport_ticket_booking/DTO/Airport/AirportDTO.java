package com.example.airport_ticket_booking.DTO.Airport;
import jakarta.validation.constraints.NotEmpty;

public record AirportDTO(
    @NotEmpty(message = "airport name is required") String name,
    @NotEmpty(message = "airport country is required") String country
) {
}
