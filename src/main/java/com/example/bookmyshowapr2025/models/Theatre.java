package com.example.bookmyshowapr2025.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Theatre extends BaseModel{
    private String name;
    private String address;
    @OneToMany
    private List<Screen> screens;
}


/*
1             m
Theatre --- Screen

 */
