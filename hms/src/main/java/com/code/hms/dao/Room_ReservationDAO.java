package com.code.hms.dao;

import java.util.List;

import com.code.hms.entities.Reservation;
import com.code.hms.entities.Room;
import com.code.hms.entities.Room_Reservation;

public interface Room_ReservationDAO {
    // Find reservation by room number
    public List<Reservation> getReservationByRoomNumber(int roomId);

    // Find room by reservation id
    public List<Room> getRoomByReservationID(int reservationId);

    // Save to database
    public void saveRoomReservation(Room_Reservation room_Reservation);

    // Delete the room_reservation
    public void deleteRoomReservation(Room_Reservation room_Reservation);

    // Find room_reservation by reservation ID
    public void getRoomReservationsByReservationID(int reservationId);
}