package com.example.bookmyshowapr2025.models;

import com.example.bookmyshowapr2025.models.enums.ShowSeatStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel{
    @ManyToOne
    private Show show;
    @ManyToOne
    private Seat seat;
    private ShowSeatStatus showSeatStatus;
}


/*
ShowSeat ------ Show => M:1

S1A1      --- s1, s2, s3
S1A2
S2A1
S2A2
S3B1
S3A1

ShowSeat ------- Seat => M:1

S1A1      --- A1, B1, A2
S1A2
S2A1
S2A2
S3B1
S3A1
 */