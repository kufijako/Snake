package com.snake;

import java.util.Random;

public class Point
{
    int posX;
    int posY;
    int whatToSet;

    int density = Game.grid.getDensity();
    int grid[][] = Game.grid.getGameGrid();
    Random generator = new Random();


    Point(int whatType,int x, int y)
    {
        whatToSet = whatType;
        posX = x;
        posY = y;
        show();
    }

    Point(int type)
    {

        whatToSet = type;
        chekFreeSpace();
    }

    void show()
    {
        Game.grid.setGameGrid(posX,posY,whatToSet);
        Game.grid.repaint();
    }

    void clear()
    {
        Game.grid.setGameGrid(posX,posY,0);
        Game.grid.repaint();
    }

    void randomPosition()
    {
        int x = generator.nextInt(density);
        int y = generator.nextInt(density);

        while(grid[x][y] != 0)
        {
            x = generator.nextInt(density);
            y = generator.nextInt(density);
        }

        posX = x;
        posY = y;
    }

    void chekFreeSpace()
    {
        clear();
        boolean noSpace = true;

        //sprawdzanie czy jest miejsce - jeżeli znajdzie na plaszny wartość 0 to miejsce jest
        for(int i = 0; i < density; i++)
            for(int j = 0; j < density; j++)
                if(grid[i][j] == 0)
                    noSpace = false;

        if(!noSpace)
        {
            randomPosition(); //jak nie znajdzie to losuje jeszcze raz
            show();
        }

        else
        {
            System.out.println("Wygranko!");
        }
    }
}