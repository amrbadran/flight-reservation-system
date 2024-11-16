package com.example.airport_ticket_booking.Controllers.Passenger;

import com.example.airport_ticket_booking.DTO.Passenger.PassengerDTO;
import com.example.airport_ticket_booking.Services.Passenger.PassengerService;
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
@RequestMapping("/passenger")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @Operation(summary = "List All Passengers", description = "This endpoint list all passengers in the system")
    @GetMapping("/")
    public ResponseEntity<List<PassengerDTO>> getPassengers() {
        List<PassengerDTO> passengers = passengerService.getAllPassengers();

        return new ResponseEntity<>(passengers, HttpStatus.OK);
    }

    @Operation(summary = "List Passenger By Id", description = "This endpoint list a passenger in system by its id")
    @GetMapping("/{id}")
    public ResponseEntity<PassengerDTO> getPassenger(@PathVariable Long id) {
        PassengerDTO passenger = passengerService.getPassengerById(id);
        return new ResponseEntity<>(passenger, HttpStatus.OK);
    }
}
