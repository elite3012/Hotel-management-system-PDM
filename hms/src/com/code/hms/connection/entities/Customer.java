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

    public Customer(){}

    public int getCustomerID(){
        return Customer_id;
    }

    public void setCustomerID(int Customer_id){
        this.Customer_id = Customer_id;
    }

    public String getFirstName(){
        return First_name;
    }

    public void setFirstName(String First_name){
        this.First_name=First_name;
    }

    public String getLastName(){
        return Last_name;
    }

    public void setLastName(String First_name){
        this.Last_name=Last_name;
    }

    public String getGender(){
        return Gender;
    }

    public void setGender(String Gender){
        this.Gender=Gender;
    }

    public String getEmail(){
        return Email;
    }

    public void setEmail(String Email){
        this.Email=Email;
    }

    public String getPhone(){
        return Phone;
    }

    public void setPhone(String Phone){
        this.Phone=Phone;
    }

    public Date getDateOfBirth(){
        return Date_Of_Birth;
    }

    public void setDateOfBirth(Date Date_Of_Birth){
        this.Date_Of_Birth=Date_Of_Birth;
    }

    public String getCountry(){
        return Country;
    }

    public void setCountry(String Country){
        this.Country=Country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        return Customer_id == customer.Customer_id &&
            (Email != null ? Email.equals(customer.Email) : customer.Email == null) &&
            (Phone != null ? Phone.equals(customer.Phone) : customer.Phone == null);
    }

}
