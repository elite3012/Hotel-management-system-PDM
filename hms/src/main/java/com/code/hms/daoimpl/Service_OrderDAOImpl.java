package com.code.hms.daoimpl;

import com.code.hms.connection.DataSourceFactory;
import com.code.hms.dao.Service_OrderDAO;
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
}
