package com.code.hms.entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Room_Reservation")
public class Room_Reservation {
    
    @EmbeddedId
    private Room_Reservation_Pk pk;
    
    @ManyToOne
    @JoinColumn(name = "Room_ID", insertable = false, updatable = false)
    private Room room;
    
    @ManyToOne
    @JoinColumn(name = "Reservation_ID", insertable = false, updatable = false)
    private Reservation reservation;
    
    private Date date;
    private Time time;
    
    public Room_Reservation_Pk getPk() {
        return pk;
    }

    public void setPk(Room_Reservation_Pk pk) {
        this.pk = pk;
    }
    
    // Getter and Setter for room
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    // Getter and Setter for reservation
    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    // Getter and Setter for date
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    // Getter and Setter for time
    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
/*
Example:
Room_Reservation_Pk compositeKey = new Room_Reservation_Pk
(roomId, reservationId);
Room_Reservation roomReservation = new Room_Reservation();
roomReservation.setPk(compositeKey);
roomReservation.setDate(someDate);
roomReservation.setTime(someTime);
 */