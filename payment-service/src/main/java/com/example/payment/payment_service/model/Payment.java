package com.example.payment.payment_service.model;


public class Payment {
    private String bookingId;
    private double amount;

    // Getters and setters
    public String getBookingId() { return bookingId; }
    public void setBookingId(String bookingId) { this.bookingId = bookingId; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    @Override
    public String toString() {
        return "Payment{" +
                "bookingId='" + bookingId + '\'' +
                ", amount=" + amount +
                '}';
    }
    
}
