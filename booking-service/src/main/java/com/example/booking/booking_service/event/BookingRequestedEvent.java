package com.example.booking.booking_service.event;


public class BookingRequestedEvent {
    private String bookingId;
    private String movie;
    private String seat;
    private String userEmail;

    // Constructor, Getters, Setters
    public BookingRequestedEvent() {
        this.bookingId = bookingId;
        this.movie = movie;
        this.seat = seat;
        this.userEmail = userEmail;
    }
    public String getBookingId() {
        return bookingId;
    }
    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }
    public String getMovie() {
        return movie;
    }
    public void setMovie(String movie) {
        this.movie = movie;
    }
    public String getSeat() {
        return seat;
    }
    public void setSeat(String seat) {
        this.seat = seat;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return "BookingRequestedEvent{" +
                "bookingId='" + bookingId + '\'' +
                ", movie='" + movie + '\'' +
                ", seat='" + seat + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }


}
