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

    public Reservation(){}

    public int getReservationID() {
        return Reservation_id;
    }

    public void setReservationID(int Reservation_id) {
        this.Reservation_id = Reservation_id;
    }

    public int getCustomerID() {
        return Customer_id;
    }

    public void setCustomerID(int Customer_id) {
        this.Customer_id = Customer_id;
    }

    public int getRoomID() {
        return Room_id;
    }

    public void setRoomId(int Room_id) {
        this.Room_id = Room_id;
    }

    public int getServiceId() {
        return Service_id;
    }

    public void setServiceId(int Service_id) {
        this.Service_id = Service_id;
    }

    public Date getCheckinDate() {
        return CheckinDate;
    }

    public void setCheckinDate(Date CheckinDate) {
        this.CheckinDate = CheckinDate;
    }

    public Date getCheckoutDate() {
        return CheckoutDate;
    }

    public void setCheckoutDate(Date CheckoutDate) {
        this.CheckoutDate = CheckoutDate;
    }

    public int getTotalDays() {
        return TotalDays;
    }

    public void setTotalDays(int TotalDays) {
        this.TotalDays = TotalDays;
    }

    public String getRoomNumber() {
        return RoomNumber;
    }

    public void setRoomNumber(String RoomNumber) {
        this.RoomNumber = RoomNumber;
    }

}
