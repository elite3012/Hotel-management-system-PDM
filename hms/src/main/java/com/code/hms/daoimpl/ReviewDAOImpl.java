package com.code.hms.daoimpl;

import com.code.hms.connection.DataSourceFactory;
import com.code.hms.dao.ReviewDAO;
import com.code.hms.entities.Billing;
import com.code.hms.entities.Review;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import com.code.hms.utils.LoggingEngine;

import jakarta.persistence.NoResultException;

public class ReviewDAOImpl implements ReviewDAO {
    private Session session;
    private DataSourceFactory dataSourceFactory;
    private LoggingEngine logging;

    @Override
    public Review getReviewByID(int reviewId) {
        Review review = null;
        try {
            session = dataSourceFactory.getSessionFactory().openSession();
            session.beginTransaction();
            Query<Review> query = session.createQuery("from Review where id=:reviewId", Review.class);
            query.setParameter("reviewId", reviewId);
            review = query.uniqueResult();
            session.getTransaction().commit();
            logging.setMessage("Fetched review by ID: " + reviewId);
        } catch (NoResultException e) {
            logging.setMessage("No review found with ID: " + reviewId);
        } catch (HibernateException e) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            logging.setMessage("Error fetching review: " + e.getLocalizedMessage());
        } finally {
            if (session != null) session.close();
        }
        return review;
    }

    @Override
    public Review getReviewsByUserID(int userId) {
        Review review = null;
        try {
            session = dataSourceFactory.getSessionFactory().openSession();
            session.beginTransaction();
            Query<Review> query = session.createQuery("from Review where user.id=:userId", Review.class);
            query.setParameter("userId", userId);
            review = query.uniqueResult();
            session.getTransaction().commit();
            logging.setMessage("Fetched review by user ID: " + userId);
        } catch (NoResultException e) {
            logging.setMessage("No review found with user ID: " + userId);
        } catch (HibernateException e) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            logging.setMessage("Error fetching review by user ID: " + e.getLocalizedMessage());
        } finally {
            if (session != null) session.close();
        }
        return review;
    }

    @Override
    public Review getReviewsByReservationID(int reservationId) {
        Review review = null;
        try {
            session = dataSourceFactory.getSessionFactory().openSession();
            session.beginTransaction();
            Query<Review> query = session.createQuery("from Review where reservation.id=:reservationId", Review.class);
            query.setParameter("reservationId", reservationId);
            review = query.uniqueResult();
            session.getTransaction().commit();
            logging.setMessage("Fetched review by Reservation ID: " + reservationId);
        } catch (NoResultException e) {
            logging.setMessage("No review found with Reservation ID: " + reservationId);
        } catch (HibernateException e) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            logging.setMessage("Error fetching review by Reservation ID: " + e.getLocalizedMessage());
        } finally {
            if (session != null) session.close();
        }
        return review;
    }

    @Override
    public double getAverageRating() {
            double averageRating = 0;
            try {
                session = dataSourceFactory.getSessionFactory().openSession();
                session.beginTransaction();
                Query<Double> query = session.createQuery("select avg(rating) from Review", Double.class);
                averageRating = query.uniqueResult() != null ? query.uniqueResult() : 0.0;
                session.getTransaction().commit();
                logging.setMessage("Calculated average rating: " + averageRating);
            } catch (HibernateException e) {
                if (session.getTransaction() != null) session.getTransaction().rollback();
                logging.setMessage("Error calculating average rating: " + e.getLocalizedMessage());
            } finally {
                if (session != null) session.close();
            }
            return averageRating;
    }

    @Override
    public void saveReview(Review review) {
        try {
            session = dataSourceFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.persist(review); // Save the new review entity
            session.getTransaction().commit();
            logging.setMessage("Review saved successfully with ID: " + review.getReviewId());
        } catch (HibernateException e) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            logging.setMessage("Error saving review: " + e.getLocalizedMessage());
        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public void updateReview(Review review) {
            try {
                session = dataSourceFactory.getSessionFactory().openSession();
                session.beginTransaction();
                session.update(review); // Update the review entity
                session.getTransaction().commit();
                logging.setMessage("Updated review with ID: " + review.getReviewId());
            } catch (HibernateException e) {
                if (session.getTransaction() != null) session.getTransaction().rollback();
                logging.setMessage("Error updating review: " + e.getLocalizedMessage());
            } finally {
                if (session != null) session.close();
            }
    }

    @Override
    public void deleteReview(Review review) {
        try {
            session = dataSourceFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(review); // Delete the review entity
            session.getTransaction().commit();
            logging.setMessage("Deleted review with ID: " + review.getReviewId());
        } catch (HibernateException e) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            logging.setMessage("Error deleting review: " + e.getLocalizedMessage());
        } finally {
            if (session != null) session.close();
        }
    }
}
