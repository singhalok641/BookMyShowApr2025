package com.example.bookmyshowapr2025.models;

import com.example.bookmyshowapr2025.models.enums.Feature;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Screen extends BaseModel {
    private String screenName;

    @OneToMany
    private List<Seat> seats;

    private List<Feature> features;

    @ManyToOne
    private Theatre theatre;
}

/*

Screen ----- Theatre => M:1

Screen ---- Seat => 1:M
 */
