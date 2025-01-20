package com.harry.snakeladder.entity;


import lombok.Getter;

@Getter
public class Player {
    private String name;
    private int currentPosition;

    public Player(final String name) {
        this.name = name;
    }

    public void changePosition(final int newPosition) {
        currentPosition = newPosition;
    }
}
