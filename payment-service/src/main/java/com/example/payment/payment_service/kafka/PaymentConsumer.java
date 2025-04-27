package com.example.payment.payment_service.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.payment.payment_service.event.BookingRequestedEvent;
import com.example.payment.payment_service.event.PaymentSuccessfulEvent;
import com.example.payment.payment_service.service.PaymentService;

@Service
public class PaymentConsumer {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    private static final String PAYMENT_SUCCESS_TOPIC = "payment.successful";

    // Consumes the booking.requested event and processes it
    @KafkaListener(topics = "booking.requested", groupId = "payment-group")
    public void consumeBookingEvent(BookingRequestedEvent event) {
        System.out.println("Received booking event: " + event.getBookingId());

        // Process payment for the booking event
        boolean paid = paymentService.processPaymentFromBookingEvent(event);
        if (paid) {
            // If payment is successful, send a payment successful event to a different topic
            PaymentSuccessfulEvent paymentEvent = new PaymentSuccessfulEvent(
                "Payment successful for booking ID: " + event.getBookingId(),
                event.getUserEmail()
            );
            kafkaTemplate.send(PAYMENT_SUCCESS_TOPIC, paymentEvent);

            // Send an email notification (optional)
            paymentService.sendEmailToUser(event.getUserEmail(), event.getBookingId());
        } else {
            System.out.println("Payment failed for booking ID: " + event.getBookingId());
        }
    }
}
