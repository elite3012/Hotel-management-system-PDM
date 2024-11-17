package com.code.hms.dao;

import java.util.List;

import com.code.hms.entities.Review;

public interface ReviewDAO {
    //Find review by review id
    public Review getReviewByID(int reviewId);

    // Find all reviews of the user
    public List<Review> getReviewsByUserID(int userId);

    // Find all reviews of a specific reservation
    public List<Review> getReviewsByReservationID(int reservationId);

    // Find average rating 
    public double getAverageRating();

    // Update rating and comment of the review
    public void updateReview(Review review);

    // Delete the review
    public void deleteReview(Review review);
}