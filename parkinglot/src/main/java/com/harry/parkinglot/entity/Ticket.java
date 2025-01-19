package com.harry.parkinglot.entity;

import com.harry.parkinglot.entity.spots.ParkingSpot;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class Ticket {
    private String ticketId;
    private LocalDateTime issuedAt;
    private ParkingSpot parkingSpot;
}
