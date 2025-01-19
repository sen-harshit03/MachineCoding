package com.harry.parkinglot.entity.spots;

public class TwoWheelerSpot extends ParkingSpot{


    @Override
    public double getCharge(final long hoursParked) {
        return 20 * hoursParked;
    }
}
