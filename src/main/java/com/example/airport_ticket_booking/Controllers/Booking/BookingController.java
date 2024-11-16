package com.example.airport_ticket_booking.Controllers.Booking;

import com.example.airport_ticket_booking.DTO.Booking.BookingDTO;
import com.example.airport_ticket_booking.Services.Booking.BookingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Operation(summary = "List All Bookings", description = "This endpoint list all bookings in the system")
    @GetMapping("/")
    public ResponseEntity<List<BookingDTO>> getBookings() {
        List<BookingDTO> bookings = bookingService.getAllBooking();

        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @Operation(summary = "List Booking By Id", description = "This endpoint list a booking in system by its id")
    @GetMapping("/{id}")
    public ResponseEntity<BookingDTO> getBooking(@PathVariable Long id) {
        BookingDTO booking = bookingService.getBooking(id);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }
}
