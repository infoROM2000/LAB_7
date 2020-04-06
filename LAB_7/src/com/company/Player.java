package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.company.Board.n;

public abstract class Player implements Runnable {
    protected String name;
    protected int progresieMaxima; // numarul de elemente din progresia maxima
    List<Integer> progresiaMaximaExplicit = new ArrayList<>(); //aici stocam numerele ce fac parte din progresiaMaxima
    protected int pasulProgresiei;
    List<Boolean> numere = new ArrayList<>(Collections.nCopies(n + 1, false)); //initializam un vector de frecventa de dimensiunea numarului de token-uri
    private int puncte;

    public abstract void run();

    public void progresieMaxim() {
        int pasCurent = 0;
        int numarCurent = 0;
        int nrElementeProgresie = 0;
        boolean inProgresie;
        boolean schimbat; // la final vom vedea daca progresia maxima a fost schimbata
        /* Explicatii for: noi iteram printre toate numerele
        Iar la fiecare numar incercam sa facem o progresie aritmetica cu o anumita ratie, reprezentata de pasCurent
        de la 1 pana la cat este diferenta dintre primul si ultimul termen dintre token-urile luate un anumit jucator
        Pentru un anumit pasCurent, vedem care ar fi urmatorul termen din progresia arimetica si incercam sa-l gasim cu indexOf
        Daca exista, valoarea numarului curent va deveni ea + pasul, daca nu, iesim din while si verificam daca cumva am depasit progresiaMaxima)
        La final, daca s-a schimbat progresia maxima, vom popula lista progresiaMaximaExplicit, obtinand numerele cu initial invers (pornind de la cel mai mare
        si scanzand din acesta pasul. La final, vom apela reverse ca sa fie ordonate crescator.
         */
        for (int i = 1; i <= n; i++) { //iteram printre toate numerele
            if (numere.get(i)) //index-ul curent este true, adica numarul se afla in posesia acestui jucator
                for (pasCurent = 1; pasCurent < n-i; pasCurent++) { //iteram printre toate progresiile posibile
                    numarCurent = i; //indexul=valuarea numarului
                    inProgresie = true;
                    schimbat = false;
                    nrElementeProgresie = 1;
                    while (inProgresie) { //cat timp gasim numere ce completeaza progresia
                        if (numarCurent + pasCurent < n)
                            if (!numere.get(numarCurent + pasCurent)) { //incercam sa vedem daca exista numarul curent + pasul = urmatorul numar ce ar veni in progresie
                                inProgresie = false; // daca nu exista, iesim din while
                                continue;
                            }
                        numarCurent += pasCurent; // daca exista, continuam while-ul si actualizam valoarea numarul curent si incrementam numarul de elemente din progresie
                        nrElementeProgresie++;
                    }
                    if (nrElementeProgresie > progresieMaxima) { // atunci actualizam progresia maxima
                        progresieMaxima = nrElementeProgresie;
                        schimbat = true;
                    }
                    if (schimbat) {
                        progresiaMaximaExplicit.clear(); //stergem progresia anterioara
                        for (int j = 1; j < progresieMaxima; j++) { // generam numerele ce se afla in progresie, pe baza ultimul si a pasului, in oridne descrescatoare
                            progresiaMaximaExplicit.add(numarCurent);
                            numarCurent -= pasCurent;
                        }
                        Collections.reverse(progresiaMaximaExplicit); //inversam, acum vor fi crescatoare
                        if (progresiaMaximaExplicit.size() > 1) // are sens sa vorbim de pas daca sunt macar 2 elemente in progresie
                            pasulProgresiei = progresiaMaximaExplicit.get(1) - progresiaMaximaExplicit.get(0); //pasul e diferenta a oricare 2 numere adiacente; aici am luat primele 2, ca sigur exista
                        else
                            pasulProgresiei = 0; //altfel il consideram 0
                    }
                }
        }
    }

    public String getName() {
        return name;
    }

    public void setPuncte() {
        puncte += progresieMaxima;
    }
}
