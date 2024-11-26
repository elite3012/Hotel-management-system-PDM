package com.code.hms.connection;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

import com.code.hms.entities.Billing;
import com.code.hms.entities.Reservation; 
import com.code.hms.entities.Review;
import com.code.hms.entities.Room;
import com.code.hms.entities.Room_Reservation;
import com.code.hms.entities.Service;
import com.code.hms.entities.User;
import com.code.hms.entities.User_Service;

public class DataSourceFactory {

    private static SessionFactory sessionFactory = null;

    public DataSourceFactory() {}

    // This method will create and configure a Hibernate SessionFactory
    public static synchronized void createConnection() {
        try {
            // Initialize the SessionFactory if it is not already created
            if (sessionFactory == null) {
                sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml") // Config file location
                    .addAnnotatedClass(Reservation.class)
					.addAnnotatedClass(Billing.class)
					.addAnnotatedClass(Review.class)
					.addAnnotatedClass(Room.class)
					.addAnnotatedClass(Room_Reservation.class)
					.addAnnotatedClass(Service.class)
					.addAnnotatedClass(User.class)
					.addAnnotatedClass(User_Service.class)  // Add all your entity classes here
                    .buildSessionFactory();
            }
        } catch (HibernateException e) {
            // Handle exception and log it appropriately
            e.printStackTrace();
        }
    }

    // Get SessionFactory to open sessions
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    // Get SQL Connection from Hibernate SessionFactory
    public Connection getSqlConnection() {
        Connection connection = null;
        try {
            // Retrieve the JDBC connection from the session factory
            connection = getSessionFactory()
                    .getSessionFactoryOptions()
                    .getServiceRegistry()
                    .getService(ConnectionProvider.class)
                    .getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // Get the current transaction from Hibernate session
    public Transaction getTransaction() {
        return getSessionFactory().getCurrentSession().beginTransaction();
    }

    // Method to shut down the SessionFactory (close it)
    public void shutDown() {
        if (sessionFactory != null && sessionFactory.isOpen()) {
            sessionFactory.close();
        }
    }
}
