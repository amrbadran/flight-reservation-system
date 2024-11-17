package com.example.airport_ticket_booking.Services.Passenger;

import com.example.airport_ticket_booking.Entities.Passenger.Passenger;
import com.example.airport_ticket_booking.Repositories.Passenger.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorizationService {

    @Autowired
    PassengerRepository passengerRepository;

    public boolean isPassengerAuthorizedToBooking(Long passengerId,String username){
        Optional<Passenger> passenger = passengerRepository.findPassengerByUsername(username);

        return passenger.isPresent() && passenger.get().getId().equals(passengerId);
    }

}
