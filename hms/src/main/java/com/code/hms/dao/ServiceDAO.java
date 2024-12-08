package com.code.hms.dao;

import com.code.hms.entities.Service;

public interface ServiceDAO {

    // Update the service availability
    public void deleteService(Service service);

    // Update the service availability
    public void updateService(Service service);

    public Service getServiceByID(int serviceId);
}
