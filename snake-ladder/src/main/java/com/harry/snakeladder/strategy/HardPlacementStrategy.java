package com.harry.snakeladder.strategy;

import java.util.Random;

public class HardPlacementStrategy extends PlacementStrategy {

    public HardPlacementStrategy() {
        this.laddersPercentage = 0.05;
        this.snakesPercentage = 0.10;
        this.random = new Random();
    }

}
