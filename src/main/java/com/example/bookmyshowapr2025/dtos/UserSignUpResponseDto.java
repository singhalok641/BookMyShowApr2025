package com.example.bookmyshowapr2025.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignUpResponseDto {
    private String email;
    private String name;
    private ResponseStatus responseStatus;
}
