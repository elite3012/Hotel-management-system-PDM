package com.code.hms.daoimpl;

import java.util.List;

import com.code.hms.dao.ReservationDAO;
import com.code.hms.entities.Reservation;
import com.code.hms.utils.LoggingEngine;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

public class ReservationDaoImpl implements ReservationDAO {
    @PersistenceContext
    private EntityManager entityManager;
    private LoggingEngine logging;

    public ReservationDaoImpl() {
        logging = LoggingEngine.getInstance();
    }

    @Override
    public Reservation getReservationByID(int reservationId) {
        Reservation theReservation = null;
        try {
            theReservation = entityManager.find(Reservation.class, reservationId);
            logging.setMessage("ReservationDAOImpl -> fetching reservation by Id...");
        } catch (NoResultException e) {
            logging.setMessage("Error: There is no reservation with this agency reference number!");
        }
        return theReservation;
    }

    @Override
    public void saveReservation(Reservation reservation) {
        try {
            entityManager.persist(reservation);
            logging.setMessage("ReservationDAOImpl -> reservation saved successfully.");
        } catch (Exception e) {
            logging.setMessage("ReservationDAOImpl Error -> " + e.getLocalizedMessage());
        }
    }

    @Override
    public void updateReservation(Reservation reservation) {
        try {
            entityManager.merge(reservation);
            logging.setMessage("ReservationDAOImpl -> reservation updated successfully.");
        } catch (Exception e) {
            logging.setMessage("ReservationDAOImpl Error -> " + e.getLocalizedMessage());
        }
    }

    @Override
    public List<Reservation> getAllReservations() {
        List<Reservation> reservations = null;
        try {
            Query query = entityManager.createQuery("SELECT r FROM Reservation r");
            reservations = query.getResultList();
            logging.setMessage("ReservationDAOImpl -> fetched all reservations successfully.");
        } catch (Exception e) {
            logging.setMessage("ReservationDAOImpl Error -> " + e.getLocalizedMessage());
        }
        return reservations;
    }
}

    