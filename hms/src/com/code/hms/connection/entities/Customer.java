package com.code.hms.connection.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.annotation.processing.Generated;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="Customer")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Customer_id")
    private int Customer_id;

    @Column(name="First_name")
    private String First_name;

    @Column(name="Last_name")
    private String Last_name;

    @Column(name="Gender")
    private String Gender;

    @Column(name="Email")
    private String Email;

    @Column(name="Phone")
    private String Phone;

    @Column(name="Date_Of_Birth")
    private Date Date_Of_Birth;

    @Column(name="Country")
    private String Country;

    
}
