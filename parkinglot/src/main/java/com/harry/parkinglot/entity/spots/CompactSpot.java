package com.harry.parkinglot.entity.spots;

public class CompactSpot extends ParkingSpot{


    @Override
    public double getCharge(final long hoursParked) {
        return 50 * hoursParked;
    }
}
