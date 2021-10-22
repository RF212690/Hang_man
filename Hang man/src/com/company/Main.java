package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner input = new Scanner(System.in);
        boolean play;
        do {
            String guess = "";
            int stage = 0;
            String[][] stages = new String[6][5];
            for (int i = 0; i < 5; i++) {
                stages[i][0] = "0";
            }
            stages[5][0] = "|";
            for (int i = 1; i < 5; i++) {
                for (int n = 0; n < 5 - i; n++) {
                    if (i % 2 == 0) {
                        stages[n][i] = "/";
                    } else {
                        stages[n][i] = "\\";
                    }
                }
                for (int n = 5; n >= 5 - i; n--) {
                    stages[n][i] = " ";

                }

            }
            play = false;
            boolean checker;
            System.out.println("Let's play hangman! What word am I thinking about?");
            System.out.println("______");
            System.out.println("|  |  ");
            System.out.println("|  " + stages[stage][0] + "  ");
            System.out.println("| " + stages[stage][2] + "|" + stages[stage][1] + " ");
            System.out.println("| " + stages[stage][4] + " " + stages[stage][3] + " ");
            System.out.println("|     ");
            String[] words = {"mario", "glucose", "sinusoid", "hanging", "ship", "computing", "graffiti", "collection", "league", "intelligent"};
            String word = words[random.nextInt(10)];
            for (int i = 0; i < word.length(); i++) {
                guess = guess + "_";
            }
            System.out.println(guess);
            do {
                System.out.println("Insert a letter or your final guess");
                String tempguess = input.next();
                if (tempguess.length() >= 2) {
                    if(tempguess.equalsIgnoreCase(word)){
                        guess = tempguess;
                    }
                    else{
                        stage++;
                        System.out.println("wrong");
                        System.out.println("______");
                        System.out.println("|  |  ");
                        System.out.println("|  " + stages[stage][0] + "  ");
                        System.out.println("| " + stages[stage][2] + "|" + stages[stage][1] + " ");
                        System.out.println("| " + stages[stage][4] + " " + stages[stage][3] + " ");
                        System.out.println("|     ");
                        System.out.println(guess);

                    }

                } else {
                    checker = true;
                    for (int i = 0; i < word.length(); i++) {
                        if (tempguess.equalsIgnoreCase(String.valueOf(word.charAt(i)))) {
                            guess = guess.substring(0, i) + word.charAt(i) + guess.substring(i + 1);
                            checker = false;
                        }
                    }
                    if (checker) {
                        System.out.println("wrong");
                        stage++;
                    } else {
                        System.out.println("Correct!");
                    }
                    System.out.println("______");
                    System.out.println("|  |  ");
                    System.out.println("|  " + stages[stage][0] + "  ");
                    System.out.println("| " + stages[stage][2] + "|" + stages[stage][1] + " ");
                    System.out.println("| " + stages[stage][4] + " " + stages[stage][3] + " ");
                    System.out.println("|     ");
                    System.out.println(guess);

                }
            }
            while (stage < 5 && !guess.equalsIgnoreCase(word));
            if (guess.equalsIgnoreCase(word)) {
                System.out.println("That is correct! My word was " + word + ", would you like to play again? press Y");
            } else {
                System.out.println("You ran out of chances,the word was " + word + ", would you like to play again? press Y");
            }
            String answer = input.next();
            if (answer.equalsIgnoreCase("y")) {
                play = true;
            }
        }
        while (play);
    }
}

