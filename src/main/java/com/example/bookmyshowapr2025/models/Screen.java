package com.example.bookmyshowapr2025.models;

import com.example.bookmyshowapr2025.models.enums.Feature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name="screens")
public class Screen extends BaseModel {
    private String screenName;

    @OneToMany
    @JoinColumn(name = "screen_id")
    private List<Seat> seats;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;

//    @ManyToOne
//    private Theatre theatre;
}

/*

Screen ----- Theatre => M:1

Screen ---- Seat => 1:M
 */
