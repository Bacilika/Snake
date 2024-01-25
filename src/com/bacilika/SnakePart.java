package com.bacilika;

import java.awt.*;

public class SnakePart {
    private Rectangle body;
    private SnakePart nextPart;
    private Direction direction = Direction.DOWN;

    private boolean isHead = false;

    private Point position;
    private SnakePart previousPart;
    public SnakePart(int xpos, int ypos, SnakePart previousPart){
        position = new Point(xpos,ypos);
        body = new Rectangle(xpos,ypos,10,10);
        this.previousPart = previousPart;
        nextPart = null;
        if (previousPart == null)
                isHead = true;
        else
            connectPrevious();

    }
    public void connectPrevious(){
        previousPart.setNextPart(this);
    }

    public void setNextPart(SnakePart nextPart) {
        this.nextPart = nextPart;
    }
    public Point getPosition(){
        return position;
    }
    private Direction getDirection(){
        return direction;
    }
    public Point move(){
        Point current = new Point(getPosition().x, getPosition().y);
        if (isHead){
            switch (direction){
                case UP -> body.setLocation(getPosition().x, getPosition().y-1);
                case DOWN -> body.setLocation(getPosition().x, getPosition().y+1);
                case LEFT -> body.setLocation(getPosition().x-1, getPosition().y);
                case RIGHT -> body.setLocation(getPosition().x+1, getPosition().y);
            }
            if(outOfBounds()){
                System.out.println("you died");
                System.exit(0);

            }


        }
        else{
            body.setLocation(previousPart.getPosition());
            direction = previousPart.getDirection();
        }
        position = body.getLocation();
        if (nextPart != null){
            return nextPart.move();
        }
        return current;

    }
    private boolean outOfBounds(){
        switch (direction){
            case RIGHT -> {return position.x+2 > Board.getWidth();}
            case LEFT -> {return position.x-2 < 0;}
            case DOWN -> {return position.y+2 > Board.getHeight();}
            case UP -> {return position.y-2 <0;}
        }
        return false;
    }
    public SnakePart getNextPart() {
        return nextPart;
    }
}
