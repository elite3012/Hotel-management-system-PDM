package com.code.hms.daoimpl;

import com.code.hms.dao.RoomDAO;
import com.code.hms.entities.Room;
import com.code.hms.connection.DataSourceFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.MutationQuery;

import java.util.List;

public class RoomDaoImpl implements RoomDAO {
    private DataSourceFactory dataSourceFactory;

    public RoomDaoImpl() {
        dataSourceFactory = new DataSourceFactory();
    }

    @Override
    public Room getRoomByRoomID(int roomId) {
        Session session = dataSourceFactory.getSessionFactory().openSession();
        Room room = null;
        try {
            room = session.get(Room.class, roomId); 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return room;
    }

    @Override
    public List<Room> getAllAvailableRooms() {
        Session session = dataSourceFactory.getSessionFactory().openSession();
        List<Room> availableRooms = null;
        try {
            Query<Room> query = session.createQuery("FROM Room r WHERE r.roomStatus = 'Available'", Room.class);
            availableRooms = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return availableRooms;
    }

    @Override
    public void saveRoom(Room room) {
        Transaction transaction = null;
        Session session = dataSourceFactory.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.persist(room); 
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void updateRoom(Room room) {
        Transaction transaction = null;
        Session session = dataSourceFactory.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.merge(room); 
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Room> getAllRooms() {
        Session session = dataSourceFactory.getSessionFactory().openSession();
        List<Room> rooms = null;
        try {
            Query<Room> query = session.createQuery("FROM Room", Room.class);
            rooms = query.getResultList(); // 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return rooms;
    }
    @Override
    public String getRoomStatus(int roomId) {
        Session session = dataSourceFactory.getSessionFactory().openSession();
        try {
            Room room = session.get(Room.class, roomId);
            return room != null ? room.getRoomStatus() : "Unknown";
        } catch (Exception e) {
            e.printStackTrace();
            return "Unknown";
        } finally {
            session.close();
        }
    }

    @Override
    public String getRoomCleaningStatus(int roomId) {
        Session session = dataSourceFactory.getSessionFactory().openSession();
        try {
            Room room = session.get(Room.class, roomId);
            return room != null ? room.getCleaningStatus() : "Unknown";
        } catch (Exception e) {
            e.printStackTrace();
            return "Unknown";
        } finally {
            session.close();
        }
    }

    @Override
    public void setRoomCleaned(int roomId) {
        Session session = dataSourceFactory.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Room room = session.get(Room.class, roomId);
            if (room != null) {
                room.setRoomCleaningStatus("Clean");
                session.merge(room);
                System.out.println("Cleaning status updated to 'Clean' for room ID: " + roomId);
            } else {
                System.out.println("No room found for the provided room ID: " + roomId);
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
    public void setRoomUncleaned(int roomId) {
        Session session = dataSourceFactory.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Room room = session.get(Room.class, roomId);
            if (room != null) {
                room.setRoomCleaningStatus("Unclean");
                session.merge(room);
                System.out.println("Cleaning status updated to 'Unclean' for room ID: " + roomId);
            } else {
                System.out.println("No room found for the provided room ID: " + roomId);
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
    public void setRoomCheckedOut(int roomId) {
        Session session = dataSourceFactory.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Room room = session.get(Room.class, roomId);   
            if (room != null) {
                room.setRoomStatus("Available");
                session.merge(room); 
                System.out.println("Room status updated to 'Available' for room ID: " + roomId);
            } else {
                System.out.println("No room found for the provided room ID: " + roomId);
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
    public void setRoomCheckedIn(int roomId) {
        Session session = dataSourceFactory.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Room room = session.get(Room.class, roomId);
            if (room != null) {
                room.setRoomStatus("Unavailable");
                session.merge(room);
                System.out.println("Room status updated to 'Unavailable' for room ID: " + roomId);
            } else {
                System.out.println("No room found for the provided room ID: " + roomId);
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
    public void setAllRoomsAtClean(String clean) {
        Transaction transaction = null;
        Session session = dataSourceFactory.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            MutationQuery query = session.createMutationQuery("UPDATE Room r SET r.cleaningStatus = :clean");
            query.setParameter("clean", clean);
            int result = query.executeUpdate();
            if (result > 0) {
                System.out.println("All rooms updated as clean.");
            } else {
                System.out.println("No rooms updated.");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void setSingleRoomAsCleanByRoomID(int roomId) {
        Transaction transaction = null;
        Session session = dataSourceFactory.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            MutationQuery query = session.createMutationQuery(
                    "UPDATE Room r SET r.cleaningStatus = 'Clean' WHERE r.roomId = :roomId"
            );
            query.setParameter("roomId", roomId);
            int result = query.executeUpdate();
            if (result > 0) {
                System.out.println("Room updated as clean with ID: " + roomId);
            } else {
                System.out.println("No room found for the provided room ID.");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void setAllRoomsAtDirty(String dirty) {
        Transaction transaction = null;
        Session session = dataSourceFactory.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            MutationQuery query = session.createMutationQuery("UPDATE Room r SET r.cleaningStatus = :dirty");
            query.setParameter("dirty", dirty);
            int result = query.executeUpdate();
            if (result > 0) {
                System.out.println("All rooms updated as dirty.");
            } else {
                System.out.println("No rooms updated.");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void setSingleRoomAsDirtyByRoomID(int roomId) {
        Transaction transaction = null;
        Session session = dataSourceFactory.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            MutationQuery query = session.createMutationQuery(
                    "UPDATE Room r SET r.cleaningStatus = 'Dirty' WHERE r.roomId = :roomId"
            );
            query.setParameter("roomId", roomId);
            int result = query.executeUpdate();
            if (result > 0) {
                System.out.println("Room marked as dirty with ID: " + roomId);
            } else {
                System.out.println("No room found for the provided room ID.");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    @Override
    public void setSingleRoomAsDNDByRoomID(int roomId) {
        Transaction transaction = null;
        Session session = dataSourceFactory.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            MutationQuery query = session.createMutationQuery(
                    "UPDATE Room r SET r.roomStatus = 'DND' WHERE r.roomId = :roomId"
            );
            query.setParameter("roomId", roomId);
            int result = query.executeUpdate();
            if (result > 0) {
                System.out.println("Room marked as DND with ID: " + roomId);
            } else {
                System.out.println("No room found for the provided room ID.");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
