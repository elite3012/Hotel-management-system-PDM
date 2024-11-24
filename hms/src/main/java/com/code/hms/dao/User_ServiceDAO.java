package com.code.hms.dao;

import java.util.List;

import com.code.hms.entities.Room_Reservation;
import com.code.hms.entities.Service;
import com.code.hms.entities.User;

public interface User_ServiceDAO {
    // find services by user id
    public List<Service> getServicesByUserID(int userId);

    // find users by service id
    public List<User> getUsersByServiceID(int serviceId);

    // save to database
    public void saveRoomReservation(Room_Reservation room_Reservation);
}