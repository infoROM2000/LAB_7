package com.company;

import static com.company.Board.n;
import static com.company.Board.tokens;

public class RandomPlayer extends Player {
    public RandomPlayer(char nume){
        name=String.valueOf(nume);
        progresieMaxima=0;
        pasulProgresiei=0;
    }
    public void run() {
        int ales = 0;
        boolean corect = false;
        while (!corect) { //alegem random pana cand dam de unul bun
            ales = (int)(Math.random()*n); // intre 1 si n
            if (!tokens.get(ales).luat) {
                corect = true;
                numere.set(ales, true); //daca luam un numar, atunci campul luat de la index-ul respectiv va deveni true
            }
        }
        progresieMaxim(); //actualizam progresia maxima
    }
}
