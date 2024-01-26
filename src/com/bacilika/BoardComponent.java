package com.bacilika;

import javax.swing.*;
import java.awt.*;
import java.util.EnumMap;

public class BoardComponent  extends JComponent {
    private final Board board;
    private Color color;
    private EnumMap<SquareType, Color> colors = new EnumMap<>(SquareType.class);

    public BoardComponent(Board board){
        this.board=board;
        colors.put(SquareType.EMPTY, Color.GRAY);
        colors.put(SquareType.SNAKE, new Color(100,226,100));
        colors.put(SquareType.APPLE, new Color(255,50,50));
    }
    @Override
    protected void paintComponent(final Graphics g){
        super.paintComponent(g);
        final Graphics2D g2d = (Graphics2D) g;
        for (int i = 0; i < Board.getHeight(); i++) {
            for (int j = 0; j < Board.getWidth(); j++) {
                color = colors.get(board.getSquareAt(i, j));
                g2d.setColor(color);
                g2d.fillRect(i * Board.PANEL_SIZE, j * Board.PANEL_SIZE, Board.PANEL_SIZE, Board.PANEL_SIZE);
                if(board.getSquareAt(i,j) == SquareType.EMPTY){
                    g2d.setColor(Color.BLACK);
                    g2d.drawRect(i * Board.PANEL_SIZE, j * Board.PANEL_SIZE, Board.PANEL_SIZE, Board.PANEL_SIZE);

                }

            }
        }
    }
}
