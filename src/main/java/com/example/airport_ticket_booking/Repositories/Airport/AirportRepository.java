package com.example.airport_ticket_booking.Repositories.Airport;

import com.example.airport_ticket_booking.Entities.Airport.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AirportRepository extends JpaRepository<Airport, Long> {

}
