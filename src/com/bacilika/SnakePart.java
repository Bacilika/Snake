package com.bacilika;

import java.awt.*;

public class SnakePart {
    private final Rectangle body;
    private SnakePart nextPart;
    private Direction direction = Direction.DOWN;
    private Direction desiredDirection = null;

    private boolean isHead = false;

    private Point position;
    private final SnakePart previousPart;
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
        if (nextPart != null){
            current = nextPart.move();
        }
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

        desiredDirection = null;
        return current;

    }
    private boolean outOfBounds(){
        switch (direction){
            case RIGHT -> {return position.x+1 > Board.getWidth()-1;}
            case LEFT -> {return position.x-1 < 0;}
            case DOWN -> {return position.y+1 > Board.getHeight()-1;}
            case UP -> {return position.y-1 <0;}
        }
        return false;
    }

    public void setDirection(Direction direction) {
        if(desiredDirection == null) {

            if (this.direction.ordinal() + direction.ordinal() == 1) { //UP + DOWN
                return;
            }
            if (this.direction.ordinal() + direction.ordinal() == 5) { //LEFT + RIGHT
                return;
            }

            this.direction = direction;
            desiredDirection = direction;
        }
    }

    public SnakePart getNextPart() {
        return nextPart;
    }
    public boolean collisionWithSelf(){
        if(isHead){
            SnakePart head = this;
            SnakePart current = head.getNextPart();
            while(current != null){
                if (head.body.contains(current.body)){
                    return true;
                }
                current = current.getNextPart();
            }


        }
        return false;

    }
}
