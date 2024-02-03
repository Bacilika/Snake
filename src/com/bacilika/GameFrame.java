package com.bacilika;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
public class GameFrame {
    private final int WIDTH;
    private final int HEIGHT;
    private final Board board;
    public final static int BORDER = 20;
    private final BoardComponent boardComponent;
    private JButton startButton;
    private final JFrame mainMenu;
    private final JFrame gameFrame;
    public GameFrame(){
        mainMenu = new JFrame("Main Menu");
        gameFrame = new JFrame("Game Frame");
        board = new Board();
        WIDTH = Board.getWidth()*Board.PANEL_SIZE+BORDER;
        HEIGHT = Board.getHeight()*Board.PANEL_SIZE+2*BORDER;
        boardComponent = new BoardComponent(board);
        setupFrame(mainMenu);
        showMenuFrame();
    }
    private void setupFrame(JFrame frame){
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH,HEIGHT);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
    }
    public void showMenuFrame(){
        startButton = new JButton("Start");
        setupFrame(mainMenu);
        mainMenu.add(startButton, BorderLayout.PAGE_START);
        startButton.setVisible(true);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.isRunning = true;
                mainMenu.dispose();
                setupFrame(gameFrame);
                gameFrame.addKeyListener(board);
                gameFrame.add(boardComponent,BorderLayout.CENTER);
                startClock();
            }
        });
    }
    private void startClock(){
        Timer clockTimer = new Timer(250, doOneStep);
        clockTimer.setCoalesce(true);
        clockTimer.start();
    }

    private final Action doOneStep = new AbstractAction() {

        @Override public void actionPerformed(ActionEvent e) {
            if (board.isRunning) {
                    board.tick();
                    boardComponent.repaint();
            }
        }
    };
}

