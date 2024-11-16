package com.example.airport_ticket_booking.Controllers.Flight;


import com.example.airport_ticket_booking.DTO.Flight.FlightDTO;
import com.example.airport_ticket_booking.Services.Flight.FlightService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @Operation(summary = "List All Flights", description = "This endpoint list all flights in the system")
    @GetMapping("/")
    public ResponseEntity<List<FlightDTO>> getFlights() {
        List<FlightDTO> flights = flightService.getAllFlights();

        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    @Operation(summary = "List Flight By Id", description = "This endpoint list a flight in system by its id")
    @GetMapping("/{id}")
    public ResponseEntity<FlightDTO> getFlight(@PathVariable Long id) {
        FlightDTO flight = flightService.getFlightById(id);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }
}
