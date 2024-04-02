package com.ontariotechu.sofe3980U;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class BookFlightsAPIController {

    @GetMapping("/Bookdirect-api")
    public String showBookDirectForm() {
        return "Please use POST method to book a direct flight.";
    }
    
    @PostMapping("/Bookdirect-api")
    public String Bookdirectapi(@RequestParam(name="FromAirport", required=true) String fromAirport,
                                @RequestParam(name="DestinationAirport", required=true) String destinationAirport,
                                @RequestParam(name="FullName", required=false, defaultValue="") String fullName) {
        
        // Generate a random booking ID
        String bookingId = UUID.randomUUID().toString();
        
        // Construct booking information
        String bookingInfo = "Booking ID: " + bookingId + "\n" +
                             "From Airport: " + fromAirport + "\n" +
                             "Destination Airport: " + destinationAirport + "\n";
                             
        if (!fullName.isEmpty()) {
            bookingInfo += "Full Name: " + fullName + "\n";
        }
        
        return "Direct flight booked successfully.\n" + bookingInfo;
        
        // Example usage: http://localhost:8080/Bookdirect-api?FromAirport=LAX&DestinationAirport=TorontoPearson&FullName=JaneDoe
    }
}
