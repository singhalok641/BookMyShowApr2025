package com.example.bookmyshowapr2025.repositories;

import com.example.bookmyshowapr2025.models.Show;
import com.example.bookmyshowapr2025.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
    /*
    select * from show_seats where id IN (1,4,5,7,8)
     */

    @Override
    List<ShowSeat> findAllById(Iterable<Long> showSeatIds);
}
