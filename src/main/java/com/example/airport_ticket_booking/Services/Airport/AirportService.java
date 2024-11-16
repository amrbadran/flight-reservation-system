package com.example.airport_ticket_booking.Services.Airport;


import com.example.airport_ticket_booking.DTO.Airport.AirportDTO;
import com.example.airport_ticket_booking.Entities.Airport.Airport;
import com.example.airport_ticket_booking.Exceptions.EntityNotFoundException;
import com.example.airport_ticket_booking.Repositories.Airport.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class AirportService {

    @Autowired
    private AirportRepository airportRepository;


    public List<AirportDTO> getAllAirPorts(){
        List<Airport> airports = airportRepository.findAll();
        List<AirportDTO> airportDTOS = new ArrayList<>();

        airports.forEach((airport -> {
            airportDTOS.add(new AirportDTO(airport.getName(),airport.getCountry()));
        }));

        return airportDTOS;
    }

    public AirportDTO getAirPortById(Long id){
        Airport airport = airportRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Airport is not found"));

        return new AirportDTO(airport.getName(),airport.getCountry());
    }

}
