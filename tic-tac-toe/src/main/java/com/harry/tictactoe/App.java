package com.harry.tictactoe;

import com.harry.tictactoe.entity.Game;

/**
 *
 *  Board: 3 x 3
 *  char[][] board
 *
 *  Player
 *  - playerChar(X, O)
 */

public class App 
{
    public static void main(String[] args ) {
        Game game = new Game();
        game.play();
    }
}
