package com.example.airport_ticket_booking.Entities.Passenger;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "passenger_gen")
    @SequenceGenerator(name = "passenger_gen", sequenceName = "passenger_seq", initialValue = 1000, allocationSize = 1)
    private Long id;

}
