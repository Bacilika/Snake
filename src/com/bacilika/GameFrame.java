package com.bacilika;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GameFrame extends JFrame {
    final private int WIDTH = 560;
    final private int HEIGHT = 650;
    private Board board;
    private Timer clockTimer;
    private final BoardComponent boardComponent;

    public GameFrame(){
        board = new Board();
        //Border border = BorderFactory.createLineBorder(Color.BLACK,3);
        //setLayout(null);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH+20,HEIGHT);
        clockTimer = new Timer(250, doOneStep);
        clockTimer.setCoalesce(true);
        clockTimer.start();
        boardComponent = new BoardComponent(board);
        setLayout(new BorderLayout());
        add(boardComponent,BorderLayout.CENTER);
        addKeyListener(board);



    }

    private final Action doOneStep = new AbstractAction() {

        @Override public void actionPerformed(ActionEvent e) {
            if (board.isRunning) {
                System.out.println("tick");
                    board.tick();
                    boardComponent.repaint();

            }
        }
    };

}

