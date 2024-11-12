package com.code.hms.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Room")
public class Room implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "Room_ID")
    private int Room_ID;

    @Column(name = "Room_Type")
    private String Room_Type;

    @Column(name = "Price")
    private double Price;

    @Column(name = "Room_Status")
    private String Room_Status;

    @Column(name = "Cleaning_Status")
    private String Cleaning_Status;

    @Column(name = "Room_Capacity")
    private int Room_Capacity;

    public Room(int room_ID, String room_Type, double price, String room_Status, String cleaning_Status,
            int room_Capacity) {
        Room_ID = room_ID;
        Room_Type = room_Type;
        Price = price;
        Room_Status = room_Status;
        Cleaning_Status = cleaning_Status;
        Room_Capacity = room_Capacity;
    }

    public int getRoom_ID() {
        return Room_ID;
    }

    public void setRoom_ID(int room_ID) {
        Room_ID = room_ID;
    }

    public String getRoom_Type() {
        return Room_Type;
    }

    public void setRoom_Type(String room_Type) {
        Room_Type = room_Type;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getRoom_Status() {
        return Room_Status;
    }

    public void setRoom_Status(String room_Status) {
        Room_Status = room_Status;
    }

    public String getCleaning_Status() {
        return Cleaning_Status;
    }

    public void setCleaning_Status(String cleaning_Status) {
        Cleaning_Status = cleaning_Status;
    }

    public int getRoom_Capacity() {
        return Room_Capacity;
    }

    public void setRoom_Capacity(int room_Capacity) {
        Room_Capacity = room_Capacity;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Room_ID;
        result = prime * result + ((Room_Type == null) ? 0 : Room_Type.hashCode());
        long temp;
        temp = Double.doubleToLongBits(Price);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((Room_Status == null) ? 0 : Room_Status.hashCode());
        result = prime * result + ((Cleaning_Status == null) ? 0 : Cleaning_Status.hashCode());
        result = prime * result + Room_Capacity;
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
        if (Room_ID != other.Room_ID)
            return false;
        if (Room_Type == null) {
            if (other.Room_Type != null)
                return false;
        } else if (!Room_Type.equals(other.Room_Type))
            return false;
        if (Double.doubleToLongBits(Price) != Double.doubleToLongBits(other.Price))
            return false;
        if (Room_Status == null) {
            if (other.Room_Status != null)
                return false;
        } else if (!Room_Status.equals(other.Room_Status))
            return false;
        if (Cleaning_Status == null) {
            if (other.Cleaning_Status != null)
                return false;
        } else if (!Cleaning_Status.equals(other.Cleaning_Status))
            return false;
        if (Room_Capacity != other.Room_Capacity)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Room [Room_ID=" + Room_ID + ", Room_Type=" + Room_Type + ", Price=" + Price + ", Room_Status="
                + Room_Status + ", Cleaning_Status=" + Cleaning_Status + ", Room_Capacity=" + Room_Capacity + "]";
    }
}
