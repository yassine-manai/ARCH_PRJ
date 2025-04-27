package com.example.booking.booking_service;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import org.springframework.http.ResponseEntity;

import com.example.booking.booking_service.controller.BookingController;
import com.example.booking.booking_service.model.Booking;
import com.example.booking.booking_service.service.BookingService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class BookingServiceApplicationTests {

    @SuppressWarnings({ "null", "deprecation" })
	@Test
    void testCreateBooking() {
        BookingService bookingService = mock(BookingService.class);
        BookingController controller = new BookingController();

        Booking booking = new Booking("1", "A1", null, null);
        when(bookingService.createBooking(booking)).thenReturn(booking);

        ResponseEntity<Booking> response = controller.createBooking(booking);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("A1", response.getBody().getSeat());
    }
}
