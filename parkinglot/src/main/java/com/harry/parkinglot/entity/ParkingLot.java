package com.harry.parkinglot.entity;

import com.harry.parkinglot.entity.spots.ParkingSpot;
import com.harry.parkinglot.enums.ParkingSpotType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@ToString
public class ParkingLot {
    private List<ParkingFloor> parkingFloors;
    private List<EntryGate> entryGates;
    private List<ExitGate> exitGates;

    public ParkingLot() {
        this.entryGates = new ArrayList<>();
        this.exitGates = new ArrayList<>();
        this.parkingFloors = new ArrayList<>();
    }

    public void addFloor(final ParkingFloor floor) {
        parkingFloors.add(floor);
    }

    public void addEntryGate(final EntryGate entryGate) {
        entryGates.add(entryGate);
    }

    public void addExitGate(final ExitGate exitGate) {
        exitGates.add(exitGate);
    }

    public Optional<ParkingSpot> searchAvailableSpot(final Vehicle vehicle) {
        ParkingSpotType spotType = mapVehicleToSpotType(vehicle);
        for (ParkingFloor floor : parkingFloors) {
            Optional<ParkingSpot> parkingSpotOptional = floor.searchAvailableSpot(spotType);
            if(parkingSpotOptional.isPresent()) return parkingSpotOptional;
        }
        return Optional.empty();
    }

    private ParkingSpotType mapVehicleToSpotType(final Vehicle vehicle) {
        ParkingSpotType spotType = null;
        switch (vehicle.getVehicleType()) {
            case CAR -> spotType = ParkingSpotType.COMPACT;
            case BIKE -> spotType = ParkingSpotType.TWO_WHEELER;
            case VAN -> spotType = ParkingSpotType.LARGE;
            case ELECTRIC -> spotType = ParkingSpotType.ELECTRIC;
        }
        return spotType;
    }
}
