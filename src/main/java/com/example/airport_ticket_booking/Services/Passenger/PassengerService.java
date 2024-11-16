package com.example.airport_ticket_booking.Services.Passenger;

import com.example.airport_ticket_booking.DTO.Passenger.PassengerDTO;
import com.example.airport_ticket_booking.Entities.Passenger.Passenger;
import com.example.airport_ticket_booking.Exceptions.EntityNotFoundException;
import com.example.airport_ticket_booking.Repositories.Passenger.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    public List<PassengerDTO> getAllPassengers() {
        List<Passenger> passengers = passengerRepository.findAll();
        List<PassengerDTO> passengerDTOS = new ArrayList<>();

        passengers.forEach(p -> {
            passengerDTOS.add(new PassengerDTO(p.getUsername()));
        });

        return passengerDTOS;
    }

    public PassengerDTO getPassengerById(Long id) {
        Passenger passenger = passengerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Passenger is not found"));

        return new PassengerDTO(passenger.getUsername());
    }
}
