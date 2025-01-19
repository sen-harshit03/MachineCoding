package com.harry.parkinglot.factory;

import com.harry.parkinglot.enums.PaymentMethod;
import com.harry.parkinglot.service.PaymentService;
import com.harry.parkinglot.service.impl.CardPaymentService;
import com.harry.parkinglot.service.impl.CashPaymentService;
import com.harry.parkinglot.service.impl.UPIPaymentService;

public class PaymentServiceFactory {
    public static PaymentService create(final PaymentMethod paymentMethod) {
        PaymentService paymentService = null;
        switch (paymentMethod) {
            case UPI -> paymentService = new UPIPaymentService();
            case CARD -> paymentService = new CardPaymentService();
            case CASH -> paymentService = new CashPaymentService();
        }
        return paymentService;
    }
}
