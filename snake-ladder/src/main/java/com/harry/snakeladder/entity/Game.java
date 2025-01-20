package com.harry.snakeladder.entity;

import com.harry.snakeladder.enums.DifficultyLevel;
import com.harry.snakeladder.strategy.EasyPlacementStrategy;
import com.harry.snakeladder.strategy.HardPlacementStrategy;
import com.harry.snakeladder.strategy.MediumPlacementStrategy;
import com.harry.snakeladder.strategy.PlacementStrategy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Game {
    private final Board board;
    private final List<Player> players;
    private final Queue<Player> winnners;
    private final Dice dice;
    private int currentPlayerIdx;
    private final int playersCount;

    public Game(int boardWidth, int playersCount, int diceCount, DifficultyLevel difficultyLevel) {
        PlacementStrategy placementStrategy = initPlacementStrategy(difficultyLevel);
        this.board = new Board(boardWidth, placementStrategy);
        this.playersCount = playersCount;
        this.players = new ArrayList<>();
        addPlayers(playersCount);
        this.winnners = new ArrayDeque<>();
        this.dice = new Dice(diceCount);
    }


    public void play() {
        boolean gameOver = false;
        while (!gameOver) {
            Player currentPlayer = getCurrentPlayer();
            int faceValue = dice.roll();
            System.out.println(currentPlayer.getName() + " rolled the dice and got " + faceValue);
            int newPosition = calculateNewPosition(currentPlayer, faceValue);
            currentPlayer.changePosition(newPosition);
            if (checkWin(newPosition)) {
                handleWin(currentPlayer);
            }

            gameOver = winnners.size() == playersCount;
            if (!gameOver) {
                switchPlayer();
            }
        }

        displayWinners();

    }

    private void displayWinners() {
        int rank = 1;
        while (!winnners.isEmpty()) {
            Player player = winnners.poll();
            System.out.println(player.getName() + " got rank " + rank++);
        }
    }

    private void switchPlayer() {
        currentPlayerIdx = (currentPlayerIdx + 1) % players.size();
    }

    private void handleWin(final Player currentPlayer) {
        winnners.add(currentPlayer);
        players.remove(currentPlayer);
    }

    private boolean checkWin(final int newPosition) {
        return newPosition == board.size();
    }

    private int calculateNewPosition(final Player currentPlayer, final int faceValue) {
        return board.getNewPosition(currentPlayer.getCurrentPosition(), faceValue);
    }

    private Player getCurrentPlayer() {
        return players.get(currentPlayerIdx);
    }


    private void addPlayers(final int playersCount) {
        for (int i = 0; i < playersCount; i++) {
            players.add(new Player("Player" + i));
        }
    }

    private PlacementStrategy initPlacementStrategy(final DifficultyLevel difficultyLevel) {
        return switch(difficultyLevel) {
            case EASY -> new EasyPlacementStrategy();
            case MEDIUM -> new MediumPlacementStrategy();
            case HARD -> new HardPlacementStrategy();
        };
    }
}
