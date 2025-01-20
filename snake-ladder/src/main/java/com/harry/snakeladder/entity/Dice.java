package com.harry.snakeladder.entity;

import java.util.Random;


public class Dice {
    private final Random random;
    private final int diceCount;

    public Dice(int diceCount) {
        this.random = new Random();
        this.diceCount = diceCount;
    }

    public int roll() {
        return random.nextInt(6 * diceCount) + 1;
    }
}
