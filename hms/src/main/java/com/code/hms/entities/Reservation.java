package com.code.hms.entities;

import java.io.Serializable;
import java.sql.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "Reservation")
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Reservation_ID")
    private int reservationId;

    @Column(name = "User_ID")
    private int userId;

    @Column(name = "Checkin_Date")
    private Date checkinDate;

    @Column(name = "Checkout_Date")
    private Date checkoutDate;

    @Column(name = "Total_Days")
    private int totalDays;

    @Column(name = "Num_of_guests")
    private int numOfGuests;

    // No-args constructor
    public Reservation() {}

    // Parameterized constructor
    public Reservation(int reservationId, int userId, Date checkinDate, Date checkoutDate, int totalDays, int numOfGuests) {
        this.reservationId = reservationId;
        this.userId = userId;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
        this.totalDays = totalDays;
        this.numOfGuests = numOfGuests;
    }

    // Getters and setters
    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(Date checkinDate) {
        this.checkinDate = checkinDate;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public int getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }

    public int getNumOfGuests() {
        return numOfGuests;
    }

    public void setNumOfGuests(int numOfGuests) {
        this.numOfGuests = numOfGuests;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + reservationId;
        result = prime * result + userId;
        result = prime * result + ((checkinDate == null) ? 0 : checkinDate.hashCode());
        result = prime * result + ((checkoutDate == null) ? 0 : checkoutDate.hashCode());
        result = prime * result + totalDays;
        result = prime * result + numOfGuests;
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
        if (reservationId != other.reservationId)
            return false;
        if (userId != other.userId)
            return false;
        if (checkinDate == null) {
            if (other.checkinDate != null)
                return false;
        } else if (!checkinDate.equals(other.checkinDate))
            return false;
        if (checkoutDate == null) {
            if (other.checkoutDate != null)
                return false;
        } else if (!checkoutDate.equals(other.checkoutDate))
            return false;
        if (totalDays != other.totalDays)
            return false;
        if (numOfGuests != other.numOfGuests)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Reservation [reservationId=" + reservationId + ", userId=" + userId + ", checkinDate=" + checkinDate
                + ", checkoutDate=" + checkoutDate + ", totalDays=" + totalDays + ", numOfGuests=" + numOfGuests + "]";
    }
}
