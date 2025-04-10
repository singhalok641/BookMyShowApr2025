package com.example.bookmyshowapr2025.models;

import com.example.bookmyshowapr2025.models.enums.PaymentMode;
import com.example.bookmyshowapr2025.models.enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="payments")
public class Payment extends BaseModel{
    private String referenceId;
    private double amount;

    @Enumerated(EnumType.ORDINAL)
    private PaymentMode paymentMode;

    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;
}
