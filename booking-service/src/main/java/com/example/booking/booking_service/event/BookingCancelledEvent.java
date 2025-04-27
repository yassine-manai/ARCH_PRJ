package com.example.booking.booking_service.event;

public class BookingCancelledEvent {
    private String bookingId;
    private String reason;

    // Constructor, Getters, Setters
    public BookingCancelledEvent(String bookingId, String reason) {
        this.bookingId = bookingId;
        this.reason = reason;
    }
    public String getBookingId() {
        return bookingId;
    }
    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }
    public String getReason() {
        return reason;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }
    @Override
    public String toString() {
        return "BookingCancelledEvent{" +
                "bookingId='" + bookingId + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}
