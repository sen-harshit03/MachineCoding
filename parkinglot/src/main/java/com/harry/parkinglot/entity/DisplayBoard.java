package com.harry.parkinglot.entity;

import com.harry.parkinglot.entity.spots.ParkingSpot;
import com.harry.parkinglot.enums.ParkingSpotType;

import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * COMPACT
 * G1 - 3
 * G2 - 3
 * G3 - 3
 *
 * floorId, count
 */
public class DisplayBoard {
    private ParkingLot parkingLot;
    private Map<ParkingSpotType, Map<String, Integer>> availableSpotsByFloors;

    public DisplayBoard(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        this.availableSpotsByFloors = new EnumMap<>(ParkingSpotType.class);
    }


    public void update() {
        availableSpotsByFloors.clear();

        for (ParkingFloor floor : parkingLot.getParkingFloors()) {
            floor.getParkingSpots().stream()
                    .filter(ParkingSpot::isAvailable)
                    .forEach(spot -> {
                        availableSpotsByFloors.computeIfAbsent(spot.getParkingSpotType(), k -> new LinkedHashMap<>())
                                .merge(floor.getFloorId(), 1, Integer::sum);
                    });
        }
    }

    public void display() {
        System.out.println("Available spots: ");
        availableSpotsByFloors.forEach((spotType, floorMap) -> {
            System.out.println("Spot Type: " + spotType);
            floorMap.forEach((floorId, count) -> System.out.println(floorId + " " + count));
        });
    }
}
