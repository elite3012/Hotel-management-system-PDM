package com.code.hms.daoimpl;

import com.code.hms.entities.Room_Reservation;
import com.code.hms.entities.User;
import com.code.hms.entities.User_Service;
import com.code.hms.entities.Service;
import com.code.hms.utils.LoggingEngine;
import com.code.hms.dao.User_ServiceDAO;
import com.code.hms.connection.DataSourceFactory;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import jakarta.persistence.NoResultException;

import java.util.List;

public class User_ServiceDAOImpl implements User_ServiceDAO {
    private DataSourceFactory dataSourceFactory;
    private Session session;
    private LoggingEngine loggingEngine;

    public User_ServiceDAOImpl() {
        dataSourceFactory = new DataSourceFactory();
        DataSourceFactory.createConnection();
        loggingEngine = LoggingEngine.getInstance();
    }

    // find services by user id
    public Service getServicesByUserID(int userId) {
        Service service = null;
        try {
            session = dataSourceFactory.getSessionFactory().openSession();
            session.beginTransaction();

            // HQL to fetch services associated with a user
            Query<Service> query = session.createQuery("FROM Service s WHERE s.serviceId IN (SELECT us.service.id FROM User_Service us WHERE us.user.id = :userId)", Service.class);
            query.setParameter("userId", userId); // Correct parameter for userId

            // Get the list of services associated with the user
            service = query.uniqueResult();
            System.out.println(service.toString());
            session.getTransaction().commit();

            loggingEngine.setMessage("Fetched Services by User ID: " + userId);
        } catch (NoResultException e) {
            loggingEngine.setMessage("No services found for User ID: " + userId);
        } catch (Exception e) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            loggingEngine.setMessage("Error fetching services: " + e.getLocalizedMessage());
        } finally {
            if (session != null) session.close();
        }

        return service;
    }

    // find users by service id
    public List<User> getUsersByServiceID(int serviceId) {
        List<User> users = null;
        try {
            session = dataSourceFactory.getSessionFactory().openSession();
            session.beginTransaction();

            // HQL to fetch users associated with a service
            Query<User> query = session.createQuery("FROM User u WHERE u.Service_ID = :serviceId", User.class);
            query.setParameter("serviceId", serviceId); // Correct parameter for serviceId

            // Get the list of users associated with the service
            users = query.list();
            session.getTransaction().commit();

            loggingEngine.setMessage("Fetched Users by Service ID: " + serviceId);
        } catch (NoResultException e) {
            loggingEngine.setMessage("No users found for Service ID: " + serviceId);
        } catch (Exception e) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            loggingEngine.setMessage("Error fetching users: " + e.getLocalizedMessage());
        } finally {
            if (session != null) session.close();
        }

        return users;
    }

    // save to database (example method, implement as needed)
    @Override
    public void saveServiceOrder(User_Service userService) {
        try {
            session = dataSourceFactory.getSessionFactory().openSession();
            session.beginTransaction();

            // Save the User_Service association to the database
            session.persist(userService);

            session.getTransaction().commit();
            loggingEngine.setMessage("Service order saved successfully for User ID: "
                    + userService.getUser().getUserId() + " and Service ID: " + userService.getService().getServiceId());
        } catch (HibernateException e) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            loggingEngine.setMessage("Error saving service order: " + e.getLocalizedMessage());
        } finally {
            if (session != null) session.close();
        }
    }

        // save to database (example method, implement as needed)
    public void saveRoomReservation(Room_Reservation roomReservation){
        try {
            session = dataSourceFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.persist(roomReservation); // Save the roomReservation entity
            session.getTransaction().commit();
            loggingEngine.setMessage("Room Reservation saved successfully.");
        } catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            loggingEngine.setMessage("Error saving room reservation: " + e.getLocalizedMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}

