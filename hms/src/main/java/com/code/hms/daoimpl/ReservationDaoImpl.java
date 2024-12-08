package com.code.hms.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.code.hms.connection.DataSourceFactory;
import com.code.hms.dao.ReservationDAO;
import com.code.hms.entities.Reservation;
import com.code.hms.utils.LoggingEngine;

import jakarta.persistence.NoResultException;

public class ReservationDaoImpl implements ReservationDAO {
    private Session session;
    private LoggingEngine logging;
    private DataSourceFactory dataSourceFactory;

    public ReservationDaoImpl() {

        dataSourceFactory = new DataSourceFactory();
        DataSourceFactory.createConnection(); 
        logging = LoggingEngine.getInstance();
    }

    @Override
    public Reservation getReservationByID(int reservationId) {
        Reservation reservation = null;
        Session session = null;
    
        try {
            session = dataSourceFactory.getSessionFactory().openSession();
    
            // Query to fetch a Reservation entity by its ID
            reservation = session.get(Reservation.class, reservationId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    
        return reservation;
    }

    @Override
    public void saveReservation(Reservation reservation) {
        try {
            session = dataSourceFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.persist(reservation);  
            session.getTransaction().commit();
            logging.setMessage("Reservation saved successfully.");
        } catch (HibernateException e) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            logging.setMessage("Error saving reservation: " + e.getLocalizedMessage());
        } finally {
            if (session != null) session.close();
        }
    }

    @Override
public void deleteReservation(int reservationId) {
    try {
        session = dataSourceFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Reservation reservation = session.get(Reservation.class, reservationId);
        if (reservation != null) {
            session.remove(reservation); // Delete the reservation
            session.getTransaction().commit();
            logging.setMessage("Reservation deleted successfully.");
        } else {
            logging.setMessage("Reservation not found.");
        }
    } catch (HibernateException e) {
        if (session.getTransaction() != null) session.getTransaction().rollback();
        logging.setMessage("Error deleting reservation: " + e.getLocalizedMessage());
    } finally {
        if (session != null) session.close();
    }
}

    @Override
    public void updateReservation(Reservation reservation) {
        try {
            session = dataSourceFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.merge(reservation);  
            session.getTransaction().commit();
            logging.setMessage("Reservation updated successfully.");
        } catch (HibernateException e) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            logging.setMessage("Error updating reservation: " + e.getLocalizedMessage());
        } finally {
            if (session != null) session.close();
        }
    }

    public List<Object[]> getAllReservations() {
        List<Object[]> reservations = null;
        Session session = null;
    
        try {
            session = dataSourceFactory.getSessionFactory().openSession();
    
            String query = "SELECT r.reservation_id, r.user_id, u.firstName, u.lastName, " +
                         "r.checkIn_Date, r.checkOut_Date, " +
                         "DATEDIFF(r.checkOut_Date, r.checkIn_Date) AS totalDays, " +
                         "r.num_Of_Guests " +
                         "FROM Reservation r " +
                         "JOIN User u ON r.user_Id = u.user_Id";
    
            reservations = session.createNativeQuery(query).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return reservations;
    }
    
}
