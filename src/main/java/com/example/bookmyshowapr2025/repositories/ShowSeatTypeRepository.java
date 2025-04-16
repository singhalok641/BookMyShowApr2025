package com.example.bookmyshowapr2025.repositories;

import com.example.bookmyshowapr2025.models.Show;
import com.example.bookmyshowapr2025.models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType, Long> {
    /*
     select * from show_seat_type where show_id = 123

     123 GOLD 500
     123 SILVER 300
     123 PLATINUM 700
     */
    public List<ShowSeatType> findAllByShowId(Long showId);
}
