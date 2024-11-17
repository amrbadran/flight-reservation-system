package com.example.airport_ticket_booking.Services.Booking;

import com.example.airport_ticket_booking.DTO.Booking.BookingDTO;
import com.example.airport_ticket_booking.Entities.Booking.Booking;
import com.example.airport_ticket_booking.Entities.Flight.Flight;
import com.example.airport_ticket_booking.Entities.Passenger.Passenger;
import com.example.airport_ticket_booking.Exceptions.EntityNotFoundException;
import com.example.airport_ticket_booking.Repositories.Booking.BookingRepository;
import com.example.airport_ticket_booking.Repositories.Flight.FlightRepository;
import com.example.airport_ticket_booking.Repositories.Passenger.PassengerRepository;
import com.example.airport_ticket_booking.Services.Passenger.AuthorizationService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final FlightRepository flightRepository;
    private final PassengerRepository passengerRepository;
    private final AuthorizationService authorizationService;


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
        if (!authorizationService.isPassengerAuthorizedToBooking(passengerId, username)) {
            throw new AccessDeniedException("You can't Access this resource");
        }

        List<Booking> bookings = bookingRepository.findBookingsByPassengerId(passengerId);

        return bookingsToDTOS(bookings);

    }

    @Transactional
    public void deleteBookingById(Long bookingId) {
        if (!bookingRepository.existsById(bookingId)) {
            throw new EntityNotFoundException("Booking with id " + bookingId + " not found");
        }
        bookingRepository.deleteBookingsById(bookingId);
    }

    public BookingDTO addBooking(BookingDTO bookingDTO) {
        Flight flight = flightRepository.getFlightById(bookingDTO.getFlightId());
        Passenger passenger = passengerRepository.getPassengerById(bookingDTO.getPassengerId());

        if (flight == null || passenger == null) {
            throw new EntityNotFoundException("Flight Id or Passenger Id isn't Valid");
        }

        Booking booking = new Booking();
        booking.setPassenger(passenger);
        booking.setFlight(flight);
        booking.setFlightClass(bookingDTO.getFlightClass());

        bookingRepository.save(booking);

        return bookingDTO;
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
