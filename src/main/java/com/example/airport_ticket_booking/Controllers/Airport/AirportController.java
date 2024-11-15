package com.example.airport_ticket_booking.Controllers.Airport;

import com.example.airport_ticket_booking.DTO.Airport.AirportDTO;
import com.example.airport_ticket_booking.Entities.Airport.Airport;
import com.example.airport_ticket_booking.Services.Airport.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/airport")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @GetMapping("/")
    public ResponseEntity<List<AirportDTO>> getAirPorts() {
        List<AirportDTO> airports = airportService.getAllAirPorts();
        return new ResponseEntity<>(airports, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AirportDTO> getAirPort(@PathVariable Long id) {
        AirportDTO airport = airportService.getAirPortById(id);
        return new ResponseEntity<>(airport, HttpStatus.OK);
    }
}
