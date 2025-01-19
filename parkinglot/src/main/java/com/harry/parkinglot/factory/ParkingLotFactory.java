package com.harry.parkinglot.factory;

import com.harry.parkinglot.dto.ParkingFloorConfigurationDto;
import com.harry.parkinglot.dto.ParkingLotConfigurationDto;
import com.harry.parkinglot.entity.DisplayBoard;
import com.harry.parkinglot.entity.EntryGate;
import com.harry.parkinglot.entity.ExitGate;
import com.harry.parkinglot.entity.ParkingFloor;
import com.harry.parkinglot.entity.ParkingLot;
import com.harry.parkinglot.entity.spots.CompactSpot;
import com.harry.parkinglot.entity.spots.ElectricSpot;
import com.harry.parkinglot.entity.spots.HandicappedSpot;
import com.harry.parkinglot.entity.spots.LargeSpot;
import com.harry.parkinglot.entity.spots.ParkingSpot;
import com.harry.parkinglot.entity.spots.TwoWheelerSpot;
import com.harry.parkinglot.enums.ParkingSpotType;
import com.harry.parkinglot.service.PaymentProcessor;

import java.util.stream.IntStream;

/**
 * int numberOf Floor,
 * Configuration of each floor
 *
 * int number of gates
 */
public class ParkingLotFactory {

    public ParkingLot create(ParkingLotConfigurationDto parkingLotConfiguration) {
        ParkingLot parkingLot = new ParkingLot();


        addFloors(parkingLot, parkingLotConfiguration);
        addGates(parkingLot, parkingLotConfiguration);

        return parkingLot;
    }

    private void addGates(final ParkingLot parkingLot, final ParkingLotConfigurationDto parkingLotConfiguration) {
        DisplayBoard displayBoard = new DisplayBoard(parkingLot);
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        IntStream.rangeClosed(1, parkingLotConfiguration.getGatesCount())
                .forEach(i -> {
                    EntryGate entryGate = new EntryGate(i, displayBoard, parkingLot);
                    ExitGate exitGate = new ExitGate(i, displayBoard, parkingLot, paymentProcessor);

                    parkingLot.addEntryGate(entryGate);
                    parkingLot.addExitGate(exitGate);
                });
        displayBoard.update();
    }

    private void addFloors(final ParkingLot parkingLot, final ParkingLotConfigurationDto parkingLotConfiguration) {
        IntStream.rangeClosed(1, parkingLotConfiguration.getFloorsCount())
                .forEach(i -> {
                    ParkingFloor floor = new ParkingFloor("G" + i);

                    addSpots(floor, parkingLotConfiguration.getParkingFloorConfiguration());
                    parkingLot.addFloor(floor);

                });
    }

    private void addSpots(final ParkingFloor floor, final ParkingFloorConfigurationDto parkingFloorConfiguration) {
        int[] spotIdCounter = new int[] {1};
        parkingFloorConfiguration.getSpotConfig().forEach((spotType, count) -> {
            IntStream.rangeClosed(1, count).forEach(i -> {
                ParkingSpot parkingSpot = ParkingSpotFactory.createSpot(spotType);
                parkingSpot.setSpotId(spotIdCounter[0]);
                spotIdCounter[0]++;
                parkingSpot.setParkingSpotType(spotType);

                floor.addParkingSpot(parkingSpot);
            });

        });
    }


}
