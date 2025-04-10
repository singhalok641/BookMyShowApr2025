package com.example.bookmyshowapr2025.services;

import com.example.bookmyshowapr2025.models.Booking;
import com.example.bookmyshowapr2025.models.ShowSeat;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookingService {

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking createBooking(Long userId, List<Long> showSeatIds) {
        /*
        1. Fetch the user from userId
        2. if the user is not found, then we throw an exception
        3. Fetch the ShowSeat objects from the database
        4. Check if the showSeats are available
        5.
         */

    }

}
