package com.example.airport_ticket_booking.Exceptions;

public class InvalidFlightClassException extends RuntimeException{
    public InvalidFlightClassException(String message){
        super(message);
    }
}
