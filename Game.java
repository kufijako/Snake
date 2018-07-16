package com.snake;
import java.awt.*;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Game extends JFrame implements KeyListener
{

    static int score = 0;
    static int lastX1 = 0;
    static int lastX2 = 0;
    static int lastY1 = 0;
    static int lastY2 = 0;
    static int speed = 100;

    //zmienne związane ze stałą ilością fps
    double frameCap = 1.0/60.0;
    double time = System.nanoTime();;
    double time2 = 0.0;
    double unprocessd = 0;
    double passed = 0.0;

    boolean running = true;
    static boolean left = false;
    static boolean right = false;
    static boolean up = false;
    static boolean down = false;
    static ArrayList<Point> snakeBody = new ArrayList<Point>(1);
    static ArrayList<Food> foodOnGird = new ArrayList<Food>(1);

    static Food food;
    static SnakeHead snakeHead;
    static SuperFood superFood;
    static Grid grid;

    void run() throws InterruptedException
    {


        time2 = System.nanoTime();
        passed = time2 - time;
        unprocessd +=passed;
        time = time2;

            while(unprocessd >= frameCap)
            {
               unprocessd-= frameCap;

                Thread.sleep(1);
                while(running)
                {
                    snakeHead.move();
                    Thread.sleep(speed);

                }

            }

    }

    public static void swap() {
        for (Point p : snakeBody) {

            lastX2 = p.posX;
            lastY2 = p.posY;

            p.clear();
            p.posY = lastY1;
            p.posX = lastX1;

            lastX1 = lastX2;
            lastY1 = lastY2;

            p.show();
            grid.repaint();
        }
        grid.repaint();
    }


    void init()
    {
        grid = new Grid();
        grid.setBackground(Color.darkGray);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Snake");
        setResizable(false);
        setSize(700,600);

        add(grid);
        addKeyListener(this);
        setVisible(true);
        grid.clearAll();


        snakeHead = new SnakeHead();
        superFood = new SuperFood();
        foodOnGird.add(new Food());

    }


    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_UP && !down) {
            up = true;
            down = false;
            right = false;
            left = false;
        }

        if (keyCode == KeyEvent.VK_DOWN && !up) {
            up = false;
            down = true;
            right = false;
            left = false;

        }

        if (keyCode == KeyEvent.VK_LEFT && !right) {
            up = false;
            down = false;
            right = false;
            left = true;
        }

        if (keyCode == KeyEvent.VK_RIGHT && !left) {
            up = false;
            down = false;
            right = true;
            left = false;
        }

        if(keyCode == KeyEvent.VK_SPACE)
        {
            running = !running;
            //System.out.println("Pauza - stan running : " + running);
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {/* nie używam tej meotdy*/}

    @Override
    public void keyReleased(KeyEvent e) {/* nie używam tej metody */}
}
