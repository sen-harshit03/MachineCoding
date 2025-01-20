package com.harry.snakeladder.strategy;

import java.util.Random;

public class EasyPlacementStrategy extends PlacementStrategy {

    public EasyPlacementStrategy() {
        this.laddersPercentage = 0.10;
        this.snakesPercentage = 0.05;
        this.random = new Random();
    }

}
