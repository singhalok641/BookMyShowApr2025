package com.example.bookmyshowapr2025.controllers;

import com.example.bookmyshowapr2025.dtos.ResponseStatus;
import com.example.bookmyshowapr2025.dtos.UserSignUpRequestDto;
import com.example.bookmyshowapr2025.dtos.UserSignUpResponseDto;
import com.example.bookmyshowapr2025.models.User;
import com.example.bookmyshowapr2025.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public UserSignUpResponseDto signUp(@RequestBody UserSignUpRequestDto userSignUpRequestDto) {
        UserSignUpResponseDto userSignUpResponseDto = new UserSignUpResponseDto();

        User user = userService.signUp(userSignUpRequestDto.getName(),
                userSignUpRequestDto.getEmail(),
                userSignUpRequestDto.getPassword());

        userSignUpResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        userSignUpResponseDto.setName(user.getName());
        userSignUpResponseDto.setEmail(user.getEmail());

        return userSignUpResponseDto;
    }

//    public ResponseStatus login() {
//    }
}


