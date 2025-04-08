package com.example.bookmyshowapr2025.models;

import com.example.bookmyshowapr2025.models.enums.Feature;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Movie extends BaseModel {
    private String movieName;
    private double rating;
    private int durationInMinutes;
    private List<Feature> features;
}
