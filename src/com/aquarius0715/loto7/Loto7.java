package com.aquarius0715.loto7;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Loto7 extends JFrame{

    boolean clicked = false;

    private JButton decideNumberButton;
    private JPanel panel1;
    private JLabel label1;
    private JButton quitProgramButton;
    private JLabel label2;

    public Loto7() {
        decideNumberButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Random random = new Random();
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < 7; i++) {
                    result.append(random.nextInt(37) + 1);
                    result.append(' ');
                }
                label1.setText(String.valueOf(result));
                clicked = true;
            }
        });

        quitProgramButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.exit(0);
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(panel1);
        pack();
        setVisible(true);
    }
}
