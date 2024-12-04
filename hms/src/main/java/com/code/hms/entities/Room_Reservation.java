package com.code.hms.entities;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Room_Reservation")
public class Room_Reservation {

    @EmbeddedId
    private Room_Reservation_Pk pk; 

    @ManyToOne
    @JoinColumn(name = "Room_ID", nullable = false)
    private Room room;

    @ManyToOne
    @JoinColumn(name = "Reservation_ID", nullable = false) 
    private Reservation reservation;

    @Column(name = "Date")
    private Date date;

    @Column(name = "Time")
    private Time time;

    public Room_Reservation_Pk getPk() {
        return pk;
    }

    public void setPk(Room_Reservation_Pk pk) {
        this.pk = pk;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
    
    public static void main(String[] args) {
        Room_Reservation_Pk pk = new Room_Reservation_Pk(11, 12);
    // Create the Room_Reservation object
    Room_Reservation rr = new Room_Reservation();
    rr.setPk(pk);

    // Simulate fetching Room and Reservation from the database
    Room room = new Room(); // Example - replace with actual room fetched from the DB
    room.setRoomId(11); // Assuming the Room_ID is 11
    room.setRoomStatus("Available");

    Reservation reservation = new Reservation(); // Example - replace with actual reservation fetched from the DB
    reservation.setReservationId(12);

    // Set Room and Reservation objects in Room_Reservation
    rr.setRoom(room);
    rr.setReservation(reservation);

    // Now accessing getRoom() will return the Room object
    System.out.println(rr.getPk().getRoomId());
    System.out.println("Room Status: " + rr.getRoom().getRoomStatus());

    }
}
