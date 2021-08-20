package model;
import enums.Mark;
import enums.BoardPosition;

public class Board {
    private Mark[][] board;
    
    public Board() {
        board = new Mark[2][2];
    }

    public void reset() {
        board = new Mark[2][2];
    }

    public void placeMark(Mark mark, BoardPosition boardPosition) {
        Mark storedMark = getMark(mark, boardPosition);

        if(storedMark != Mark.Empty) {
            switch(boardPosition) {
                case TOPLEFT:
                board[0][0] = mark;
                break;
                case TOPRIGHT:
                board[0][1] = mark;
                break;
                case BOTTOMLEFT:
                board[1][0] = mark;
                break;
                case BOTTOMRIGHT:
                board[1][1] = mark;
            }
        }
        
        return;
    }

    public Mark getMark(Mark mark, BoardPosition boardPosition) {
        switch(boardPosition) {
            case TOPLEFT:
            return board[0][0];
            case TOPRIGHT:
            return board[0][1];
            case BOTTOMLEFT:
            return board[1][0];
            case BOTTOMRIGHT:
            return board[1][1];
            default:
            return Mark.Empty;
        }
    }

}
