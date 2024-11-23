package com.code.hms.dao;

import java.util.List;
import com.code.hms.entities.Room;

public interface RoomDAO {
	// Find room by room number
	public Room getRoomByRoomID(int roomId);

	// Find  all available rooms
	public List<Room> getAllAvailableRooms();
	
	// Save to database
	public void saveRoom(Room room);
	
	// Update the status of room (clean or not)
	public void updateRoom(Room room);
	
	// Show all the room (including both empty and not empty)
	public List<Room> getAllRooms();

	// Set room availability after check out
	public void setRoomCheckedOut(int reservationId);

	// Set Clean
	public void setAllRoomsAtClean(String clean);
	public void setSingleRoomAsCleanByRoomID(int roomId);
	
	// Set Dirty
	public void setAllRoomsAtDirty(String dirty);
	public void setSingleRoomAsDirtyByRoomID(int roomId);

	// Set DND
	public void setSingleRoomAsDNDByRoomID(int roomId);
}