package com.LKprogs;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Main {
    public static boolean FirstTime = false;
    public static int[][] YearMonths = {{1,31},{2,28},{3,31},{4,30},
            {5,31},{6,30},{7,31},{8,31},
            {9,30},{10,31},{11,30},{12,31}};
    public static String[] WeekDays = {"Saturday","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday"};

    public static int DayCalc(int Day,int Months,int Year){
        int Mod = 0;

        if (2000 >= Year && Year > 1600){
            int YearGap = Year-1600-1;
            int CurrentMonth = 0;
            while (YearGap > 99){
                Mod += 5;
                YearGap = YearGap - 100;
            }
            if (YearGap > 0){
                int CurrentYear = (Mod/5*100)+1600;
                while(CurrentYear < Year-1){
                    if (CurrentYear%4 == 0 && CurrentYear%100 != 0){
                        Mod+=2;
                        CurrentYear+= 1;
                    }
                    else{
                        Mod+=1;
                        CurrentYear+= 1;
                    }
                }
            }
            while(CurrentMonth < (Months-1)){
                CurrentMonth += 1;
                if (CurrentMonth==2 && Year%4==0 && Year%100 != 0){
                    Mod+=1;
                }
                Mod += YearMonths[CurrentMonth-1][1];
            }
            Mod += Day;
            Mod+=1;
            Mod = Mod%7;

        }
        if (2400 >= Year && Year > 2000){
            int YearGap = Year-2000-1;
            int CurrentMonth = 0;
            while (YearGap > 99){
                Mod += 5;
                YearGap = YearGap - 100;
            }
            if (YearGap > 0){
                int CurrentYear = (Mod/5*100)+2000;
                while(CurrentYear < Year-1 && CurrentYear%100 != 0){
                    if (CurrentYear%4 == 0){
                        Mod+=2;
                        CurrentYear+= 1;
                    }
                    else{
                        Mod+=1;
                        CurrentYear+= 1;
                    }
                }
            }
            if (Months>12){
                JOptionPane.showMessageDialog(null,"PLease Enter A Valid Date","Warning!!",JOptionPane.WARNING_MESSAGE);
            }
            while(CurrentMonth < (Months-1)){
                CurrentMonth += 1;
                if (CurrentMonth==2 && Year%4==0 && Year%100 != 0){
                    Mod+=1;
                }
                Mod += YearMonths[CurrentMonth-1][1];
            }

            if(Day > YearMonths[Months-1][1]){
                JOptionPane.showMessageDialog(null,"PLease Enter A Valid Date","Warning!!",JOptionPane.WARNING_MESSAGE);
            }
            else {
                Mod += Day;
                Mod = Mod%7;
            }
            Mod += Day;
            Mod += 2;
            Mod = Mod%7;
        }
        if (1600>Year || Year>2400){
            JOptionPane.showMessageDialog(null,"Sorry To Say Program Works Only between Year 1601 To 2400","Sorry!!",JOptionPane.WARNING_MESSAGE);
        }
        return Mod;
    }

    public static void ButtonFunc(JTextField pane,JLabel DayName){
        String str = pane.getText();
        String[] parts = str.split("-");
        pane.selectAll();
        int Day = 0;
        int Months = 0;
        int Year = 0;

        try {
            Day = Integer.parseInt(parts[0]);
            Months = Integer.parseInt(parts[1]);
            Year = Integer.parseInt(parts[2]);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"PLease Enter A Valid Date","Warning!!",JOptionPane.WARNING_MESSAGE);
        }
        int Mod = DayCalc(Day,Months,Year);
        System.out.println(WeekDays[Mod]);
        DayName.setText(WeekDays[Mod]);

    }

    public static void main(String[] args) {

        Border border = BorderFactory.createLineBorder(Color.BLACK);

        JTextField pane = new JTextField();
        pane.setFont(new Font("Algerian",Font.ITALIC,70));
        pane.setForeground(new Color(66,0,0));
        pane.setBackground(new Color(220,220,0));
        pane.setOpaque(true);
        pane.setSelectedTextColor(Color.DARK_GRAY);
        pane.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createLineBorder(new Color(150,220,200),5,true)));
        pane.selectAll();

        JTextArea Intro = new JTextArea();
        Intro.setSize(300,50);
        Intro.setText("Want To Find Day Of Given Date.\nCheck It Out!!.\n**Enter The Date Above In D-M-Y Format Only**");
        Intro.setFont(new Font("MV Boli",Font.BOLD,20));
        Intro.setOpaque(true);
        Intro.setBackground(Color.ORANGE);
        Intro.setEditable(false);
        Intro.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        JLabel DayName = new JLabel();
        DayName.setFont(new Font("Brush Script MT",Font.PLAIN,60));
        DayName.setForeground(new Color(66,0,0));
        DayName.setOpaque(true);
        DayName.setText("Date Please!!");
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
        button.addActionListener(f -> ButtonFunc(pane,DayName));
        button.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(10, 10, 10, 10)));

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

        frame.setLocation(x, y);
        }
}