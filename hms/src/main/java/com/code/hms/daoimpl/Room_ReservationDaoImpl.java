package com.code.hms.daoimpl;


import java.util.List;

import org.hibernate.Session;

import com.code.hms.connection.DataSourceFactory;
import com.code.hms.dao.Room_ReservationDAO;
import com.code.hms.entities.Reservation;
import com.code.hms.entities.Room;
import com.code.hms.entities.Room_Reservation;

public class Room_ReservationDaoImpl implements Room_ReservationDAO {

    private DataSourceFactory dsf;
    private Session session;
    
    public Room_ReservationDaoImpl() {
        DataSourceFactory.createConnection();
        dsf = new DataSourceFactory();
    }

    @Override
    public List<Reservation> getReservationByRoomNumber(int roomId) {
        session = dsf.getSessionFactory().openSession();
        List<Reservation> reservationList = null;

        try {
            reservationList = session.createQuery("from Reservation r where r.reservationId in "
            + "(select rr.reservationId from Room_Reservation rr where rr.roomId = :roomId)", Reservation.class).
            setParameter("roomId", roomId).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return reservationList;
    }

    @Override
    public List<Room> getRoomByReservationID(int reservationId) {
        session = dsf.getSessionFactory().openSession();
        List<Room> roomList = null;

        try {
            roomList = session.createQuery("from Room r where r.roomId in "
            + "(select rr.roomId from Room_Reservation rr where rr.reservationId = :reservationId)", Room.class).
            setParameter("reservationId", reservationId).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return roomList;
    }

    @Override
    public void saveRoomReservation(Room_Reservation room_Reservation) {
        session = dsf.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            session.persist(room_Reservation);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
