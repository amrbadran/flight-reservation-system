package com.example.airport_ticket_booking.DTO.Booking;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookingDTO {

    @NotNull(message = "flight id can't be empty")
    private Long flightId;

    private Long passengerId;

    @NotNull(message = "flight class can't be empty")
    @Pattern(regexp = "Economy|Business|First", message = "flightClass must be one of: ECONOMY, BUSINESS, FIRST")
    private String flightClass;

    public BookingDTO(Long flightId, Long passengerId, String flightClass) {
        this.flightId = flightId;
        this.passengerId = passengerId;
        this.flightClass = flightClass;
    }
}
