package com.example.airport_ticket_booking.Repositories.Passenger;

import com.example.airport_ticket_booking.Entities.Passenger.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger,Long> {
}
