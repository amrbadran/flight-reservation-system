package com.example.airport_ticket_booking.Repositories.Flight;

import com.example.airport_ticket_booking.Entities.Flight.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}