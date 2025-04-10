package com.example.bookmyshowapr2025.dtos;

import com.example.bookmyshowapr2025.models.Booking;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBookingResponseDto {
    private Booking booking;
    private ResponseStatus responseStatus;
}
