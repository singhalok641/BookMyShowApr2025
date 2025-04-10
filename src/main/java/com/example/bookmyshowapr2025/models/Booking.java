package com.example.bookmyshowapr2025.models;

import com.example.bookmyshowapr2025.models.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name = "bookings")
public class Booking extends BaseModel{
    @ManyToOne
    private User user;

    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;

    private double amount;

    @OneToMany
    private List<ShowSeat> showSeats;

    @OneToMany
    private List<Payment> payments;
    private Date bookedAt;
}

/*
  1             1
Booking ----- User =>  M:1
  M             1

  1             M
Booking ---- ShowSeat => 1:M
  1             1

  1               M
Booking ------- Payment => 1:M
  1              1
 */
