package com.code.hms.dao;

import com.code.hms.entities.Reservation;
import com.code.hms.entities.Room;
import com.code.hms.entities.Room_Reservation;

public interface Room_ReservationDAO {
    // Find reservation by room number
    public Reservation getReservationByRoomNumber(int roomId);

    // Find room by reservation id
    public Room getRoomByReservationID(int reservationId);

    // Save to database
    public void saveRoomReservation(Room_Reservation room_Reservation);
}