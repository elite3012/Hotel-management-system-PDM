package com.code.hms.entities;

import java.sql.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "Review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewId;

    @ManyToOne
    @JoinColumn(name = "User_ID", nullable = false) // Specifies the foreign key column
    private User user;

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
    public Review(User user, Reservation reservation, int rating, String comment, Date reviewDate) {
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
                ", userId=" + user.getUserId() +
                ", reservationId=" + reservation.getReservationId() +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", reviewDate=" + reviewDate +
                '}';
    }
}