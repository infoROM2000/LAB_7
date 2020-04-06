package com.company;

import java.util.ArrayList;
import java.util.List;

import static com.company.Board.tokens;

public class Game {
    Board board;
    static List<Player> players=new ArrayList<>();

    public Game(int nrJucatori, int k, int n) {
        players = new ArrayList<Player>();
        char a = 'A';
        board = new Board(k, n);
        for (int i = 0; i < nrJucatori; i++) {
            Runnable newPlayer = new RandomPlayer(a++);
            players.add((Player) newPlayer);
        }
        for (int i = 0; i < players.size(); i++) {
            new Thread(players.get(i)).start();
        }

        for (Player player : players) {
            System.out.println();
            System.out.print(player.getName() + " are tokenurile: ");
            for (int i = 1; i <= n; i++) {
                if (player.numere.get(i))
                    System.out.print(i + " ");
            }
            System.out.println();
            if (player.progresieMaxima >= k) {
                System.out.println("A castigat " + player.getName());
                return;
            }
        }
        boolean luateToate = true;
        for (Token token : tokens) {
            if (!token.luat) {
                luateToate = false;
                break;
            }
        }
        if (luateToate) {
            for (Player player : players)
                player.setPuncte();
        }
    }
}

