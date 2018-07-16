package com.snake;

import java.util.Random;

public class SnakeHead extends Point
{

    SnakeHead() {super(4);}
    Random generator = new Random();


    void move()
    {

        clear();
        Game.lastX1 = posX;
        Game.lastY1 = posY;

            if(Game.up)
                posY--;

            if(Game.down)
                posY++;

            if(Game.left)
                posX --;

            if(Game.right)
                posX++;

        Game.swap();

        detectBorder();

        collison(Game.grid.getGameGrid());
        Game.lastX1 = posX;
        Game.lastY1 = posY;

        show();
    }

    void detectBorder()
    {
        int density = Game.grid.getDensity();

        //wyktywanie krawędzi planszy
            if(posX == density)
                posX = 0;
            if(posY == density)
                posY = 0;
            if(posX < 0)
                posX = density -1;
            if(posY < 0)
                posY = density -1;


    }

    void collison(int[][] temp)
    {


        if(temp[posX][posY] == 3 )
        {
            Game.superFood.turbopower();
            Game.speed /= 2;


        }

        else if(temp[posX][posY] == 2) //jeżeli zebrało jedzenie
        {
            if(generator.nextInt(100) > 50 && Game.superFood.collected == true)
            {
                Game.superFood.collected = false;
                Game.superFood.chekFreeSpace();
            }


            Game.foodOnGird.add(new Food());
            Game.speed = 100;

        }

        else if(temp[posX][posY] == 1)
            gameOver();
    }

    void gameOver()
    {
        Game.score = 0;
        Game.grid.clearAll();
        Game.snakeBody.clear();
        Game.lastY1 = 0;
        Game.lastY2 = 0;
        Game.lastX1 = 0;
        Game.lastX2 = 0;
        Game.speed = 100;
        clear();

        Game.left = false;
        Game.right = false;
        Game.up = false;
        Game.down = false;

        new Point(2);

        Game.superFood.collected = true;
    }
}