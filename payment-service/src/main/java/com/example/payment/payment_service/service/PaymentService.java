package com.example.payment.payment_service.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.payment.payment_service.event.PaymentSuccessfulEvent;
import com.example.payment.payment_service.model.Payment;

@Service
public class PaymentService {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    private final String PAYMENT_TOPIC = "payment-successful";

    public String processPayment(Payment payment) {
        // Simulate payment processing logic
        kafkaTemplate.send(PAYMENT_TOPIC, new PaymentSuccessfulEvent(payment.getBookingId(), "SUCCESS"));
        return "Payment processed successfully.";
    }
}
