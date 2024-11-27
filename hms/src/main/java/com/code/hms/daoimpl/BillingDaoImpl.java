package com.code.hms.daoimpl;

import com.code.hms.connection.DataSourceFactory;
import com.code.hms.dao.BillingDAO;
import com.code.hms.entities.Billing;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import com.code.hms.utils.LoggingEngine;

import jakarta.persistence.NoResultException;


public class BillingDaoImpl implements BillingDAO {

    private Session session;
    private LoggingEngine logging;
    private DataSourceFactory dataSourceFactory;

    public BillingDaoImpl() {
        dataSourceFactory = new DataSourceFactory();
        DataSourceFactory.createConnection(); 
        logging = LoggingEngine.getInstance();
    }

    @Override
    public void saveBilling(Billing billing) {
        try {
            session = dataSourceFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.persist(billing);  
            session.getTransaction().commit();
            logging.setMessage("Billing saved successfully.");
        } catch (HibernateException e) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            logging.setMessage("Error saving billing: " + e.getLocalizedMessage());
        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public void deleteBilling(int billingId) {
        try {
            session = dataSourceFactory.getSessionFactory().openSession();
            session.beginTransaction();
            Billing billing = session.get(Billing.class, billingId); 
            session.remove(billing);  
            session.getTransaction().commit();
            logging.setMessage("Billing deleted successfully.");
        } catch (HibernateException e) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            logging.setMessage("Error deleting billing: " + e.getLocalizedMessage());
        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public Billing getBillingByID(int billingId) {
        Billing billing = null;
        try {
            session = dataSourceFactory.getSessionFactory().openSession();
            session.beginTransaction();
            Query<Billing> query = session.createQuery("from Billing where id=:billingId", Billing.class);
            query.setParameter("billingId", billingId);
            billing = query.uniqueResult();
            session.getTransaction().commit();
            logging.setMessage("Fetched billing by ID: " + billingId);
        } catch (NoResultException e) {
            logging.setMessage("No billing found with ID: " + billingId);
        } catch (HibernateException e) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            logging.setMessage("Error fetching billing: " + e.getLocalizedMessage());
        } finally {
            if (session != null) session.close();
        }
        return billing;
    }

    @Override
    public Billing getBillingByReservationID(int reservationId) {
        Billing billing = null;
        try {
            session = dataSourceFactory.getSessionFactory().openSession();
            session.beginTransaction();
            Query<Billing> query = session.createQuery("from Billing where reservation.id=:reservationId", Billing.class);
            query.setParameter("reservationId", reservationId);
            billing = query.uniqueResult();
            session.getTransaction().commit();
            logging.setMessage("Fetched billing by Reservation ID: " + reservationId);
        } catch (NoResultException e) {
            logging.setMessage("No billing found with Reservation ID: " + reservationId);
        } catch (HibernateException e) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            logging.setMessage("Error fetching billing by Reservation ID: " + e.getLocalizedMessage());
        } finally {
            if (session != null) session.close();
        }
        return billing;
    }

    @Override
    public Billing getBillingByRoomNumber(int roomId) {
        Billing billing = null;
        try {
            session = dataSourceFactory.getSessionFactory().openSession();
            session.beginTransaction();
            Query<Billing> query = session.createQuery("from Billing where room.id=:roomId", Billing.class);
            query.setParameter("roomId", roomId);
            billing = query.uniqueResult();
            session.getTransaction().commit();
            logging.setMessage("Fetched billing by Room ID: " + roomId);
        } catch (NoResultException e) {
            logging.setMessage("No billing found with Room ID: " + roomId);
        } catch (HibernateException e) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            logging.setMessage("Error fetching billing by Room ID: " + e.getLocalizedMessage());
        } finally {
            if (session != null) session.close();
        }
        return billing;
    }

    @Override
    public Billing getLastBilling() {
        Billing lastBilling = null;
        try {
            session = dataSourceFactory.getSessionFactory().openSession();
            session.beginTransaction();
            Query<Billing> query = session.createQuery("from Billing order by id desc", Billing.class);
            query.setMaxResults(1);
            lastBilling = query.uniqueResult();
            session.getTransaction().commit();
            logging.setMessage("Fetched the last billing.");
        } catch (NoResultException e) {
            logging.setMessage("No last billing found.");
        } catch (HibernateException e) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            logging.setMessage("Error fetching last billing: " + e.getLocalizedMessage());
        } finally {
            if (session != null) session.close();
        }
        return lastBilling;
    }
}

