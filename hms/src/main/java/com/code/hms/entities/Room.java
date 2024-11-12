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

    
}
