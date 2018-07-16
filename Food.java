package com.snake;

public class Food extends Point
{

    Food()
    {
        super(2);
        Game.speed = 100;
        addScore();
    }

    void addScore()
    {
        Game.score++;
        Game.grid.setGameGrid(posX,posY,1);
        Game.snakeBody.add(new Point(1,Game.lastX1,Game.lastY1));
        show();
    }
}
