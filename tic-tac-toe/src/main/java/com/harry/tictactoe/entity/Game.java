package com.harry.tictactoe.entity;

import java.util.Scanner;

public class Game {
    private final Board board;
    private final Player[] players;
    private int currentPlayerIdx;
    private boolean gameOver = false;
    private int movesCount = 0;

    public Game() {
        this.board = new Board();
        this.players = new Player[]{new Player('X'), new Player('O')};
        this.currentPlayerIdx = 0;
    }


    public void play() {
        while (!gameOver) {
            board.display();
            Player currentPlayer = players[currentPlayerIdx];
            processPlayerMove(currentPlayer);
            gameOver = isGameOver(currentPlayer);
            if(!gameOver) {
                switchPlayer();
            }
        }
    }

    private void switchPlayer() {
        currentPlayerIdx = 1 - currentPlayerIdx;
    }

    private boolean isGameOver(Player currentPlayer) {
        return checkWin(currentPlayer) || checkTie();
    }


    private boolean checkWin(Player currentPlayer) {
        return board.checkWin(currentPlayer.getPlayerChar());
    }

    private boolean checkTie() {
        if(movesCount == board.size() * board.size()) {
            System.out.println("Match tie");
            return true;
        }
        return false;
    }

    private void processPlayerMove(final Player currentPlayer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Player " + currentPlayer.getPlayerChar() + ", enter row-col (0-2):");

        int x = scanner.nextInt();
        int y = scanner.nextInt();

        if (board.placeCharacter(x, y, currentPlayer.getPlayerChar())) {
            movesCount++;
        } else {
            System.out.println("Invalid move, try again");
            processPlayerMove(currentPlayer);
        }

    }
}
