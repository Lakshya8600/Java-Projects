package com.company;
import java.util.Scanner;
import java.util.Random;

class GuessTheNumber{
    void Guess()
    {
        System.out.println("!!!!Welcome!!!!\nChoose a Number Between 1 And 100 and Guess The Correct Number");
        Random rand = new Random();
        int Number = rand.nextInt(100);
        while(true)
        {
            Scanner sc = new Scanner(System.in);
            int PlayerNo = sc.nextInt();
            if(PlayerNo>Number)
            {
                System.out.println("you chose a Big no");
            }
            else if (Number > PlayerNo)
            {
                System.out.println("you chose a Small no");
            }
            else if (Number == PlayerNo)
            {
                System.out.println("you Won!!!!!!!!!");
                break;
            }
        }
    }
}

public class Main {

    public static void main(String[] args) {
        GuessTheNumber Gu = new GuessTheNumber();
        Gu.Guess();
    }
}




//System.out.println("hello world");
//	    Scanner Sc = new Scanner(System.in);
//	    int a = Sc.nextInt();
//	    Random rand = new Random();
//	    int ranno = rand.nextInt(10);
//        System.out.println(ranno);
//        int [] marks = new int[5];