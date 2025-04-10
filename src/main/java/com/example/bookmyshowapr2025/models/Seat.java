package com.example.bookmyshowapr2025.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="seats")
public class Seat extends BaseModel{
    private String seatNumber;
    private int rowVal;
    private int colVal;

    @ManyToOne
    private SeatType seatType;
}

/*

Seat ----- SeatType =>

 */
