package com.example.payment.payment_service.event;

public class BookingRequestedEvent {
    private String bookingId;
    private String userId;
    private String movie;
    private int seat;

    // Getters and setters
    public String getBookingId() {
        return bookingId;
    }
    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getMovie() {
        return movie;
    }
    public void setMovie(String movie) {
        this.movie = movie;
    }
    public int getSeat() {
        return seat;
    }
    public void setSeat(int seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "BookingRequestedEvent{" +
                "bookingId='" + bookingId + '\'' +
                ", userId='" + userId + '\'' +
                ", movie='" + movie + '\'' +
                ", seat=" + seat +
                '}';
    }

}
