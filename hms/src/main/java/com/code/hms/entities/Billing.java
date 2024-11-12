package com.code.hms.entities;

import java.io.Serializable;
import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "Billing")
public class Billing implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Billing_ID")
    private int billingId;

    @ManyToOne
    @JoinColumn(name = "Reservation_ID", nullable = false)
    private Reservation reservation;

    @Column(name = "Amount")
    private double amount;

    @Column(name = "Payment_Method")
    private String paymentMethod;

    @Column(name = "Date")
    private Date date;

    // No-argument constructor for JPA
    public Billing() {}

    // Parameterized constructor
    public Billing(int billingId, Reservation reservation, double amount, String paymentMethod, Date date) {
        this.billingId = billingId;
        this.reservation = reservation;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.date = date;
    }

    public int getBillingId() {
        return billingId;
    }

    public void setBillingId(int billingId) {
        this.billingId = billingId;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + billingId;
        result = prime * result + ((reservation == null) ? 0 : reservation.hashCode());
        long temp;
        temp = Double.doubleToLongBits(amount);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((paymentMethod == null) ? 0 : paymentMethod.hashCode());
        result = prime * result + ((date == null) ? 0 : date.hashCode());
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
        Billing other = (Billing) obj;
        if (billingId != other.billingId)
            return false;
        if (reservation == null) {
            if (other.reservation != null)
                return false;
        } else if (!reservation.equals(other.reservation))
            return false;
        if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
            return false;
        if (paymentMethod == null) {
            if (other.paymentMethod != null)
                return false;
        } else if (!paymentMethod.equals(other.paymentMethod))
            return false;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Billing [billingId=" + billingId + ", reservation=" + reservation + ", amount=" + amount
                + ", paymentMethod=" + paymentMethod + ", date=" + date + "]";
    }
}
