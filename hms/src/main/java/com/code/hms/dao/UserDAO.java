package com.code.hms.dao;

import java.util.List;

import com.code.hms.entities.Reservation;
import com.code.hms.entities.Review;
import com.code.hms.entities.User;

public interface UserDAO {
    
    // Find user by ID
    public User getUserByID(int id);
    
    // Find all users
    public List<User> getAllUsers();

    //Check login
    public int checkLogin(String username, String password);
    
    // Find users by role
    public List<User> getUsersByRole(String role);

    // Change password
    public void changePassword(int userId, String newPassword);
    
    // For Admins: Add a new user
    public void addUser(User user);

    // For Customer: Get their reservations or reviews
    public List<Reservation> getReservationsByCustomer(int customerId);
    public List<Review> getReviewsByCustomer(int customerId);

    public int getUserIDByUsername(String Username);
    public int getUserIDByPhone(String phone);

    public void saveUser(User user);

    // Common functionalities
    public void updateUser(User user);
    public void deleteUser(int userId);
}
