package com.example.booking.booking_service.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.booking.booking_service.event.BookingRequestedEvent;
import com.example.booking.booking_service.model.Booking;

@Service
public class BookingService {

    @Autowired
    private KafkaTemplate<String, BookingRequestedEvent> kafkaTemplate;

    private final String TOPIC = "booking.requested";

    public String book(Booking book_param) {
        System.out.println("Booking request received: " + book_param.toString());
        String bookingId = UUID.randomUUID().toString();
        book_param.setBookingId(bookingId);
        
        BookingRequestedEvent event = new BookingRequestedEvent();
        event.setBookingId(bookingId);
        event.setMovie(book_param.getMovie());
        event.setSeat(book_param.getSeat());
        event.setUserEmail(book_param.getUserEmail());

        kafkaTemplate.send(TOPIC, event);
        return "Booking requested with ID: " + bookingId;
    }

    public Object createBooking(Booking booking) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createBooking'");
    }
}
