package com.bacilika;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Board {
    final private static int height = 20;
    final private static int width = 20;
    private SquareType[][] squares = new SquareType[height][width];

    final public static int PANEL_SIZE = 20;

    public boolean isRunning = true;

    public SnakePart head = new SnakePart(10,10,null);


    public Board(){
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                squares[i][j] = SquareType.EMPTY;
            }
        }
        squares[head.getPosition().x][head.getPosition().y] = SquareType.SNAKE;
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
        Point lastPos = head.move();

        while(current != null){
            squares[current.getPosition().x][current.getPosition().y] = SquareType.SNAKE;
            current = current.getNextPart();
        }
        squares[lastPos.x][lastPos.y] = SquareType.EMPTY;
    }
}
