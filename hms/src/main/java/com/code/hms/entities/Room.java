package com.code.hms.entities;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "Room")
public class Room implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Room_ID")
    private int roomId;

    @Column(name = "Room_Type")
    private String roomType;

    @Column(name = "Price")
    private double price;

    @Column(name = "Room_Status")
    private String roomStatus;

    @Column(name = "Cleaning_Status")
    private String cleaningStatus;

    @Column(name = "Room_Capacity")
    private int roomCapacity;

    // No-args constructor
    public Room() {}

    // Parameterized constructor
    public Room(int roomId, String roomType, double price, String roomStatus, String cleaningStatus, int roomCapacity) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.price = price;
        this.roomStatus = roomStatus;
        this.cleaningStatus = cleaningStatus;
        this.roomCapacity = roomCapacity;
    }

    // Getters and setters
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }
    public void setRoomCleaningStatus(String cleaningStatus) {
        this.cleaningStatus = cleaningStatus;
    }

    public String getCleaningStatus() {
        return cleaningStatus;
    }

    public void setCleaningStatus(String cleaningStatus) {
        this.cleaningStatus = cleaningStatus;
    }

    public int getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(int roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + roomId;
        result = prime * result + ((roomType == null) ? 0 : roomType.hashCode());
        long temp;
        temp = Double.doubleToLongBits(price);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((roomStatus == null) ? 0 : roomStatus.hashCode());
        result = prime * result + ((cleaningStatus == null) ? 0 : cleaningStatus.hashCode());
        result = prime * result + roomCapacity;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Room other = (Room) obj;
        if (roomId != other.roomId)
            return false;
        if (roomType == null) {
            if (other.roomType != null)
                return false;
        } else if (!roomType.equals(other.roomType))
            return false;
        if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
            return false;
        if (roomStatus == null) {
            if (other.roomStatus != null)
                return false;
        } else if (!roomStatus.equals(other.roomStatus))
            return false;
        if (cleaningStatus == null) {
            if (other.cleaningStatus != null)
                return false;
        } else if (!cleaningStatus.equals(other.cleaningStatus))
            return false;
        if (roomCapacity != other.roomCapacity)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Room [Room_ID=" + roomId + ", Room_Type=" + roomType + ", Price=" + price + ", Room_Status="
                + roomStatus + ", Cleaning_Status=" + cleaningStatus + ", Room_Capacity=" + roomCapacity + "]";
    }
}
