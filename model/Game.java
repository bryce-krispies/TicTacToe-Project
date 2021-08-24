package model;

public class Game {
    Player black, white;
    Board board;

    public Game(Player black, Player white) {
        board = new Board();
        this.black = black;
        this.white = white;
    }

    
}
