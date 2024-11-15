package com.code.hms.entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

// Composite key class for User_Service
@Embeddable
class User_Service_Pk implements Serializable {
    private int userId;
    private int serviceId;

    public User_Service_Pk() {}

    public User_Service_Pk(int userId, int serviceId) {
        this.userId = userId;
        this.serviceId = serviceId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User_Service_Pk that = (User_Service_Pk) o;
        return userId == that.userId && serviceId == that.serviceId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, serviceId);
    }
}

@Entity
@Table(name="User_Service")
public class User_Service {

    @EmbeddedId
    private User_Service_Pk pk;

    @ManyToOne
    @JoinColumn(name = "User_ID", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "Service_ID", insertable = false, updatable = false)
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
