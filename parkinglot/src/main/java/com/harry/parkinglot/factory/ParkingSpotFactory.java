package com.harry.parkinglot.factory;

import com.harry.parkinglot.entity.spots.CompactSpot;
import com.harry.parkinglot.entity.spots.ElectricSpot;
import com.harry.parkinglot.entity.spots.HandicappedSpot;
import com.harry.parkinglot.entity.spots.LargeSpot;
import com.harry.parkinglot.entity.spots.ParkingSpot;
import com.harry.parkinglot.entity.spots.TwoWheelerSpot;
import com.harry.parkinglot.enums.ParkingSpotType;

public class ParkingSpotFactory {
    public static ParkingSpot createSpot(final ParkingSpotType spotType) {
        ParkingSpot spot = null;
        switch (spotType) {
            case LARGE -> spot = new LargeSpot();
            case COMPACT -> spot = new CompactSpot();
            case TWO_WHEELER -> spot = new TwoWheelerSpot();
            case ELECTRIC ->  spot = new ElectricSpot();
            case HANDICAPPED -> spot = new HandicappedSpot();
        }
        return spot;
    }
}
