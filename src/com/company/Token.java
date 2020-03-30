package com.company;
import static com.company.Board.tokens;
public class Token {
    int number;
    boolean luat;
    public Token(int num){
        number=num;
        luat=false;
        tokens.add(this);
    }
}
