package com.example.bookmyshowapr2025.controllers;


import com.example.bookmyshowapr2025.dtos.CreateBookingRequestDto;
import com.example.bookmyshowapr2025.dtos.CreateBookingResponseDto;
import com.example.bookmyshowapr2025.dtos.ResponseStatus;
import com.example.bookmyshowapr2025.models.Booking;
import com.example.bookmyshowapr2025.models.ShowSeat;
import com.example.bookmyshowapr2025.models.User;
import com.example.bookmyshowapr2025.services.BookingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public CreateBookingResponseDto createBooking(@RequestBody CreateBookingRequestDto requestDto) {
        CreateBookingResponseDto responseDto = new CreateBookingResponseDto();

        Booking booking = null;

        booking = bookingService.createBooking(
                requestDto.getUserId(),
                requestDto.getShowSeatsIds()
        );

        responseDto.setBooking(booking);
        responseDto.setResponseStatus(ResponseStatus.SUCCESS);

        if(booking == null) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }
}
