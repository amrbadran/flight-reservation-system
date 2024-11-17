package com.example.airport_ticket_booking.Controllers.Passenger;

import com.example.airport_ticket_booking.DTO.Booking.BookingDTO;
import com.example.airport_ticket_booking.DTO.Passenger.PassengerDTO;
import com.example.airport_ticket_booking.Security.JwtService;
import com.example.airport_ticket_booking.Services.Booking.BookingService;
import com.example.airport_ticket_booking.Services.Passenger.AuthorizationService;
import com.example.airport_ticket_booking.Services.Passenger.PassengerService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passenger")
@RequiredArgsConstructor
public class PassengerController {

    private final PassengerService passengerService;
    private final JwtService jwtService;
    private final BookingService bookingService;
    private final AuthorizationService authorizationService;

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

    @Operation(summary = "List Bookings for Passenger", description = "This endpoint list all bookings booked by some passenger in system by its id")
    @GetMapping("/{pid}/bookings")
    public ResponseEntity<List<BookingDTO>> listPassengerBookings(@PathVariable Long pid,
                                                                  @RequestHeader("Authorization") String authorizationHeader) {
        String username = jwtService.extractUsernameFromHeader(authorizationHeader);

        List<BookingDTO> bookings = bookingService.getAllPassengerBooking(pid, username);

        return new ResponseEntity<>(bookings, HttpStatus.OK);

    }

    @DeleteMapping("/{pid}/booking/{bid}")
    public ResponseEntity<String> DeletePassengerBooking(@PathVariable Long pid, @PathVariable Long bid
            , @RequestHeader("Authorization") String authorizationHeader) {

        String username = jwtService.extractUsernameFromHeader(authorizationHeader);
        if (authorizationService.isPassengerAuthorizedToBooking(pid, username)) {
            bookingService.deleteBookingById(bid);
            return new ResponseEntity<>("Booking With Id " + bid + " is Deleted", HttpStatus.OK);
        }

        throw new AccessDeniedException("You can't Access this resource");
    }


}
