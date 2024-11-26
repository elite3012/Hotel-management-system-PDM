package com.code.hms.daoimpl;

import com.code.hms.dao.ServiceDAO;
import com.code.hms.entities.Service;
import com.code.hms.utils.LoggingEngine;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import org.hibernate.HibernateException;


public class ServiceDAOImpl implements ServiceDAO{

    @PersistenceContext
    private LoggingEngine loggingEngine;
    private EntityManager entityManager;

    // Find service by id
    public Service getServiceByID(int serviceId){
        Service service = null;
        try{
            Query query = entityManager.createQuery("SELECT * FROM Service WHERE serviceId = ?");
            query.setParameter(1, serviceId);
            service = (Service) query.getSingleResult();
            loggingEngine.setMessage("Successfully fetched service with ID: " + serviceId);
        } catch (NoResultException e) {
            loggingEngine.setMessage("No service found with ID: " + serviceId);
        } catch (HibernateException e) {
        loggingEngine.setMessage("Error fetching service with ID: " + serviceId + ". Error: " + e.getMessage());
        e.printStackTrace();
        }
        return service;
    }  

    // Update the service availability
    public void updateService(Service service){
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(service); // Merge updates the entity in the database
            entityManager.getTransaction().commit();
            loggingEngine.setMessage("Successfully updated service with ID: " + service.getServiceId());
        } catch (HibernateException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            loggingEngine.setMessage("Error updating service with ID: " + service.getServiceId() + ". Error: " + e.getMessage());
            e.printStackTrace();
        }

    };
    
    // Find service by name
    public Service getServiceByName(int serviceName){
        Service service = null;
        try {
            Query query = entityManager.createQuery("SELECT s FROM Service s WHERE s.serviceName = :serviceName", Service.class);
            query.setParameter("serviceName", serviceName);
            service = (Service) query.getSingleResult();
            loggingEngine.setMessage("Successfully fetched service with name: " + serviceName);
        } catch (NoResultException e) {
            loggingEngine.setMessage("No service found with name: " + serviceName);
        } catch (HibernateException e) {
            loggingEngine.setMessage("Error fetching service with name: " + serviceName + ". Error: " + e.getMessage());
            e.printStackTrace();
        }
        return service;
    }
}
    
