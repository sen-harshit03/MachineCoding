package com.harry.parkinglot.service.impl;

import com.harry.parkinglot.service.PaymentService;

public class UPIPaymentService implements PaymentService {
    @Override
    public void pay(final double amount) {
        System.out.println("Payed " +  amount + " through UPI");
    }
}
