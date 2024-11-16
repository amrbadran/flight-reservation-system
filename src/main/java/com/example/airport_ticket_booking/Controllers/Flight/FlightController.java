package com.example.airport_ticket_booking.Controllers.Flight;


import com.example.airport_ticket_booking.DTO.Flight.FlightDTO;
import com.example.airport_ticket_booking.Entities.Flight.FlightClass;
import com.example.airport_ticket_booking.Exceptions.InvalidFlightClassException;
import com.example.airport_ticket_booking.Services.Flight.FlightService;
import com.example.airport_ticket_booking.Services.Flight.SearchService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController {
    @Autowired
    private FlightService flightService;
    @Autowired
    private SearchService flightSearchService;

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

    @Operation(summary = "Filter Flights By Price and Class", description = "This endpoint list a filtered flights in system by their prices and class types")
    @GetMapping("/search")
    public ResponseEntity<List<FlightDTO>> filterFlights(
            @RequestParam(name = "class", required = false) String classType,
            @RequestParam(name = "minPrice", required = false) Double minPrice,
            @RequestParam(name = "maxPrice", required = false) Double maxPrice
    ) {
        FlightClass flightClass;
        try {
            flightClass = FlightClass.valueOf(classType);
        } catch (IllegalArgumentException e) {
            throw new InvalidFlightClassException("Invalid class type: " + classType);
        } catch (NullPointerException e) {
            flightClass = null;
        }

        List<FlightDTO> flights = flightSearchService.searchFlightsByMinAndMaxPrice(flightClass, minPrice, maxPrice);

        return new ResponseEntity<>(flights, HttpStatus.OK);
    }
}
