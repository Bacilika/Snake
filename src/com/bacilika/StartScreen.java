package com.bacilika;

import javax.swing.*;
import java.awt.*;

public class StartScreen extends JFrame {
    JPanel mainMenu;
    JPanel speedMenu;
    GameFrame gameFrame;
    FlowLayout flowLayout;
    public StartScreen(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(550, 550);
        setLocationRelativeTo(null);

        flowLayout = new FlowLayout();
        mainMenu = new JPanel();
        mainMenu.setLayout(flowLayout);

        JButton start = new JButton("Start");
        JButton exit = new JButton("Exit");

        start.addActionListener(e -> {
            selectSpeed(this);

        });
        exit.addActionListener(e -> { System.exit(0);});
        mainMenu.add(start);
        mainMenu.add(exit);
        add(mainMenu);

    }

    public void selectSpeed(JFrame frame){
        mainMenu.setVisible(false);
        speedMenu = new JPanel();
        JButton slow = new JButton("Slow");
        JButton medium = new JButton("Medium");
        JButton fast = new JButton("Fast");
        JButton insane = new JButton("Insane");

        slow.addActionListener(e -> {
            dispose();
            gameFrame = new GameFrame(195);
        });
        medium.addActionListener(e -> {
            dispose();
            gameFrame = new GameFrame(170);

        });
        fast.addActionListener(e -> {
            dispose();
            gameFrame = new GameFrame(155);

        });
        insane.addActionListener(e -> {
            dispose();
            gameFrame = new GameFrame(120);
        });
        speedMenu.add(slow);
        speedMenu.add(medium);
        speedMenu.add(fast);
        speedMenu.add(fast);
        frame.add(speedMenu);
    }
}
