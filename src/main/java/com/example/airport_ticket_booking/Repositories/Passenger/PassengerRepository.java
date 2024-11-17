package com.example.airport_ticket_booking.Repositories.Passenger;

import com.example.airport_ticket_booking.Entities.Passenger.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PassengerRepository extends JpaRepository<Passenger,Long> {

    Optional<Passenger> findPassengerByUsername(String username);

    Passenger getPassengerById(Long id);
}
