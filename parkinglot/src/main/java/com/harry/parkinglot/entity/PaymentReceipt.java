package com.harry.parkinglot.entity;

import com.harry.parkinglot.enums.PaymentMethod;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class PaymentReceipt {
    private String paymentId;
    private LocalDateTime paidAt;
    private double amount;
    private PaymentMethod paymentMethod;
}
