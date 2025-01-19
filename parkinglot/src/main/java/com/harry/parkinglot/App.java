package com.harry.parkinglot;

import com.harry.parkinglot.dto.ParkingFloorConfigurationDto;
import com.harry.parkinglot.dto.ParkingLotConfigurationDto;
import com.harry.parkinglot.entity.DisplayBoard;
import com.harry.parkinglot.entity.EntryGate;
import com.harry.parkinglot.entity.ExitGate;
import com.harry.parkinglot.entity.ParkingLot;
import com.harry.parkinglot.entity.PaymentReceipt;
import com.harry.parkinglot.entity.Ticket;
import com.harry.parkinglot.entity.Vehicle;
import com.harry.parkinglot.entity.spots.ParkingSpot;
import com.harry.parkinglot.enums.ParkingSpotType;
import com.harry.parkinglot.enums.PaymentMethod;
import com.harry.parkinglot.enums.VehicleType;
import com.harry.parkinglot.factory.ParkingLotFactory;

import java.util.LinkedHashMap;
import java.util.Map;

import static com.harry.parkinglot.enums.ParkingSpotType.COMPACT;
import static com.harry.parkinglot.enums.ParkingSpotType.LARGE;
import static com.harry.parkinglot.enums.ParkingSpotType.TWO_WHEELER;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        ParkingLotFactory parkingLotFactory = new ParkingLotFactory();
        ParkingLot parkingLot = parkingLotFactory.create(getConfiguration());
        System.out.println(parkingLot);

        EntryGate entryGate = parkingLot.getEntryGates().get(0);
        DisplayBoard displayBoard = entryGate.getDisplayBoard();
        displayBoard.display();

        System.out.println("Parking a car");
        Ticket ticket1 = entryGate.enterVehicle(new Vehicle("BH 001 DS 6520", VehicleType.CAR));
        Ticket ticket2 = entryGate.enterVehicle(new Vehicle("BH 001 DS 6520", VehicleType.CAR));
        Ticket ticket3 = entryGate.enterVehicle(new Vehicle("BH 001 DS 6520", VehicleType.CAR));
        Ticket ticket4 = entryGate.enterVehicle(new Vehicle("BH 001 DS 6520", VehicleType.CAR));
        displayBoard.display();


        ExitGate exitGate = parkingLot.getExitGates().get(1);
        PaymentReceipt paymentReceipt = exitGate.exitVehicle(ticket1, PaymentMethod.UPI);
//        displayBoard.display();

    }

    private static ParkingLotConfigurationDto getConfiguration() {
        ParkingLotConfigurationDto parkingLotConfiguration = new ParkingLotConfigurationDto();
        parkingLotConfiguration.setFloorsCount(3);
        parkingLotConfiguration.setGatesCount(2);

        ParkingFloorConfigurationDto floorConfiguration = new ParkingFloorConfigurationDto();
        Map<ParkingSpotType, Integer> spotConfig = new LinkedHashMap<>();
        spotConfig.put(TWO_WHEELER, 5);
        spotConfig.put(COMPACT, 1);
        spotConfig.put(LARGE, 3);
        floorConfiguration.setSpotConfig(spotConfig);
        parkingLotConfiguration.setParkingFloorConfiguration(floorConfiguration);

        return parkingLotConfiguration;
    }
}
