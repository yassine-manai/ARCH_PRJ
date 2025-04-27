package com.example.payment.payment_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.payment.payment_service.model.PaymentRequest;

@RestController
@RequestMapping("/payment")
@CrossOrigin(origins = "http://127.0.0.1:5500")  // Allow CORS for this controller
public class PaymentController {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @PostMapping("/process")
    public String processPayment(@RequestBody PaymentRequest paymentRequest) {
        // Logic to process payment
        System.out.println("Processing payment for booking ID: " + paymentRequest.getBookingId() + " with amount: " + paymentRequest.getAmount());

        // Send a notification to Kafka
        kafkaTemplate.send("payment-notification", "Payment processed successfully");

        return "Payment processed successfully";
    }
}
