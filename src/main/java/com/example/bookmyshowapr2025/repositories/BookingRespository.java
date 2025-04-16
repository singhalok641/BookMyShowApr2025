package com.example.bookmyshowapr2025.repositories;

import com.example.bookmyshowapr2025.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRespository extends JpaRepository<Booking, Long> {

}
