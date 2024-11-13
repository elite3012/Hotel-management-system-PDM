package com.code.hms.entities;

public class Service {
    private int serviceId;
    private String serviceName;
    private String serviceAvailability;
    private String price;
    private double Price;
    private int typeMax;

    public Service(int serviceId, String serviceName, String serviceAvailability, String price, double price1, int typeMax) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceAvailability = serviceAvailability;
        this.price = price;
        Price = price1;
        this.typeMax = typeMax;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public int getTypeMax() {
        return typeMax;
    }

    public void setTypeMax(int typeMax) {
        this.typeMax = typeMax;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Service{" +
                "serviceId=" + serviceId +
                ", serviceName='" + serviceName + '\'' +
                ", serviceAvailability='" + serviceAvailability + '\'' +
                ", price='" + price + '\'' +
                ", Price=" + Price +
                ", typeMax=" + typeMax +
                '}';
    }
}

