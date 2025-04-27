package com.example.booking.booking_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.booking.booking_service.model.Booking;
import com.example.booking.booking_service.service.BookingService;

@RestController
@RequestMapping("/bookings")
@CrossOrigin(origins = "http://127.0.0.1:5500")  // Allow CORS for this controller
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public String book(@RequestBody Booking booking) {
        System.out.println("BookingController initialized");
        return bookingService.book(booking);
    }
}
