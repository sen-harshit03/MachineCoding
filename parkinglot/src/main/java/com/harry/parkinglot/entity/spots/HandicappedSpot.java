package com.harry.parkinglot.entity.spots;

public class HandicappedSpot extends ParkingSpot {


    @Override
    public double getCharge(final long hoursParked) {
        return 10 * hoursParked;
    }
}
