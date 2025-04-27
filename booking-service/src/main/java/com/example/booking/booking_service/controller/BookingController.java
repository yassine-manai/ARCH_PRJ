package com.example.booking.booking_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.booking.booking_service.model.Booking;
import com.example.booking.booking_service.service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {


    @Autowired
    private BookingService bookingService;

    @PostMapping
    public String book(@RequestBody Booking booking) {
        System.out.println("BookingController initialized");

        return bookingService.book(booking);
    }

    public ResponseEntity<Booking> createBooking(Booking booking) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createBooking'");
    }
}
