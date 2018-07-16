package com.snake;

import javax.swing.*;
import java.awt.*;

public class Grid extends JPanel
{
    private int density =25;
    private int margin = 100;
    private int gameGrid[][] = new int[density][density];
    private Font font = new Font("Arial", Font.PLAIN,50);

    public int getDensity()
    {
        return density;
    }

    public int[][] getGameGrid()
    {
        return gameGrid;
    }

    public void setGameGrid(int i, int j, int whatToSet)
    {
         gameGrid[i][j] = whatToSet;
    }

    void clearAll()
    {
        for(int i = 0; i < density; i++)
            for(int j = 0; j < density; j++)
                gameGrid[i][j] = 0;

        repaint();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int rectSize = (getWidth()-margin)/density;

        g.setColor(Color.white);
        g.setFont(font);

        g.drawLine(getWidth() - margin,0,getWidth() - margin, getHeight());
        g.drawString(Integer.toString(Game.score),getWidth() - margin+10,50);

        for(int i = 0; i < density; i++)
        {
            for(int j = 0; j < density; j++)
            {

                if(gameGrid[i][j] == 1) //ciało snake
                {
                    g.setColor(Color.CYAN);
                    g.fillRect(i*rectSize, j*rectSize,rectSize,rectSize);
                }

                if(gameGrid[i][j] == 2) //jedzienie normalne
                {
                    g.setColor(Color.PINK);
                    g.fillRect(i*rectSize, j*rectSize,rectSize,rectSize);
                }


                if(gameGrid[i][j] == 3) //jedzienie super
                {
                    g.setColor(Color.ORANGE);
                    g.fillRect(i*rectSize, j*rectSize,rectSize,rectSize);
                }

                if(gameGrid[i][j] == 4) //głowa
                {
                    g.setColor(Color.red);
                    g.fillRect(i*rectSize, j*rectSize,rectSize,rectSize);
                }
            }
        }
    }
}
