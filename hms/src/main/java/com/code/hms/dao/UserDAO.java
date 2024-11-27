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
    
    // Find users by role
    public List<User> getUsersByRole(String role);

    // Specific functionalities for each role
    
    // For Admins: Add a new user
    public void addUser(User user);
    
    // For Housekeepers: Get assigned rooms for cleaning
    public List<Integer> getAssignedRoomsForHousekeeper(int housekeeperId);

    // For Customer: Get their reservations or reviews
    public List<Reservation> getReservationsByCustomer(int customerId);
    public List<Review> getReviewsByCustomer(int customerId);
    
    // Common functionalities
    public void updateUser(User user);
    public void deleteUser(int userId);
}
