package com.harry.snakeladder;

import com.harry.snakeladder.entity.Game;
import com.harry.snakeladder.enums.DifficultyLevel;

/**
 *
 * Board - cells filled with number int[]
 *
 * ladder - start, end -> promotion at a cell -> board[start] = board[end]
 * snake - head, tail -> demotion from a cell -> board[head] = board[tail]
 *
 * Player
 * name, currentPosition
 *
 * ladder start at 13, then ladder ends at 45
 * board[13] = board[45] = 45;
 *
 * snakes head at 65, then snake's tail at 16
 * board[65] = board[16] = 16;
 *
 * snakes and ladder should be prepopulated on the board. Here we can have multiple strategies of placing them
 * on the board.
 * eg. RandomPlacement, OnePerRow,
 *
 * Game
 */
public class App 
{
    public static void main(String[] args)
    {
        Game game = new Game(10, 4, 1, DifficultyLevel.EASY);
        game.play();
    }
}
