package com.code.hms.entities;


import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Service_Order")
public class User_Service {

    @EmbeddedId
    private User_Service_Pk pk;

    @ManyToOne
    @JoinColumn(name = "User_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "Service_ID")
    private Service service;

    private Date date;
    private Time time;

    public User_Service_Pk getPk() {
        return pk;
    }

    public void setPk(User_Service_Pk pk) {
        this.pk = pk;
    }

    // Getter and Setter for user
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // Getter and Setter for service
    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    // Getter and Setter for date
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    // Getter and Setter for time
    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
/*
Example:
User_Service_Pk compositeKey = new User_Service_Pk(userId, serviceId);
User_Service userService = new User_Service();
userService.setPk(compositeKey);
userService.setDate(someDate);
userService.setTime(someTime);
 */
