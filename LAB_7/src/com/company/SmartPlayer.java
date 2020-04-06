package com.company;

import static com.company.Board.*;
import static com.company.Game.players;
public class SmartPlayer extends Player {
    public void run() {
        int ales = 0;
        ales = progresiaMaximaExplicit.get(progresiaMaximaExplicit.size() - 1) + pasulProgresiei; //urmatorul element care ar fi in progresie
        if (!tokens.get(ales).luat && ales < n) { //incercam sa vedem daca exista numarul ce ar urma la capatul progresiei maxime curente
            numere.set(ales, true); //daca luam un numar, atunci campul luat de la index-ul respectiv va deveni true
            progresieMaxim(); //actualizam progresia maxima
            return;
        }
        ales = progresiaMaximaExplicit.get(0) - pasulProgresiei;
        if (!tokens.get(ales).luat && ales > 0) { //incercam sa vedem daca exista numarul ce ar urma la inceputul progresiei maxime curente
            numere.set(ales, true); //daca luam un numar, atunci campul luat de la index-ul respectiv va deveni true
            progresieMaxim(); //actualizam progresia maxima
            return;
        }
        //daca nu exista nici o completare, incercam sa luam numerele ce ar completa progresiile jucatorilor
        for (Player player : players) {
            ales = player.progresiaMaximaExplicit.get(player.progresiaMaximaExplicit.size() - 1) + player.pasulProgresiei; //urmatorul element care ar fi in progresie
            if (!tokens.get(ales).luat && ales < n) { //incercam sa vedem daca exista numarul ce ar urma la capatul progresiei maxime curente
                player.numere.set(ales, true); //daca luam un numar, atunci campul luat de la index-ul respectiv va deveni true
                break;
            }
            ales = player.progresiaMaximaExplicit.get(0) - player.pasulProgresiei;
            if (!tokens.get(ales).luat && ales > 0) { //incercam sa vedem daca exista numarul ce ar urma la inceputul progresiei maxime curente
                player.numere.set(ales, true); //daca luam un numar, atunci campul luat de la index-ul respectiv va deveni true
                break;
            }
        }
    }
}

