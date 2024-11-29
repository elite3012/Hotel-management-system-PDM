package com.code.hms.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;

import com.code.hms.connection.DataSourceFactory;
import com.code.hms.dao.UserDAO;
import com.code.hms.entities.Reservation;
import com.code.hms.entities.Review;
import com.code.hms.entities.User;


public class UserDaoImpl implements UserDAO {

    private DataSourceFactory dsf = new DataSourceFactory();
    private Session session;
    
    public UserDaoImpl() {
        dsf.createConnection();
    }

    @Override
    public User getUserByID(int id) {
        User user = null;
        session = dsf.getSessionFactory().openSession();

        try {
            user = session.get(User.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = null;
        session = dsf.getSessionFactory().openSession();

        try {
            userList = session.createQuery("from User", User.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return userList;
    }

    @Override
    public List<User> getUsersByRole(String role) {
        List<User> userList = null;
        session = dsf.getSessionFactory().openSession();

        try {
            userList = session.createQuery("from User u where u.role = :role", User.class)
            .setParameter("role", role).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return userList;
    }

    @Override
    public void changePassword(int userId, String newPassword) {
        session = dsf.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            MutationQuery query = session.createMutationQuery("update User u set u.password = :password where u.userId = :userId");
            query.setParameter("userId", userId);
            query.setParameter("password", newPassword);
            int result = query.executeUpdate();

            if (result == 0) {
                System.out.println("Cannot change password for user: " + userId);
            } else System.out.println("Changed password for user: " + userId);

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
    public void addUser(User user) {
        session = dsf.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            session.persist(user);
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
    public List<Reservation> getReservationsByCustomer(int customerId) {
        List<Reservation> reservationList = null;
        session = dsf.getSessionFactory().openSession();

        try {
            String query = "from Reservation r where r.userId = :customerId";
            
            reservationList = session.createSelectionQuery(query, Reservation.class).
            setParameter("customerId", customerId).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return reservationList;
    }

    @Override
    public List<Review> getReviewsByCustomer(int customerId) {
        List<Review> reviewList = null;
        session = dsf.getSessionFactory().openSession();

        try {
            //Does not check role
            String query = "from Review r where r.reservationId in "
            + "(select r.reservationId from Reservation r where r.userid = :customerId)";
            
            reviewList = session.createSelectionQuery(query, Review.class).
            setParameter("customerId", customerId).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return reviewList;
    }

    @Override
    public void updateUser(User user) {
        session = dsf.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            session.merge(user);
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
    public void deleteUser(int userId) {
        session = dsf.getSessionFactory().openSession();
        
        try {
            session.beginTransaction();
            MutationQuery query = session.createMutationQuery("delete from user u where u.userId = :userId");
            query.setParameter("userId", userId);
            int result = query.executeUpdate();

            if (result == 0) {
                System.out.println(result + " user has been deleted.");
            } else System.out.println("User " + userId + " has been deleted.");

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
    public int checkLogin(String username, String password) {
        session = dsf.getSessionFactory().openSession();
        int userId = 0;

        try {
            Query<Integer> query = session.createQuery("Select u.userId from User u where u.username = :username and password = :password", int.class);
            query.setParameter("username", username);
            query.setParameter("password", password);
            userId = query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return userId;
    }

    @Override
    public User getUserByUsername(String username) {
    session = dsf.getSessionFactory().openSession();
    User user = null;

    try {
        // Truy vấn để lấy đối tượng User dựa trên username
        Query<User> query = session.createQuery("from User u where u.username = :username", User.class);
        query.setParameter("username", username);
        user = query.uniqueResult();  // Trả về một đối tượng User nếu tìm thấy
        
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        session.close();
    }

    return user;
    }

}
