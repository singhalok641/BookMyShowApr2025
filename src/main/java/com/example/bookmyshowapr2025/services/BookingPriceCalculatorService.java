package com.example.bookmyshowapr2025.services;

import com.example.bookmyshowapr2025.models.Show;
import com.example.bookmyshowapr2025.models.ShowSeat;
import com.example.bookmyshowapr2025.models.ShowSeatType;
import com.example.bookmyshowapr2025.repositories.ShowSeatTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingPriceCalculatorService {
    private ShowSeatTypeRepository showSeatTypeRepository;

    public BookingPriceCalculatorService(ShowSeatTypeRepository showSeatTypeRepository) {
        this.showSeatTypeRepository = showSeatTypeRepository;
    }

    public double calculatePrice(List<ShowSeat> showSeats) {
        double amount = 0.0;

        // Get the show object from one of the showseats
        Show show = showSeats.get(0).getShow();

        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShowId(show.getId());
        /*
        123 GOLD 500 - object 1
        123 SILVER 300 - object 2
        123 PLATINUM 700 - object 3
         */

        for(ShowSeat showSeat: showSeats) { // {123, A1}, {123, A2}, {123, B3}
            for(ShowSeatType showSeatType: showSeatTypes) {
                if(showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())) {
                    amount += showSeatType.getPrice();
                    break;
                }
            }
        }
        return amount;
    }
}
