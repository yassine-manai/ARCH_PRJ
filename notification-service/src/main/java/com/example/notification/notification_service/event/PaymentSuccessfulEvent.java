package com.example.notification.notification_service.event;

public class PaymentSuccessfulEvent {
    private String bookingId;
    private String status;

    public PaymentSuccessfulEvent(String bookingId, String status) {
        this.bookingId = bookingId;
        this.status = status;
    }

    // Getters and setters
    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PaymentSuccessfulEvent{" +
                "bookingId='" + bookingId + '\'' +
                ", status='" + status + '\'' +
                '}';

    }
}