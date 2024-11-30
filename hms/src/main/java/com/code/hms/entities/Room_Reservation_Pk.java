package com.code.hms.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

//Composite key class for Room_Reservation
@Embeddable
public  class Room_Reservation_Pk implements Serializable{
    private int roomId;
    private int reservationId;

    public Room_Reservation_Pk(){}

    public Room_Reservation_Pk(int roomId, int reservationId) {
        this.roomId = roomId;
        this.reservationId = reservationId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room_Reservation_Pk that = (Room_Reservation_Pk) o;
        return roomId == that.roomId && reservationId == that.reservationId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId, reservationId);
    }     
}
