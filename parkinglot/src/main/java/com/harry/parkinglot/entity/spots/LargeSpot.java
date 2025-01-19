package com.harry.parkinglot.entity.spots;

public class LargeSpot extends ParkingSpot {

    @Override
    public double getCharge(final long hoursParked) {
        return 80 * hoursParked;
    }
}
