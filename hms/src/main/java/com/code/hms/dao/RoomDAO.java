package com.code.hms.dao;

import java.util.List;

import com.code.hms.entities.Room;

public interface RoomDAO {
	// Find room by room number
	public Room getRoomByRoomID(int roomId);

	// Find  all available rooms
	public List<Room> getAllAvailableRooms();

	public List<Room> getAllDirtyRooms();
	
	// Save to database
	public void saveRoom(Room room);
	
	// Update the status of room (clean or not)
	public void updateRoom(Room room);
	
	// Show all the room (including both empty and not empty)
	public List<Room> getAllRooms();

	String getRoomStatus(int roomId);

	String getRoomCleaningStatus(int roomId);

	void setRoomCleaned(int roomId);

	void setRoomUncleaned(int roomId);

	// Set room availability after check out
	public void setRoomCheckedOut(int roomId);

	void setRoomCheckedIn(int roomId);

    // Set Clean
	public void setAllRoomsAtClean(String clean);
	public void setSingleRoomAsCleanByRoomID(int roomId);
	
	// Set Dirty
	public void setAllRoomsAtDirty(String dirty);
	public void setSingleRoomAsDirtyByRoomID(int roomId);

	// Set DND
	public void setSingleRoomAsDNDByRoomID(int roomId);
	
}