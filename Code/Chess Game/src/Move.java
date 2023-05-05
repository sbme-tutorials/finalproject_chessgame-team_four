public class Move {
    int oldCol,oldRow;
    int newCol,newRow;
    Piece piece;
    Piece capture;
    public Move(Board board,Piece piece,int newCol,int newRow){
        this.oldRow=piece.row;
        this.oldCol=piece.col;
        this.newRow=newRow;
        this.newCol=newCol;
        this.piece=piece;
        this.capture=board.getPiece(newCol,newRow);
    }
}
