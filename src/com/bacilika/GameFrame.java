package com.bacilika;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
public class GameFrame {
    private final Board board;
    public final static int BORDER = 20;
    private final BoardComponent boardComponent;
    private final JFrame frame;

    private final int speed;
    public GameFrame(int speed){
        this.speed = speed;
        frame = new JFrame("Game Frame");
        board = new Board();
        int width = Board.getWidth() * Board.PANEL_SIZE + BORDER;
        int height = Board.getHeight() * Board.PANEL_SIZE + 2 * BORDER;
        boardComponent = new BoardComponent(board);
        frame.setSize(width, height);
        frame.setLayout(new BorderLayout());
        frame.addKeyListener(board);
        frame.add(boardComponent,BorderLayout.CENTER);

        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        startGame();

    }
    private void startGame(){
        board.isRunning = true;
        boardComponent.setVisible(true);
        startClock();

    }
    private void startClock(){
        Timer clockTimer = new Timer(speed, doOneStep);
        clockTimer.setCoalesce(true);
        clockTimer.start();
    }

    private final Action doOneStep = new AbstractAction() {

        @Override public void actionPerformed(ActionEvent e) {
            if (board.isRunning) {
                    board.tick();
                    boardComponent.repaint();
            }
            if(board.gameOver){
                gameOver();
                board.gameOver = false;

            }
        }
    };
    public void gameOver () {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setSize(350,350);
        frame.setVisible(true);
        frame.setLocationRelativeTo(this.frame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 350);
        JButton restart = new JButton("RESTART");
        JButton exit = new JButton("EXIT");
        JLabel label2 = new JLabel("You got a total of " + board.score + " apples");
        JLabel label = new JLabel("\t\tGAME OVER\t\t");
        label.setFont(new Font(null, Font.ITALIC, 20));

        restart.addActionListener(e -> {
            new GameFrame(speed);
            frame.dispose();
            this.frame.dispose();
        });
        exit.addActionListener(e -> {
            System.exit(0);
        });
        panel.add(label);
        panel.add(label2);
        panel.add(restart);
        panel.add(exit);
        frame.add(panel);
    }
}

