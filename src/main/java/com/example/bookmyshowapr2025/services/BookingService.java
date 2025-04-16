package com.example.bookmyshowapr2025.services;

import com.example.bookmyshowapr2025.exceptions.ShowSeatNotAvailableException;
import com.example.bookmyshowapr2025.exceptions.UserNotFoundException;
import com.example.bookmyshowapr2025.models.Booking;
import com.example.bookmyshowapr2025.models.ShowSeat;

import com.example.bookmyshowapr2025.models.User;
import com.example.bookmyshowapr2025.models.enums.BookingStatus;
import com.example.bookmyshowapr2025.models.enums.ShowSeatStatus;
import com.example.bookmyshowapr2025.repositories.BookingRespository;
import com.example.bookmyshowapr2025.repositories.ShowSeatRepository;
import com.example.bookmyshowapr2025.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private UserRepository userRepository;
    private ShowSeatRepository showSeatRepository;
    private BookingPriceCalculatorService bookingPriceCalculatorService;
    private BookingRespository bookingRespository;

    public BookingService(UserRepository userRepository,
                          ShowSeatRepository showSeatRepository,
                          BookingPriceCalculatorService bookingPriceCalculatorService,
                          BookingRespository bookingRespository) {
        this.userRepository = userRepository;
        this.showSeatRepository = showSeatRepository;
        this.bookingPriceCalculatorService = bookingPriceCalculatorService;
        this.bookingRespository = bookingRespository;
    }

    /*
    1. Fetch the user from userId
    2. if the user is not found, then we throw an exception
    3. Fetch the ShowSeat objects from the database
    4. Check if the showSeats are available
    5. If available, you will block the seats
    6. Calculate the entire amount for the booking done
    7. Create a Booking for that particular user and return the booking back to the client
     */
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking createBooking(Long userId, List<Long> showSeatIds) throws UserNotFoundException, ShowSeatNotAvailableException {
        Optional<User> optionalUser = userRepository.findById(userId);

        /*
        You want the caller to recover from this failure or take some action
         */
        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("User with id:" + userId + "not found");
        }

        User user = optionalUser.get();

        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);

        for(ShowSeat showSeat: showSeats) {
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                // Cannot book this show
                throw new ShowSeatNotAvailableException("ShowSeat with showId:" +
                        showSeat.getShow().getId() + "and seatId:" +
                        showSeat.getSeat().getSeatNumber() + "is not available"
                );
            }
        }

        for (ShowSeat showSeat : showSeats) {
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            showSeatRepository.save(showSeat);
        }

        Booking booking = new Booking();
        booking.setShowSeats(showSeats);
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setUser(user);
        booking.setAmount(bookingPriceCalculatorService.calculatePrice(showSeats));

        return bookingRespository.save(booking);
    }
}
