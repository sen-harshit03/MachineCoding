package com.harry.snakeladder.strategy;

import java.util.Random;

public abstract class PlacementStrategy {
    protected double laddersPercentage;
    protected double snakesPercentage;
    protected Random random;

    public void placeSnakesAndLadders(int[] board) {
        placeLadders(board);
        placeSnakes(board);
    }

    public void placeLadders(int[] board) {
        int size = board.length - 1;
        int boardWidth = (int) Math.sqrt(size);
        int laddersCount = getLaddersCount(size);

        for (int i = 0; i < laddersCount; i++) {
            while (true) {
                int start = random.nextInt(size - boardWidth - 2) + 2;     // 88
                int nextRowStart = ((start / boardWidth) + 1) * boardWidth;
                int end = random.nextInt(size - nextRowStart - 1 + nextRowStart);  // 88 / 10 = 8 + 1 = 9 +

                if (board[start + 1] == board[start] + 1 && board[end + 1] == board[end] + 1) {
                    board[start] = board[end];
                    break;
                }
            }
        }
    }


    public void placeSnakes(int[] board) {
        int size = board.length - 1;
        int boardWidth = (int) Math.sqrt(size);
        int snakesCount = getSnakesCount(size);

        for (int i = 0; i < snakesCount; i++) {
            while (true) {
                int head = random.nextInt(size - 2 - (size / boardWidth) - 1) + (size / boardWidth)  + 1;
                int tail = random.nextInt((size / boardWidth) * boardWidth - 2) + 2;

                if (board[head + 1] == board[head] + 1 && board[tail + 1] == board[tail] + 1) {
                    board[head] = board[tail];
                    break;
                }
            }
        }
    }


    private int getLaddersCount(final int size) {
        return (int) (size * laddersPercentage);
    }


    private int getSnakesCount(final int size) {
        return (int) (size * snakesPercentage);
    }

}
