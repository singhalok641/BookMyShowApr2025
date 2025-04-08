package com.example.bookmyshowapr2025.models;

import com.example.bookmyshowapr2025.models.enums.PaymentMode;
import com.example.bookmyshowapr2025.models.enums.PaymentStatus;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel{
    private String referenceId;
    private double amount;
    private PaymentMode paymentMode;
    private PaymentStatus paymentStatus;
}
