package com.company;

import java.util.ArrayList;
import java.util.List;

public class Board {
    static int k, n;
    static List<Token> tokens = new ArrayList<>();
    public Board(int k, int n) {
        this.k = k;
        this.n = n;
        for (int i = 1; i <= n; i++)
            tokens.add(new Token(i));
    }
}
