package com.code.hms.connection.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Reservation")
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="Reservation_id")
    private int Reservation_id;

    @Column(name="Customer_id")
    private int Customer_id;

    @Column(name="Room_id")
    private int Room_id;

    @Column(name="Service_id")
    private int Service_id;

    @Column(name="CheckinDate")
    private Date CheckinDate;

    @Column(name="CheckoutDate")
    private Date CheckoutDate;

    @Column(name="TotalDays")
    private int TotalDays;
    
    @Column(name="RoomNumber")
    private String RoomNumber;
    
}
