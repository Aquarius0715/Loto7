package com.aquarius0715.loto7;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Loto7 extends JFrame{

    boolean clicked = false;

    private JButton decideNumberButton;
    private JPanel panel1;
    private JButton quitProgramButton;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;

    public Loto7() {
        decideNumberButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                boolean end = false;
                int count = 1;
                super.mouseClicked(e);
                Random random = new Random();
                ArrayList<Integer> numbers = new ArrayList<Integer>();
                for (int i = 1;; i++) {
                    if (end) break;
                    int rnd = random.nextInt(37) + 1;
                    if (numbers.contains(rnd)) {
                        i--;
                        continue;
                    }
                    numbers.add(rnd);
                    if (i % 7 == 0 && i != 0) {
                        StringBuilder result = new StringBuilder();
                        Collections.sort(numbers);
                        for (Integer number : numbers) {
                            if (number < 10) {
                                result.append("0").append(number);
                            } else {
                                result.append(number);
                            }
                            result.append(' ');
                        }
                        numbers.clear();
                        switch (count) {
                            case 1 -> {label1.setText(String.valueOf(result)); count++;}
                            case 2 -> {label2.setText(String.valueOf(result)); count++;}
                            case 3 -> {label3.setText(String.valueOf(result)); count++;}
                            case 4 -> {label4.setText(String.valueOf(result)); count++;}
                            case 5 -> {label5.setText(String.valueOf(result)); end = true; count = 1;}
                        }
                    }
                }
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
