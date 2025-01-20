package com.harry.snakeladder.strategy;

import java.util.Random;

public class MediumPlacementStrategy extends PlacementStrategy {

    public MediumPlacementStrategy() {
        this.snakesPercentage = 0.8;
        this.laddersPercentage = 0.10;
        this.random = new Random();
    }
}
