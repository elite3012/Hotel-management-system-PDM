package com.code.hms.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Reservation")
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="Reservation_ID")
    private int Reservation_ID;

    @Column(name="User_ID")
    private int User_ID;

    @Column(name="Checkin_Date")
    private Date Checkin_Date;

    @Column(name="Checkout_Date")
    private Date Checkout_Date;

    @Column(name="Total_Days")
    private int Total_Days;
    
    @Column(name="Num_of_guests")
    private int Num_of_guests;

    public Reservation(int reservation_ID, int user_ID, Date checkin_Date, Date checkout_Date, int total_Days,
            int num_of_guests) {
        Reservation_ID = reservation_ID;
        User_ID = user_ID;
        Checkin_Date = checkin_Date;
        Checkout_Date = checkout_Date;
        Total_Days = total_Days;
        Num_of_guests = num_of_guests;
    }

    public int getReservation_ID() {
        return Reservation_ID;
    }

    public void setReservation_ID(int reservation_ID) {
        Reservation_ID = reservation_ID;
    }

    public int getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(int user_ID) {
        User_ID = user_ID;
    }

    public Date getCheckin_Date() {
        return Checkin_Date;
    }

    public void setCheckin_Date(Date checkin_Date) {
        Checkin_Date = checkin_Date;
    }

    public Date getCheckout_Date() {
        return Checkout_Date;
    }

    public void setCheckout_Date(Date checkout_Date) {
        Checkout_Date = checkout_Date;
    }

    public int getTotal_Days() {
        return Total_Days;
    }

    public void setTotal_Days(int total_Days) {
        Total_Days = total_Days;
    }

    public int getNum_of_guests() {
        return Num_of_guests;
    }

    public void setNum_of_guests(int num_of_guests) {
        Num_of_guests = num_of_guests;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Reservation_ID;
        result = prime * result + User_ID;
        result = prime * result + ((Checkin_Date == null) ? 0 : Checkin_Date.hashCode());
        result = prime * result + ((Checkout_Date == null) ? 0 : Checkout_Date.hashCode());
        result = prime * result + Total_Days;
        result = prime * result + Num_of_guests;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Reservation other = (Reservation) obj;
        if (Reservation_ID != other.Reservation_ID)
            return false;
        if (User_ID != other.User_ID)
            return false;
        if (Checkin_Date == null) {
            if (other.Checkin_Date != null)
                return false;
        } else if (!Checkin_Date.equals(other.Checkin_Date))
            return false;
        if (Checkout_Date == null) {
            if (other.Checkout_Date != null)
                return false;
        } else if (!Checkout_Date.equals(other.Checkout_Date))
            return false;
        if (Total_Days != other.Total_Days)
            return false;
        if (Num_of_guests != other.Num_of_guests)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Reservation [Reservation_ID=" + Reservation_ID + ", User_ID=" + User_ID + ", Checkin_Date="
                + Checkin_Date + ", Checkout_Date=" + Checkout_Date + ", Total_Days=" + Total_Days + ", Num_of_guests="
                + Num_of_guests + "]";
    }
}
