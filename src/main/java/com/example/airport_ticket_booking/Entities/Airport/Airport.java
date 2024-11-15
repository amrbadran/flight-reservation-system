package com.example.airport_ticket_booking.Entities.Airport;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "airport_gen")
    @SequenceGenerator(name = "airport_gen", sequenceName = "airport_seq", initialValue = 2000, allocationSize = 1)
    private Long id;
    private String name;
    private String country;
}
