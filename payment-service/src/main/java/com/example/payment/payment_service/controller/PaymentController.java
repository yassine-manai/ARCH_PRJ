package com.example.payment.payment_service.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.payment.payment_service.model.Payment;
import com.example.payment.payment_service.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public String makePayment(@RequestBody Payment payment) {
        return paymentService.processPayment(payment);
    }
}
