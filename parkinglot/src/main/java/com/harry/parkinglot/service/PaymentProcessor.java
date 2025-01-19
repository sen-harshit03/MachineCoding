package com.harry.parkinglot.service;

import com.harry.parkinglot.entity.PaymentReceipt;
import com.harry.parkinglot.enums.PaymentMethod;
import com.harry.parkinglot.factory.PaymentServiceFactory;

import java.time.LocalDateTime;
import java.util.UUID;

public class PaymentProcessor {


    public PaymentReceipt processPayment(double amount, PaymentMethod paymentMethod) {
        PaymentService paymentService = PaymentServiceFactory.create(paymentMethod);
        paymentService.pay(amount);
        return PaymentReceipt.builder()
                .paymentId(UUID.randomUUID().toString())
                .amount(amount)
                .paidAt(LocalDateTime.now())
                .paymentMethod(paymentMethod)
                .build();
    }
}
