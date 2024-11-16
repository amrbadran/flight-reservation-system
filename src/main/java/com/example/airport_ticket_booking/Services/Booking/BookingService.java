package com.example.airport_ticket_booking.Services.Booking;

import com.example.airport_ticket_booking.DTO.Booking.BookingDTO;
import com.example.airport_ticket_booking.Entities.Booking.Booking;
import com.example.airport_ticket_booking.Exceptions.EntityNotFoundException;
import com.example.airport_ticket_booking.Repositories.Booking.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<BookingDTO> getAllBooking() {
        List<Booking> bookings = bookingRepository.findAll();
        List<BookingDTO> bookingDTOS = new ArrayList<>();
        bookings.forEach(b -> {
            bookingDTOS.add(
                    new BookingDTO(b.getFlight().getId(),
                            b.getPassenger().getId(),
                            b.getFlightClass())
            );
        });

        return bookingDTOS;
    }

    public BookingDTO getBooking(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Booking is not found"));

        return new BookingDTO(booking.getFlight().getId(),booking.getPassenger().getId(),booking.getFlightClass());
    }
}
