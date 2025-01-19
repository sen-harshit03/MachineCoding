package com.harry.parkinglot.service.impl;

import com.harry.parkinglot.service.PaymentService;

public class CardPaymentService implements PaymentService {
    @Override
    public void pay(final double amount) {
        System.out.println("Payed " +  amount + " through card");
    }
}
