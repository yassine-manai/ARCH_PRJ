package com.example.payment.payment_service.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.payment.payment_service.event.PaymentSuccessfulEvent;

@Service
public class PaymentNotificationConsumer {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    private static final String NOTIFICATION_TOPIC = "payment.notifications";

    // This listener consumes messages only from the payment.successful topic
    @KafkaListener(topics = "payment.successful", groupId = "notification-group")
    public void consumePaymentSuccessEvent(PaymentSuccessfulEvent event) {
        System.out.println("Received payment successful event: " + event.getBookingId());
        
        // Handle the event (e.g., sending an email, etc.)
        sendNotification(event);
    }

    private void sendNotification(PaymentSuccessfulEvent event) {
        // Simulate sending a notification (email, SMS, etc.)
        System.out.println("Sending payment notification to user: " + event.getBookingId());
    }
}
