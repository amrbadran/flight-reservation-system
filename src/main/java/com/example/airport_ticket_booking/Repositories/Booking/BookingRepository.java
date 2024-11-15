package com.example.airport_ticket_booking.Repositories.Booking;

import com.example.airport_ticket_booking.Entities.Booking.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {
}
