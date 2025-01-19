package com.harry.parkinglot.entity;

import com.harry.parkinglot.entity.spots.ParkingSpot;
import com.harry.parkinglot.enums.ParkingSpotType;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Optional;
import java.util.UUID;

import static com.harry.parkinglot.enums.VehicleType.CAR;

@Getter
public class EntryGate {
    private Integer gateId;
    private DisplayBoard displayBoard;
    private ParkingLot parkingLot;

    public EntryGate(Integer gateId, DisplayBoard displayBoard, ParkingLot parkingLot) {
        this.gateId = gateId;
        this.displayBoard = displayBoard;
        this.parkingLot = parkingLot;
    }


    public Ticket enterVehicle(final Vehicle vehicle) {

        ParkingSpot spot = parkingLot.searchAvailableSpot(vehicle)
                .orElseThrow(() -> new RuntimeException("No available parking spot found for " + vehicle.getVehicleType()));

        spot.park(vehicle);
        displayBoard.update();
        return generateTicket(spot);
    }

    private Ticket generateTicket(final ParkingSpot spot) {
        return Ticket.builder()
                .ticketId(UUID.randomUUID().toString())
//                .issuedAt(LocalDateTime.now())
                .issuedAt(LocalDateTime.of(LocalDate.of(2025, Month.JANUARY, 18), LocalTime.of(20, 00)))
                .parkingSpot(spot)
                .build();
    }


}
