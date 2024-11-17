package com.example.airport_ticket_booking.Controllers.Passenger;

import com.example.airport_ticket_booking.DTO.Passenger.PassengerAuthDTO;
import com.example.airport_ticket_booking.DTO.Passenger.PassengerLoginResponseDTO;
import com.example.airport_ticket_booking.Entities.Passenger.Passenger;
import com.example.airport_ticket_booking.Security.JwtService;
import com.example.airport_ticket_booking.Services.Passenger.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    @Operation(summary = "Register new passenger", description = "This endpoint to add new passenger with username and password to the system")
    @PostMapping("/signup")
    public ResponseEntity<Passenger> register(@RequestBody PassengerAuthDTO registerUserDto) {
        Passenger registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @Operation(summary = "Login as passenger", description = "This endpoint to login as passenger with username,password and the result is jwt token")
    @PostMapping("/login")
    public ResponseEntity<PassengerLoginResponseDTO> authenticate(@RequestBody PassengerAuthDTO loginUserDto) {
        System.out.println(loginUserDto);
        Passenger authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        PassengerLoginResponseDTO loginResponse = new PassengerLoginResponseDTO(jwtToken);

        return ResponseEntity.ok(loginResponse);
    }
}
