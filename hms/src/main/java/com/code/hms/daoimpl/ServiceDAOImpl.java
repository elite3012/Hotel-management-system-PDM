package com.code.hms.daoimpl;

import com.code.hms.dao.ServiceDAO;

import com.code.hms.entities.Service;
import com.code.hms.utils.LoggingEngine;
import com.code.hms.connection.DataSourceFactory;

import org.hibernate.HibernateException;
import org.hibernate.Session;


public class ServiceDAOImpl implements ServiceDAO{

    private Session session;
    private DataSourceFactory dataSourceFactory;
    private LoggingEngine logging;

    public ServiceDAOImpl() {
        DataSourceFactory.createConnection();
        dataSourceFactory = new DataSourceFactory();
        logging = LoggingEngine.getInstance();
    }
    // Update the service availability
    public void updateService(Service service){
         try {
            session = dataSourceFactory.getSessionFactory().openSession();
            session.beginTransaction();
        
            session.update(service);  

            session.getTransaction().commit();
            logging.setMessage("Service saved successfully.");
        } catch (HibernateException e) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            logging.setMessage("Error saving service: " + e.getLocalizedMessage());
        } finally {
            if (session != null) session.close();
        }
    }

    public void deleteService(Service service){
        try {
            session = dataSourceFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(service);  
            session.getTransaction().commit();
            logging.setMessage("Service deleted successfully.");
        } catch (HibernateException e) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            logging.setMessage("Error deleting billing: " + e.getLocalizedMessage());
        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public Service getServiceByID(int serviceId) {
        session = dataSourceFactory.getSessionFactory().openSession();
        Service service = null;

        try { 
            service = session.get(Service.class, serviceId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return service;
    }
    
}
    
