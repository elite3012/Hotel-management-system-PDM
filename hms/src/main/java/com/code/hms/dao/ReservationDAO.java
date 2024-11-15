package com.code.hms.dao;

import java.util.List;

import com.code.hms.entities.Reservation;

public interface ReservationDAO {
    // Find reservation by id
    public void getReservationByID();

    // Save to database
    public void saveReservation(Reservation reservation);

    // Update the date or time of the reservation if the customer requests rescheduling
    public void updateReservation(Reservation reservation);

    // Find reservation by room number
    public void getReservationByRoomNumber();

    // Find all reservations
    public List<Reservation> getAllReservations();
}
