package com.bacilika;

import javax.swing.*;
import java.awt.*;
import java.util.EnumMap;

public class BoardComponent  extends JComponent {
    private final Board board;
    private final EnumMap<SquareType, Color> colors = new EnumMap<>(SquareType.class);

    public BoardComponent(Board board){
        this.board=board;
        colors.put(SquareType.EMPTY, Color.GRAY);
        colors.put(SquareType.SNAKE, new Color(100,226,100));
        colors.put(SquareType.APPLE, new Color(255,50,50));
    }
    @Override
    protected void paintComponent(final Graphics g){
        super.paintComponent(g);
        Point squarePos;
        int x,y;
        int size = Board.PANEL_SIZE;
        final Graphics2D g2d = (Graphics2D) g;
        for (int i = 0; i < Board.getHeight(); i++) {
            for (int j = 0; j < Board.getWidth(); j++) {
                Color color = colors.get(board.getSquareAt(i, j));
                squarePos = new Point(i,j);
                x = i*size;
                y = j*size;
                g2d.setColor(color);
                g2d.fillRect(x, y, size, size);
                if(board.getSquareAt(i,j) == SquareType.EMPTY){
                    g2d.setColor(Color.BLACK);
                    g2d.drawRect(x, y, size, size);

                }
                if(board.getSquareAt(i,j) == SquareType.APPLE){
                    g2d.setColor(colors.get(SquareType.EMPTY));
                    g2d.fillRect(x, y, size, size);
                    g2d.setColor(Color.BLACK);
                    g2d.drawRect(x, y, size, size);
                    g2d.setColor(color);
                    g2d.fillOval(x,y,size,size);
                }
                if(board.head.getPosition().equals(squarePos)){
                    g2d.setColor(Color.BLACK);
                    g2d.drawString("◕ ◕",x+size/4,y+size/4);
                }

            }
        }
    }
}
