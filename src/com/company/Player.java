package com.company;

import static com.company.Board.tokens;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player implements Runnable {
    String name;
    int progresieMaxima=0;
    List<Integer> numere = new ArrayList<>();

    public void run() {
        Scanner s = new Scanner(System.in);
        int ales = 0;
        boolean corect = false;
        while (!corect) {
            ales = s.nextInt();
            if (!tokens.get(ales).luat) {
                corect = true;
                numere.add(ales);
            }
        }
        progresieMaxim();
    }

    public void progresieMaxim() {
        int pasCurent = 0;
        int numarCurent = 0;
        int nrElementeProgresie = 0;
        boolean inProgresie;
        numere.sort((n1, n2) -> n1.compareTo(n2)); //sortam numerele inainte
        for (Integer numar : numere) {
            for (pasCurent = 1; pasCurent < numere.get(numere.size() - 1) - numere.get(0); pasCurent++) {
                inProgresie = true;
                nrElementeProgresie = 1;
                while (inProgresie) {
                    try {
                        numarCurent = numere.indexOf(numarCurent + pasCurent);
                        nrElementeProgresie++;
                    } catch (NullPointerException e) {
                        inProgresie = false;
                    }
                    if (nrElementeProgresie > progresieMaxima)
                        progresieMaxima = nrElementeProgresie;
                }
            }
        }
    }
}
