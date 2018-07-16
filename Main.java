package com.snake;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public class Main
{
    static Main window;
    static Game game = new Game();

    public static void main(String[] args) throws InterruptedException
    {
        window = new Main();
        game.init();

        while (true)
        {
            game.run();
        }

    }
/*

-   globalny obiekt game |DONE
    -funkcja update() w while |DONE
    -stała liczb fps |DONE
    -kilka obiektów food (pula obiektów)
 */





}
