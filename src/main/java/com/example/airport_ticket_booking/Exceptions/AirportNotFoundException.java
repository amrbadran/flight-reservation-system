package com.example.airport_ticket_booking.Exceptions;

public class AirportNotFoundException extends RuntimeException{
    public AirportNotFoundException(String message){
        super(message);
    }
}
