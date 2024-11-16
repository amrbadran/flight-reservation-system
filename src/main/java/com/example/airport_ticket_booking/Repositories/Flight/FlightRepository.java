package com.example.airport_ticket_booking.Repositories.Flight;

import com.example.airport_ticket_booking.Entities.Flight.Flight;
import com.example.airport_ticket_booking.Entities.Flight.FlightClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query("""
                SELECT f FROM Flight f
                JOIN f.price p
                WHERE (:classType IS NULL OR :classType = key(p))
                AND (:minPrice IS NULL OR :minPrice <= value(p))
                AND (:maxPrice IS NULL OR :maxPrice >= value(p))
            """)
    List<Flight> searchFlightByPrice(@Param("classType") FlightClass classType,
                                     @Param("minPrice") Double minPrice,
                                     @Param("maxPrice") Double maxPrice);

}