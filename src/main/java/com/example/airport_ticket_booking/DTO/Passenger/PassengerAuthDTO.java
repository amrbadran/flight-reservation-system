package com.example.airport_ticket_booking.DTO.Passenger;

import jakarta.validation.constraints.NotEmpty;

public record PassengerAuthDTO(
        @NotEmpty(message = " Username can't be empty")  String username,
        @NotEmpty(message = " Password can't be empty")  String password
) {
}
