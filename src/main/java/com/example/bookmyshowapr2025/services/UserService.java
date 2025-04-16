package com.example.bookmyshowapr2025.services;

import com.example.bookmyshowapr2025.models.User;
import com.example.bookmyshowapr2025.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User signUp(String name, String email, String password) {
        Optional<User> optionalUser = userRepository.findByEmail(email);

        if(optionalUser.isPresent()) {
            // User with the given email is already present
            // Ask them to try to login
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);
//        user.setPassword(password);

        return userRepository.save(user);
    }
}
