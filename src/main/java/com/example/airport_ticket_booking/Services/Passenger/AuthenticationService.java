package com.example.airport_ticket_booking.Services.Passenger;

import com.example.airport_ticket_booking.DTO.Passenger.PassengerAuthDTO;
import com.example.airport_ticket_booking.Entities.Passenger.Passenger;
import com.example.airport_ticket_booking.Exceptions.PassengerExistsException;
import com.example.airport_ticket_booking.Repositories.Passenger.PassengerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final PassengerRepository passengerRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;


    public Passenger signup(PassengerAuthDTO input) {
        passengerRepository.findPassengerByUsername(input.username())
                .ifPresent(passenger -> {
                    throw new PassengerExistsException("Passenger with this username already exists");
                });
        Passenger user = new Passenger();
        user.setUsername(input.username());
        user.setPassword(passwordEncoder.encode(input.password()));
        return passengerRepository.save(user);
    }

    public Passenger authenticate(PassengerAuthDTO input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(input.username(), input.password())
        );

        return passengerRepository.findPassengerByUsername(input.username())
                .orElseThrow();
    }
}
