package com.code.hms.dao;

import java.util.List;

import com.code.hms.entities.Reservation;

public interface ReservationDAO {
    // Find reservation by id
    public Reservation getReservationByID(int reservationId);

    // Save to database
    public void saveReservation(Reservation reservation);

    // Delete reservation 
    public void deleteReservation(int reservationId);

    // Update the date or time of the reservation if the customer requests rescheduling
    public void updateReservation(Reservation reservation);

    // Find all reservations
    public List<Reservation> getAllReservations();
}
