package com.harry.tictactoe.entity;

public class Board {
    private char[][] board;
    private static final int SIZE = 3;

    public Board() {
        this.board = new char[SIZE][SIZE];
        initBoard();
    }

    private void initBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void display() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }


    public boolean placeCharacter(final int x, final int y, final char playerChar) {
        if (isValidMove(x, y)) {
            board[x][y] = playerChar;
            return true;
        }
        return false;
    }

    private boolean isValidMove(final int x, final int y) {
        return x >= 0 && x < SIZE && y >=0 && y < SIZE && board[x][y] == '-';
    }

    public boolean checkWin(char playerChar) {
        // check row and col
        for (int i = 0; i < SIZE; i++) {
            if ((board[i][0] == playerChar && board[i][1] == playerChar && board[i][2] == playerChar) ||
                    (board[0][i] == playerChar && board[1][i] == playerChar && board[2][i] == playerChar)) {
                return true;
            }
        }

        // check diagonal
        return (board[0][0] == playerChar && board[1][1] == playerChar && board[2][2] == playerChar) ||
                (board[0][2] == playerChar && board[1][1] == playerChar && board[2][0] == playerChar);
    }


    public int size() {
        return SIZE;
    }
}
