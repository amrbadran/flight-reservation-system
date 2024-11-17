package com.example.airport_ticket_booking.Services.Booking;

import com.example.airport_ticket_booking.DTO.Booking.BookingDTO;
import com.example.airport_ticket_booking.Entities.Booking.Booking;
import com.example.airport_ticket_booking.Entities.Passenger.Passenger;
import com.example.airport_ticket_booking.Exceptions.EntityNotFoundException;
import com.example.airport_ticket_booking.Repositories.Booking.BookingRepository;
import com.example.airport_ticket_booking.Repositories.Passenger.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private PassengerRepository passengerRepository;

    public List<BookingDTO> getAllBooking() {
        List<Booking> bookings = bookingRepository.findAll();

        return bookingsToDTOS(bookings);
    }

    public BookingDTO getBooking(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Booking is not found"));

        return new BookingDTO(booking.getFlight().getId(), booking.getPassenger().getId(), booking.getFlightClass());
    }


    public List<BookingDTO> getAllPassengerBooking(Long passengerId, String username) {
        Optional<Passenger> passenger = passengerRepository.findPassengerByUsername(username);

        if (!passenger.isPresent() || !passenger.get().getId().equals(passengerId)) {
            throw new AccessDeniedException("you can't access this resource");
        }

        List<Booking> bookings = bookingRepository.findBookingsByPassengerId(passengerId);

        return bookingsToDTOS(bookings);

    }

    public List<BookingDTO> bookingsToDTOS(List<Booking> bookings) {
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


}
