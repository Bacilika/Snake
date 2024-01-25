package com.bacilika;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.TimerTask;
import java.util.Timer;
/*
public class SurvivalMode extends GameFrame implements KeyListener {
    JFrame frame = new JFrame();
    JPanel apple;
    JPanel apple2;
    JLabel speed = new JLabel();
    Snake s = new Snake();
    Timer timer = new Timer();
    TimerTask task;
    JLabel score = new JLabel();
    float time = 0;
    public long SPEED = 130;
    int number;

    public SurvivalMode(){
        JLabel[] snake = new JLabel[22*22];
        apple = new JPanel();
        apple2= new JPanel();
        addScore(frame,score);
        addSpeed(frame,speed, SPEED);
        s.addSnake(snake,frame);


        apple.setBackground(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
        apple.setSize(s.PANEL_SIZE, s.PANEL_SIZE);
        s.consumeApple(snake,apple,score,speed,SPEED);
        frame.add(apple);
        Frame(frame);

        task = new TimerTask() {
            @Override
            public void run() {
                if(!s.getDirection().equals("QUIT")){
                    s.snakeTrain(snake,apple,apple2);
                    s.moveSnake(snake);
                    number +=1;
                    if(!s.getDirection().equals("")&&(number%10==1))
                        s.addBodies();
                    if(!s.getDirection().equals("PAUSE")){
                        time += (float) SPEED/1000;}
                    if(s.collisionWithApple(snake,apple)){
                        s.consumeApple(snake, apple,score,speed,SPEED);
                        snake[s.getBodies()].setVisible(false);

                        //snake[s.bodies].setBackground(apple.getBackground());
                    }
                    if(s.checkBoundsX(snake)|| s.checkBoundsY(snake)){
                        s.setDirection("QUIT");
                        System.out.println("out of bounds");
                        gameOver(time);
                    }
                    if(s.checkCollisionWithSelf(snake)&& s.getBodies()>1) {
                        s.setDirection("QUIT");
                        System.out.println("collision with self");
                        gameOver(time);
                    }
                }
            }
        };
        timer.schedule(task, 0, SPEED);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_RIGHT) {
            s.setDirection("RIGHT");
        } else if (key == KeyEvent.VK_LEFT) {
            s.setDirection("LEFT");
        } else if (key == KeyEvent.VK_DOWN) {
            s.setDirection("DOWN");
        } else if (key == KeyEvent.VK_UP) {
            s.setDirection("UP");
        } else if (key == KeyEvent.VK_SPACE) {
            s.setDirection("PAUSE");
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {


    }
}
*/