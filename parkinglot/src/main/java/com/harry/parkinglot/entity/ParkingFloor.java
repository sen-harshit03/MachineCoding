package com.harry.parkinglot.entity;

import com.harry.parkinglot.entity.spots.ParkingSpot;
import com.harry.parkinglot.enums.ParkingSpotType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Setter
@Getter
@ToString
public class ParkingFloor {
    private String floorId;
    private List<ParkingSpot> parkingSpots;

    public  ParkingFloor(String floorId) {
        this.floorId = floorId;
        this.parkingSpots = new ArrayList<>();
    }

    public void addParkingSpot(final ParkingSpot parkingSpot) {
        parkingSpots.add(parkingSpot);
    }

    public Optional<ParkingSpot> searchAvailableSpot(final ParkingSpotType spotType) {
        return parkingSpots.stream()
                .filter(spot -> spot.getParkingSpotType().equals(spotType))
                .filter(ParkingSpot::isAvailable)
                .findFirst();
    }
}
