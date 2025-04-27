package com.example.booking.booking_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookingServiceApplication {

	public static void main(String[] args) {
		System.out.println("Booking Service Application is starting on 6010 PORT...");
		SpringApplication.run(BookingServiceApplication.class, args);
		
	}

}
