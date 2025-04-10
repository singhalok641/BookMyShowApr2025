package com.example.bookmyshowapr2025.dtos;

import com.example.bookmyshowapr2025.models.ShowSeat;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateBookingRequestDto {
    private Long userId;
    private List<Long> showSeatsIds;
}
