package com.example.notification.notification_service.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.notification.notification_service.event.BookingCancelledEvent;
import com.example.notification.notification_service.event.PaymentSuccessfulEvent;

@Service
public class NotificationService {

    @KafkaListener(topics = "payment-successful", groupId = "notification-group")
    public void handlePaymentSuccessfulEvent(PaymentSuccessfulEvent event) {
        System.out.println("Notification sent: " + event.getStatus());
        System.out.println("Notification sent: " + event.getBookingId());

    }

    @KafkaListener(topics = "booking-cancelled", groupId = "notification-group")
    public void handleBookingCancelledEvent(BookingCancelledEvent event) {
        System.out.println("Notification sent: " + event.getBookingId());
        System.out.println("Notification sent: " + event.getMovie());}
}
