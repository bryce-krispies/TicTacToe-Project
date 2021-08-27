package model;
import enums.Mark;
import enums.BoardPosition;

public class Board {
    private Mark[][] board;
    
    public Board() {
        board = new Mark[3][3];
    }

    public void reset() {
        board = new Mark[3][3];
    }

    public void placeMark(Mark mark, BoardPosition boardPosition) {
        Mark storedMark = getMark(boardPosition);

        if(storedMark != Mark.Empty) {
            switch(boardPosition) {
                case TOPLEFT:
                    board[0][0] = mark;
                    break;
                case TOPMIDDLE:
                    board[0][1] = mark;
                    break;
                case TOPRIGHT:
                    board[0][2] = mark;
                    break;
                case MIDDLELEFT:
                    board[1][0] = mark;
                    break;
                case MIDDLEMIDDLE:
                    board[1][1] = mark;    
                    break;
                case MIDDLERIGHT:
                    board[1][2] = mark;
                    break;
                case BOTTOMLEFT:
                    board[2][0] = mark;
                    break;
                case BOTTOMMIDDLE:
                    board[2][1] = mark;
                    break;
                case BOTTOMRIGHT:
                    board[2][2] = mark;
                    break;
                default:
                    break;
            }
        }
        
        return;
    }

    public Mark getMark(BoardPosition boardPosition) {
        switch(boardPosition) {
            case TOPLEFT:
                return board[0][0];
            case TOPMIDDLE:
                return board[0][1];
            case TOPRIGHT:
                return board[0][2];
            case MIDDLELEFT:
                return board[1][0];
            case MIDDLEMIDDLE:
                return board[1][1];
            case MIDDLERIGHT:
                return board[1][2];
            case BOTTOMLEFT:
                return board[2][0];
            case BOTTOMMIDDLE:
                return board[2][1];
            case BOTTOMRIGHT:
                return board[2][2];
            default:
                return Mark.Empty;
        }
    }

    public Mark lookForWin() {
        { //row
            if(
                (getMark(BoardPosition.TOPLEFT) == getMark(BoardPosition.TOPMIDDLE))
                &&
                (getMark(BoardPosition.TOPRIGHT) == getMark(BoardPosition.TOPMIDDLE))
            ) {
                return getMark(BoardPosition.TOPMIDDLE);
            } else if (
                (getMark(BoardPosition.MIDDLELEFT) == getMark(BoardPosition.MIDDLEMIDDLE))
                &&
                (getMark(BoardPosition.MIDDLERIGHT) == getMark(BoardPosition.MIDDLEMIDDLE))
            ) {
                return getMark(BoardPosition.MIDDLEMIDDLE); 
            } else if (
                (getMark(BoardPosition.BOTTOMLEFT) == getMark(BoardPosition.BOTTOMMIDDLE))
                &&
                (getMark(BoardPosition.BOTTOMRIGHT) == getMark(BoardPosition.BOTTOMMIDDLE))
            ) {
                return getMark(BoardPosition.BOTTOMMIDDLE); 
            }
        }

        { //column
            if(
                (getMark(BoardPosition.TOPLEFT) == getMark(BoardPosition.MIDDLELEFT))
                &&
                (getMark(BoardPosition.BOTTOMLEFT) == getMark(BoardPosition.MIDDLELEFT))
            ) {
                return getMark(BoardPosition.MIDDLELEFT);
            } else if (
                (getMark(BoardPosition.TOPMIDDLE) == getMark(BoardPosition.MIDDLEMIDDLE))
                &&
                (getMark(BoardPosition.BOTTOMMIDDLE) == getMark(BoardPosition.MIDDLEMIDDLE))
            ) {
                return getMark(BoardPosition.MIDDLEMIDDLE); 
            } else if (
                (getMark(BoardPosition.TOPRIGHT) == getMark(BoardPosition.MIDDLERIGHT))
                &&
                (getMark(BoardPosition.BOTTOMRIGHT) == getMark(BoardPosition.MIDDLERIGHT))
            ) {
                return getMark(BoardPosition.MIDDLERIGHT); 
            }
        }

        { //diagonal
            if(
                (getMark(BoardPosition.TOPLEFT) == getMark(BoardPosition.MIDDLEMIDDLE))
                &&
                (getMark(BoardPosition.BOTTOMRIGHT) == getMark(BoardPosition.MIDDLEMIDDLE))
            ) {
                return getMark(BoardPosition.MIDDLEMIDDLE);
            } else if (
                (getMark(BoardPosition.TOPRIGHT) == getMark(BoardPosition.MIDDLEMIDDLE))
                &&
                (getMark(BoardPosition.BOTTOMLEFT) == getMark(BoardPosition.MIDDLEMIDDLE))
            ) {
                return getMark(BoardPosition.MIDDLEMIDDLE); 
            }
        }

        return Mark.Empty;
    }

}
