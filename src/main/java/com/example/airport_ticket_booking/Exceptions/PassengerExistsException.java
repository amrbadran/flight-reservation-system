package com.example.airport_ticket_booking.Exceptions;

public class PassengerExistsException extends RuntimeException{
    public PassengerExistsException(String message){
        super(message);
    }
}
