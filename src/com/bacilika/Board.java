package com.bacilika;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Board implements KeyListener {
    final private static int height = 15;
    final private static int width = 15;
    private final SquareType[][] squares = new SquareType[height][width];
    final public static int PANEL_SIZE = 30;
    private Apple apple;
    public boolean isRunning = false;
    public SnakePart head;
    private final Random random = new Random();
    public boolean gameOver = false;

    public int score = 0;

    public Board(){
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                squares[i][j] = SquareType.EMPTY;
            }
        }
        spawnSnake(3);
        squares[head.getPosition().x][head.getPosition().y] = SquareType.SNAKE;

        spawnApple();

    }
    public void spawnApple(){
        Point pos;
        do {
            pos = new Point(random.nextInt(0,width-1), random.nextInt(0,height-1));
            System.out.println(pos);
        }while (getSquareAt(pos.x, pos.y)== SquareType.SNAKE);

        apple = new Apple(pos);
        squares[pos.x][pos.y] = SquareType.APPLE;
    }
    public void spawnSnake(int length){
        head = new SnakePart(10,2,null);
        SnakePart current = head;
        for (int i = 0; i < length-1; i++) {
            current = new SnakePart(current.getPosition().x,current.getPosition().y,current);

        }
    }
    public SquareType getSquareAt(int x, int y){
        return squares[x][y];
    }

    public static int getHeight() {
        return height;
    }

    public static int getWidth() {
        return width;
    }

    public void tick(){
        SnakePart current = head;
        SnakePart previous = null;
        Point lastPos = head.move();

        while(current != null){
            squares[current.getPosition().x][current.getPosition().y] = SquareType.SNAKE;
            previous = current;
            current = current.getNextPart();
        }
        squares[lastPos.x][lastPos.y] = SquareType.EMPTY;

        if(eatingApple()){
            score ++;
            new SnakePart(lastPos.x,lastPos.y,previous);
            spawnApple();

        }
        if (head.collisionWithSelf() || head.outOfBounds()){
            System.out.println("you died");
            gameOver = true;
            isRunning = false;

        }

    }
    private boolean eatingApple(){
        return (head.getPosition().equals(apple.position()));
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP -> head.setDirection(Direction.UP);
            case KeyEvent.VK_LEFT -> head.setDirection(Direction.LEFT);
            case KeyEvent.VK_RIGHT -> head.setDirection(Direction.RIGHT);
            case  KeyEvent.VK_DOWN -> head.setDirection(Direction.DOWN);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
