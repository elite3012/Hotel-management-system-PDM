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
            + "(select rr.room.roomId from Room_Reservation rr where rr.reservation.reservationId = :reservationId)", Room.class).
            setParameter("reservationId", reservationId).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return roomList;
    }

    @Override
    public void saveRoomReservation(Room_Reservation roomReservation) {
        session = dsf.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Room room = session.get(Room.class, roomReservation.getPk().getRoomId());
            Reservation reservation = session.get(Reservation.class, roomReservation.getPk().getReservationId());
            roomReservation.setRoom(room);
            roomReservation.setReservation(reservation);
            session.persist(roomReservation); 
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

    @Override
    public void deleteRoomReservation(Room_Reservation roomReservation) {
        session = dsf.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Room_Reservation existingReservation = session.get(Room_Reservation.class, roomReservation.getPk());
            if (existingReservation != null) {
                session.delete(existingReservation); 
            } else {
                System.out.println("Room_Reservation does not exist for the given composite key.");
            }
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

    @Override
    public List<Room_Reservation> getRoomReservationsByReservationID(int reservationId) {
        session = dsf.getSessionFactory().openSession();
        List<Room_Reservation> roomReservationList = null;
        try {
            roomReservationList = session.createQuery(
                "from Room_Reservation rr where rr.pk.reservationId = :reservationId", 
                Room_Reservation.class
            ).setParameter("reservationId", reservationId).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return roomReservationList;
    }

}
