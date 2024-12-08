package com.code.hms.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class User_Service_Pk implements Serializable {
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
