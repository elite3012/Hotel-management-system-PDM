package com.code.hms.dao;

import com.code.hms.entities.Service;

public interface ServiceDAO {
    // Find service by id
    public Service getServiceByID(int serviceId);

    // Update the service availability
    public void updateService(Service service);

    // Find service by name
    public Service getServiceByName(int serviceName);
}
