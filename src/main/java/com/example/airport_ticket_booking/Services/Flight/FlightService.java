package com.example.airport_ticket_booking.Services.Flight;

import com.example.airport_ticket_booking.DTO.Flight.FlightDTO;
import com.example.airport_ticket_booking.Entities.Flight.Flight;
import com.example.airport_ticket_booking.Exceptions.EntityNotFoundException;
import com.example.airport_ticket_booking.Repositories.Flight.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<FlightDTO> getAllFlights() {
        List<Flight> flights = flightRepository.findAll();
        List<FlightDTO> flightDTOS = new ArrayList<>();

        flights.forEach((f -> {
            flightDTOS.add(
                    new FlightDTO(f.getArrivalAirport().getId(),
                    f.getDepartureAirport().getId(),
                    f.getDepartureDate(),
                    f.getPrice()));
        }));

        return flightDTOS;
    }

    public FlightDTO getFlightById(Long id) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Flight is not found"));

        return new FlightDTO(flight.getArrivalAirport().getId(),
                flight.getDepartureAirport().getId(),
                flight.getDepartureDate(),
                flight.getPrice());
    }
}
