package com.code.hms.dao;

import java.util.List;

import com.code.hms.entities.User_Service;

public interface Service_OrderDAO {
    public List<Object[]> getAllServiceOrders();

    public void saveServiceOrder(User_Service user_Service);
    public void deleteServiceOrderByUserID(int userID);
}
