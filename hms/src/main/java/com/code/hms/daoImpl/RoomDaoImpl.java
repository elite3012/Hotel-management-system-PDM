package com.code.hms.daoImpl;

import java.util.List;

import com.code.hms.dao.RoomDAO;
import com.code.hms.entities.Room;
import com.code.hms.utils.LoggingEngine;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

public class RoomDaoImpl implements RoomDAO {
    @PersistenceContext
    private EntityManager entityManager;
    private LoggingEngine logging;

    public RoomDaoImpl(){
        logging = LoggingEngine.getInstance();
    }

    @Override
    public Room getRoomByRoomID(int roomId) {
        Room room = null;
        try {
            room = entityManager.find(Room.class, roomId);
            logging.setMessage("RoomDaoImpl -> Room fetched successfully by id.");
        } catch (NoResultException e) {
            logging.setMessage("Error: No room found with the given id !");
        }
        return room;
    }

    @Override
    public List<Room> getAllAvailableRooms() {
        List<Room> availableRooms = null;
        try {
            // Update the query to check for Room_Status
            Query query = entityManager.createQuery("SELECT r FROM Room r WHERE r.roomStatus = 'available'");
            availableRooms = query.getResultList();
            logging.setMessage("RoomDaoImpl -> Fetched all available rooms successfully.");
        } catch (Exception e) {
            logging.setMessage("RoomDaoImpl Error -> " + e.getLocalizedMessage());
        }
        return availableRooms;
}

@Override
    public void saveRoom(Room room) {
        try {
            entityManager.persist(room);
            logging.setMessage("RoomDaoImpl -> Room saved successfully.");
        } catch (Exception e) {
            logging.setMessage("RoomDaoImpl Error -> " + e.getLocalizedMessage());
        }
    }

}
