package com.example.airport_ticket_booking.Entities.Flight;

import com.example.airport_ticket_booking.Entities.Airport.Airport;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Map;

@Entity
@Getter
@Setter
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flight_gen")
    @SequenceGenerator(name = "flight_gen", sequenceName = "flight_seq", initialValue = 3000, allocationSize = 1)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date departureDate;


    @ManyToOne
    @JoinColumn(name = "departure_airport_id")
    private Airport departureAirport;

    @ManyToOne
    @JoinColumn(name = "arrival_airport_id")
    private Airport arrivalAirport;

    @ElementCollection
    @CollectionTable(
            name = "price_class",
            joinColumns = @JoinColumn(name = "flight_id")
    )
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "class")
    @Column(name = "price")
    private Map<FlightClass, Double> price;

}
