package com.company;
import static com.company.Board.tokens;
public class Token {
    int number;
    boolean luat;
    public Token(int num){ //pentru blank apelati constructorul cu 0
        number=num;
        luat=false;
    }
    static public void iaToken(int index){
              tokens.get(index).luat=true;
    }
}
