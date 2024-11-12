package com.code.hms.entities;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Billing")
public class Billing implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "Billing_ID")
    private int Billing_ID;

    @Column(name = "Reservation_ID")
    private int Reservation_ID;

    @Column(name = "Amount")
    private double Amount;
    
    @Column(name = "Payment_Method")
    private String Payment_Method;

    @Column(name = "Date")
    private Date date;

    public Billing(int billing_ID, int reservation_ID, double amount, String payment_Method, Date date) {
        Billing_ID = billing_ID;
        Reservation_ID = reservation_ID;
        Amount = amount;
        Payment_Method = payment_Method;
        this.date = date;
    }

    public int getBilling_ID() {
        return Billing_ID;
    }

    public void setBilling_ID(int billing_ID) {
        Billing_ID = billing_ID;
    }

    public int getReservation_ID() {
        return Reservation_ID;
    }

    public void setReservation_ID(int reservation_ID) {
        Reservation_ID = reservation_ID;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }

    public String getPayment_Method() {
        return Payment_Method;
    }

    public void setPayment_Method(String payment_Method) {
        Payment_Method = payment_Method;
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
        result = prime * result + Billing_ID;
        result = prime * result + Reservation_ID;
        long temp;
        temp = Double.doubleToLongBits(Amount);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((Payment_Method == null) ? 0 : Payment_Method.hashCode());
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
        if (Billing_ID != other.Billing_ID)
            return false;
        if (Reservation_ID != other.Reservation_ID)
            return false;
        if (Double.doubleToLongBits(Amount) != Double.doubleToLongBits(other.Amount))
            return false;
        if (Payment_Method == null) {
            if (other.Payment_Method != null)
                return false;
        } else if (!Payment_Method.equals(other.Payment_Method))
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
        return "Billing [Billing_ID=" + Billing_ID + ", Reservation_ID=" + Reservation_ID + ", Amount=" + Amount
                + ", Payment_Method=" + Payment_Method + ", date=" + date + "]";
    }
}