package com.code.hms.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewId;

    @ManyToOne
    @JoinColumn(name = "User_ID", nullable = false) // Specifies the foreign key column
    private int userId;

    @ManyToOne
    @JoinColumn(name = "Reservation_ID", nullable = false) // Specifies the foreign key column
    private Reservation reservation;

    @Column(name = "Rating")
    private int rating;

    @Column(name = "Comment")
    private String comment;

    @Column(name = "ReviewDate")
    private Date reviewDate;

    // No-argument constructor (required by JPA)
    public Review() {
    }

    // Constructor
    public Review(int userId, Reservation reservation, int rating, String comment, Date reviewDate) {
        this.userId = userId;
        this.reservation = reservation;
        this.rating = rating;
        this.comment = comment;
        this.reviewDate = reviewDate;
    }
    // Getters and Setters
    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getUserID() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", userId=" + userId +
                ", reservationId=" + reservation.getReservationId() +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", reviewDate=" + reviewDate +
                '}';
    }
}