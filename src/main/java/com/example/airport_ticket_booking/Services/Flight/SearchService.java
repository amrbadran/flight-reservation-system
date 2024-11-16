package com.example.airport_ticket_booking.Services.Flight;

import com.example.airport_ticket_booking.DTO.Flight.FlightDTO;
import com.example.airport_ticket_booking.Entities.Flight.Flight;
import com.example.airport_ticket_booking.Entities.Flight.FlightClass;
import com.example.airport_ticket_booking.Repositories.Flight.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SearchService {

    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private FlightService flightService;

    public List<FlightDTO> searchFlightsByMinAndMaxPrice(FlightClass classType, Double minPrice, Double maxPrice) {
        List<Flight> flights = flightRepository.searchFlightByPrice(classType,minPrice,maxPrice);

        List<FlightDTO> flightDTOS = flightService.flightToDTOS(flights);

        return flightDTOS;
    }
}
