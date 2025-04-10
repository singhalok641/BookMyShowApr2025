package com.example.bookmyshowapr2025.models;

import com.example.bookmyshowapr2025.models.enums.Feature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name = "shows")
public class Show extends BaseModel{
    private Date startTime;
    private Date endTime;

    @ManyToOne
    private Screen screen;

    @ManyToOne
    private Movie movie;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;
}

/*
 1         1
Show --- Movie => M:1
 M         1

  1           1
 Show ----- Screen => M:1
  M           1
 */
