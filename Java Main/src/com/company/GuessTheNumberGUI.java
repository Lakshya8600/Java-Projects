package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GuessTheNumberGUI {

    static void ButtonFunc(int rand, JTextField number, JLabel Lb)
    {

        String num = number.getText();
        System.out.println(rand);
        int num1 = Integer.parseInt(num);
        System.out.println(num1);
        if (num1 > 100 || num1 < 0)
        {
            System.out.println("Entering");
            JOptionPane.showConfirmDialog(null,"Please Choose A Number Between 1 And 100","Wrong Number",JOptionPane.WARNING_MESSAGE);
        }
        if(num1 > rand)
        {
            Lb.setFont(new Font("Mv Boli",Font.ITALIC,50));
            Lb.setText("you chose a Big no");
            System.out.println("you chose a Big no");
        }
        else if (num1 < rand)
        {
            Lb.setFont(new Font("Mv Boli",Font.ITALIC,45));
            Lb.setText("you chose a Small no");
            System.out.println("you chose a Small no");
        }
        else if (rand == num1 )
        {
            Lb.setFont(new Font("Mv Boli",Font.ITALIC,50));
            Lb.setText("you Won!!!!!!!!!");
            System.out.println("you Won!!!!!!!!!");
        }
    }

    public static void main(String[] args) {

        Random ran = new Random();
        int ran1 = ran.nextInt(100);

        JLabel name = new JLabel();
        name.setText("Guess The Number");
        name.setFont(new Font("Mv Boli",Font.PLAIN,55));
        name.setBackground(new Color(237, 255, 77));
        name.setForeground(new Color(227, 57, 119));
        name.setOpaque(true);

        JTextField number = new JTextField();
        number.setPreferredSize(new Dimension(160,80));
        number.setFont(new Font("Mv Boli",Font.PLAIN,73));
        number.setBackground(new Color(202, 208, 252));
        number.setForeground(Color.WHITE);
        number.setText("00");

        JButton button = new JButton();
        button.setSize(30,30);
        button.setText("Check");
        button.setFont(new Font("Mv Boli",Font.BOLD,80));
        button.setFocusable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(number, BorderLayout.WEST);
        panel.add(button);

//        panel.setBackground(Color.green);
//        panel.setOpaque(true);

        JLabel Lb = new JLabel();
        Lb.setText("Guess The Right No.\n Between 1 to 100");
        Lb.setFont(new Font("Mv Boli",Font.ITALIC,25));
        Lb.setBackground(new Color(217, 73, 252));
        Lb.setOpaque(true);
        button.addActionListener(fu ->ButtonFunc(ran1,number,Lb));

        JFrame frame = new JFrame();
        frame.setTitle("Guess The Number Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3,1));
        frame.setVisible(true);
        frame.setSize(500,500);
        frame.add(name);
        frame.add(panel);
        frame.add(Lb);
    }
}
