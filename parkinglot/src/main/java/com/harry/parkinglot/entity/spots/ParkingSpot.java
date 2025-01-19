package com.harry.parkinglot.entity.spots;


import com.harry.parkinglot.entity.Vehicle;
import com.harry.parkinglot.enums.ParkingSpotType;
import com.harry.parkinglot.enums.VehicleType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Floor - G1
 *  1, 2, 3, 4,
 */
@Setter
@ToString
@Getter
public abstract class ParkingSpot {
    protected Integer spotId;
    protected boolean available;
    protected ParkingSpotType parkingSpotType;
    protected Vehicle vehicle;


    public ParkingSpot() {
        this.vehicle = null;
        this.available = true;
    }

    public void park(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.available = false;
    }

    public void unPark() {
        this.vehicle = null;
        this.available = true;
    }

    public abstract double getCharge(long hoursParked);

}
