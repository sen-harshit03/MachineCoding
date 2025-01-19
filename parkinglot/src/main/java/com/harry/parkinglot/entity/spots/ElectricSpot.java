package com.harry.parkinglot.entity.spots;

public class ElectricSpot extends ParkingSpot{


    @Override
    public double getCharge(final long hoursParked) {
        return 100 * hoursParked;
    }
}
