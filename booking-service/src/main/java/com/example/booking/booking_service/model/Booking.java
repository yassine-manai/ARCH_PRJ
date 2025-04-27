package com.example.booking.booking_service.model;

public class Booking {
    private String bookingId;
    private String movie;
    private String seat;
    private String userEmail;

    public Booking(String bookingId, String movie, String seat, String userEmail) {
        this.bookingId = bookingId;
        this.movie = movie;
        this.seat = seat;
        this.userEmail = userEmail;
    }

    // Corrected method names:
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
        return "Booking{" +
                "bookingId='" + bookingId + '\'' +
                ", movie='" + movie + '\'' +
                ", seat='" + seat + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}