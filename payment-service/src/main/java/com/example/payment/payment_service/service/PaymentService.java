package com.example.payment.payment_service.service;

import com.example.payment.payment_service.event.BookingRequestedEvent;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public boolean processPaymentFromBookingEvent(BookingRequestedEvent event) {
        // Simulate payment
        System.out.println("Processing payment for booking ID: " + event.getBookingId());
        return true;
    }

    public void sendEmailToUser(String userEmail, String bookingId) {
        // Simulate sending email
        System.out.println("Email sent to user: " + userEmail + " for booking ID: " + bookingId);
    }
}
