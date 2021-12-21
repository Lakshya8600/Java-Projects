package com.LKprogs;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Main {
    public static float AngleCalc(int Hour,int Minute,int Second){
        float Angle = 0;
        float MinutePosition = Minute * 6;
        float HourPosition = (Hour * 30) + Minute/2; // 6 * 5 = 30
        float Difference = HourPosition - MinutePosition;
        Angle += Difference;
        if (HourPosition>MinutePosition){
            Angle += Second*0.1;
        }
        else {
            Angle -= Second*0.1;
        }
        if ((360-Angle)<Angle){
            Angle = 360 - Angle;
        }
        return Angle;
    }

    public static void ButtonFunc(JTextField pane,JLabel DayName){
        String str = pane.getText();
        String[] parts = str.split("-");
        pane.selectAll();
        int Hour = 0;
        int Minute = 0;
        int Second = 0;

        try {
            Hour = Integer.parseInt(parts[0]);
            Minute = Integer.parseInt(parts[1]);
            Second = Integer.parseInt(parts[2]);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"PLease Enter A Valid Date!!","Warning!!",JOptionPane.WARNING_MESSAGE);
        }
        if (Hour>12 || Minute > 60 || Second > 60){
            JOptionPane.showMessageDialog(null,"PLease Enter A Valid Date!!","Warning!!",JOptionPane.WARNING_MESSAGE);
        }

        float Angle = AngleCalc(Hour,Minute,Second);
        DayName.setText(Math.abs(Angle)+" Degree");

    }

    public static void main(String[] args) {
        Border border = BorderFactory.createLineBorder(Color.BLACK);

        JTextField pane = new JTextField();
        pane.setFont(new Font("Algerian",Font.ITALIC,70));
        pane.setForeground(new Color(66,0,0));
        pane.setBackground(new Color(220,220,0));
        pane.setOpaque(true);
        pane.setText("HH-MM-SS");
        pane.setSelectedTextColor(Color.DARK_GRAY);
        pane.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        pane.selectAll();

        JTextArea Intro = new JTextArea();
        Intro.setSize(300,50);
        Intro.setText("Hey What's The Angle Between \nThe Hour And Minute Hand Of Clock\n      ** Enter Time To Find Out **");
        Intro.setFont(new Font("MV Boli",Font.BOLD,20));
        Intro.setOpaque(true);
        Intro.setBackground(Color.ORANGE);
        Intro.setEditable(false);
        Intro.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        JLabel DayName = new JLabel();
        DayName.setFont(new Font("Brush Script MT",Font.PLAIN,60));
        DayName.setForeground(new Color(66,0,0));
        DayName.setOpaque(true);
        DayName.setText("Time Please!!");
        DayName.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        DayName.setBackground(new Color(226,244,60));

        JButton button = new JButton();
        button.setText("Submit");
        button.setFocusable(false);
        button.setSize(50,50);
        button.setFont(new Font("Chiller",Font.PLAIN,55));
        button.setBounds(320,5,150,100);
        button.setBackground(new Color(226,244,150));
        button.setForeground(Color.BLACK);
        button.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        button.addActionListener(e -> ButtonFunc(pane,DayName));

        DayName.add(button);

        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setTitle("Day Calculator");
        frame.setSize(480,350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3,0));
        frame.add(pane);
        frame.add(Intro);
        frame.add(DayName);
        frame.setResizable(false);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = frame.getSize().width;
        int h = frame.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;

        frame.setLocation(x,y);
    }
}
