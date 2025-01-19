package com.harry.parkinglot.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ParkingLotConfigurationDto {
    private int floorsCount;
    private ParkingFloorConfigurationDto parkingFloorConfiguration;
    private int gatesCount;

}
