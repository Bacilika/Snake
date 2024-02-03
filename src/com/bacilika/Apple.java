package com.bacilika;

import java.awt.*;

public record Apple(Point position) {
    public Apple(Point position) {
        this.position = position;
        Rectangle appleSquare = new Rectangle(position);
        appleSquare.setSize(1, 1);
    }
}
