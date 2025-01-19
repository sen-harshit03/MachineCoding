package com.harry.parkinglot.entity;

import com.harry.parkinglot.entity.spots.ParkingSpot;
import com.harry.parkinglot.enums.PaymentMethod;
import com.harry.parkinglot.service.PaymentProcessor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@AllArgsConstructor
public class ExitGate {
    private Integer gateId;
    private DisplayBoard displayBoard;
    private ParkingLot parkingLot;
    private PaymentProcessor paymentProcessor;

    public PaymentReceipt exitVehicle(final Ticket ticket, final PaymentMethod paymentMethod) {
        freeParkingSpot(ticket);
        return processPayment(ticket, paymentMethod);
    }

    private void freeParkingSpot(final Ticket ticket) {
        ParkingSpot spot = ticket.getParkingSpot();
        spot.unPark();
        displayBoard.update();
    }

    private PaymentReceipt processPayment(final Ticket ticket, final PaymentMethod paymentMethod) {
        double amount = calculateAmount(ticket);

        return paymentProcessor.processPayment(amount, paymentMethod);
    }

    private double calculateAmount(final Ticket ticket) {
        long durationInHours = calculateDuration(ticket);
        return ticket.getParkingSpot().getCharge(durationInHours);
    }

    private long calculateDuration(final Ticket ticket) {
        LocalDateTime issuedTime = ticket.getIssuedAt();
        LocalDateTime currentTime = LocalDateTime.now();

        long durationInMinutes = ChronoUnit.MINUTES.between(issuedTime, currentTime);
        long durationInHours = durationInMinutes / 60;
        long remainingMinutes = durationInMinutes % 60;

        if (remainingMinutes > 0) {
            durationInHours++;
        }
        return durationInHours;
    }
}
