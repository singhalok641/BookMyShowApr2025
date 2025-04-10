package com.example.bookmyshowapr2025.models;

import com.example.bookmyshowapr2025.models.enums.Feature;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name="movies")
public class Movie extends BaseModel {
    private String movieName;
    private double rating;
    private int durationInMinutes;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;
}
