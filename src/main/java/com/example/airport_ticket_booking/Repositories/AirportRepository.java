package com.example.airport_ticket_booking.Repositories;

import com.example.airport_ticket_booking.Entities.Airport.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long> {
}
