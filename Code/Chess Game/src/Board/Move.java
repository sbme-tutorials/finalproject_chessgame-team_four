package Board;

import Board.Board;
import Pieces.*;
import Game.*;
import Board.*;
import Frames.*;

public class Move {
    int oldCol,oldRow;
    public int newCol;
    public int newRow;
    public Piece piece;
    public Piece capture;
    public Move(Board board, Piece piece, int newCol, int newRow){
        this.oldRow=piece.row;
        this.oldCol=piece.col;
        this.newRow=newRow;
        this.newCol=newCol;
        this.piece=piece;
        this.capture=board.getPiece(newCol,newRow);
    }

}
