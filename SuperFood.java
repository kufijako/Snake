package com.snake;

public class SuperFood extends Point
{
    boolean collected = true;
    private int extraScore = 5;

    public SuperFood()
    {
        super(3);
        clear();
    }


    void turbopower()
    {
        Game.score+=extraScore;
        for(int i = 0; i <= extraScore; i++)
        {
            Game.grid.setGameGrid(posX,posY,1);
            Game.snakeBody.add(new Point(1,Game.lastX1,Game.lastY1));
        }
        collected = true;
    }

}
