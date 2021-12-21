package com.company;

import javax.swing.*;
import java.awt.*;

public class Button {

    static void func1 ()
    {
        String name = "bye";
    }

    public static void main(String[] args) {
        String name = "helllo";
        JFrame frame = new JFrame();

        JButton butt = new JButton();
        butt.addActionListener(e -> func1());

        JLabel pan = new JLabel();
        pan.setText(name);

        frame.setLayout(new GridLayout(3,3));
        frame.setSize(500,500);
        frame.add(butt);
        frame.add(pan);


        frame.setVisible(true);
    }
}
