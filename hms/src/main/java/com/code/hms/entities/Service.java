package com.code.hms.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Service")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Service_ID")
    private int serviceId;

    @Column(name = "ServiceName")
    private String serviceName;

    @Column(name = "ServiceAvailability")
    private String serviceAvailability;

    @Column(name = "Price")
    private double Price;

    // No-argument constructor (required for JPA)
    public Service() {
        
    }

    // Constructor with fields (excluding the generated ID)
    public Service(int serviceId, String serviceName, String serviceAvailability, String price, double price1) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceAvailability = serviceAvailability;
        Price = price1;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceAvailability() {
        return serviceAvailability;
    }

    public void setServiceAvailability(String serviceAvailability) {
        this.serviceAvailability = serviceAvailability;
    }

    public void setPrice(double price) {
        Price = price;
    }

    @Override
    public String toString() {
        return "Service{" +
                "serviceId=" + serviceId +
                ", serviceName='" + serviceName + '\'' +
                ", serviceAvailability='" + serviceAvailability + '\'' +
                ", Price=" + Price +
                '}';
    }
}

