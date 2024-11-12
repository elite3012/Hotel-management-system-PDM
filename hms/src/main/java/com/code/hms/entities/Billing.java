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

    

    
}