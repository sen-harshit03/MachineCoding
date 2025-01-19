package com.harry.parkinglot.entity;

import com.harry.parkinglot.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Vehicle {
    private String vehicleNumber;
    private VehicleType vehicleType;
}
