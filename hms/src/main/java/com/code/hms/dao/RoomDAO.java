package com.code.hms.dao;

import java.util.List;
import com.code.hms.entities.Room;

public interface RoomDAO {
	// Find room by room number
	public Room getRoomByRoomNumber(String roomNumber);

	// Find  all available rooms
	public List<Room> getAllAvailableRooms();
	
	// Save to database
	public void saveRoom(Room room);
	
	// Update the status of room (clean or not)
	public void updateRoom(Room room);
	
	// Show all the room (including both empty and not empty)
	public List<Room> getAllRooms();

	// Find room by entering reservation id
	public Room getRoomByReserveId(long id);

	// Set room empty after check out
	public void setRoomCheckedOut(String num);

	// Set Clean
	public void setAllRoomsAtClean(String clean);
	public void setSingleRoomAsCleanByRoomNumber(String rowData);
	
	// Set Dirty
	public void setAllRoomsAtDirty(String dirty);
	public void setSingleRoomAsDirtyByRoomNumber(String roomNumber);

	// Set DND
	public void setSingleRoomAsDNDByRoomNumber(String roomNumber);
}