package com.company;

import java.util.Scanner;

import static com.company.Board.tokens;

public class HumanPlayer extends Player{
    public void run() { //implementare cu scanner/de la tastatura
        Scanner s = new Scanner(System.in);
        int ales = 0;
        boolean corect = false;
        while (!corect) {
            ales = s.nextInt();
            if (!tokens.get(ales).luat) {
                corect = true;
                numere.set(ales, true); //daca luam un numar, atunci index-ul sau va deveni true
            }
        }
        progresieMaxim(); //actualizam progresia maxima
    }
}
