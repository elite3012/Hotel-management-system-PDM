package com.code.hms.daoimpl;

import com.code.hms.connection.DataSourceFactory;
import com.code.hms.dao.Service_OrderDAO;
import com.code.hms.entities.Service;
import com.code.hms.entities.User;
import com.code.hms.entities.User_Service;
import com.code.hms.utils.LoggingEngine;
import org.hibernate.Session;

import java.util.List;

public class Service_OrderDAOImpl implements Service_OrderDAO {
    private Session session;
    private LoggingEngine logging;
    private DataSourceFactory dataSourceFactory;

    public Service_OrderDAOImpl() {
        dataSourceFactory = new DataSourceFactory();
        DataSourceFactory.createConnection();
        logging = LoggingEngine.getInstance();
    }
    public List<Object[]> getAllServiceOrders() {
        List<Object[]> serviceOrders = null;
        Session session = null;

        try {
            session = dataSourceFactory.getSessionFactory().openSession();

            String query = "SELECT so.User_ID, s.ServiceName, so.Date, so.Time " +
            "FROM Service_Order so, Service s, User u " +
            "WHERE so.Service_ID = s.Service_ID AND so.User_ID = u.User_ID";

            serviceOrders = session.createNativeQuery(query).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return serviceOrders;
    }
    @Override
    public void saveServiceOrder(User_Service user_Service) {
        session = dataSourceFactory.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            User user = session.get(User.class, user_Service.getPk().getUserId());
            Service service = session.get(Service.class, user_Service.getPk().getServiceId());
            user_Service.setUser(user);
            user_Service.setService(service);
            session.persist(user_Service);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
