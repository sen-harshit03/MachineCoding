package com.harry.snakeladder.entity;

import com.harry.snakeladder.strategy.PlacementStrategy;

public class Board {
    private final int[] board;
    private final int boardWidth;
    private final int size;
    private final PlacementStrategy placementStrategy;


    public Board(int boardWidth, PlacementStrategy placementStrategy) {
        this.boardWidth = boardWidth;
        this.size = boardWidth * boardWidth;
        this.board = new int[size + 1];
        this.placementStrategy = placementStrategy;
        initBoard();
        placementStrategy.placeSnakesAndLadders(board);
    }


    private void initBoard() {
        for (int i = 1; i < board.length; i++) {
            board[i] = i;
        }
    }


    public int getNewPosition(int currentPosition, int faceValue) {
        int newPosition = currentPosition + faceValue; // 100
        if (newPosition > size) {
            newPosition = currentPosition;
        }

        return newPosition;
    }


    public int size() {
        return size;
    }
}
