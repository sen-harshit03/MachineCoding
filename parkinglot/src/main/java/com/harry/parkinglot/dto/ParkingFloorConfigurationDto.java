package com.harry.parkinglot.dto;

import com.harry.parkinglot.enums.ParkingSpotType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * COMPACT - 5
 * LARGE -5
 *  TWOWHEELER-10
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParkingFloorConfigurationDto {
    Map<ParkingSpotType, Integer> spotConfig = new LinkedHashMap<>();
}
