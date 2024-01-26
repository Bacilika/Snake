package com.bacilika;

import java.awt.*;

public class Apple {
    private Point position;
    private Rectangle appleSquare;
    public Apple(Point position){
        this.position = position;
        appleSquare = new Rectangle(position);
        appleSquare.setSize(1,1);
    }

    public Point getPosition() {
        return position;
    }
}
