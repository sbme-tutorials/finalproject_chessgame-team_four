import java.awt.image.BufferedImage;

public class Pawn extends Piece{
    public Pawn(Board board,int col,int row,boolean is_white){
        super(board);
        this.col=col;
        this.row=row;
        this.xPos=col*board.tilesize;
        this.yPos=row* board.tilesize;
        this.is_white=is_white;
        this.name="Pawn";
        this.sprite=sheet.getSubimage(5*x_image,is_white?0:y_image,x_image,y_image).getScaledInstance(board.tilesize,board.tilesize, BufferedImage.SCALE_SMOOTH);
    }
    public boolean isValidMovement(int col, int row) {
        int colorIndex = is_white ? 1 : -1;
        // push pawn 1
        if (this.col == col && row == this.row - colorIndex && board.getPiece(col, row) == null) {
            return true;
        }
        // push pawn 2
        if (isFirstMove && this.col == col && row == this.row - colorIndex * 2 && board.getPiece(col, row) == null && board.getPiece(col, row + colorIndex) == null) {
            return true;
        }
        // capture diagonally left
        if (!isFirstMove && col == this.col - 1 && row == this.row - colorIndex /*&& board.getPiece(col, row) == null*/) {
            return true;
        }
        // capture diagonally right
        if (!isFirstMove && col == this.col + 1 && row == this.row - colorIndex /*&& board.getPiece(col, row) == null*/) {
            return true;
        }
        //  capture diagonally left in first move
        if (isFirstMove && col == this.col - 1 && row == this.row - colorIndex && board.getPiece(col, row) != null) {
            return true;
        }
        // capture diagonally right in first move
        if (isFirstMove && col == this.col + 1 && row == this.row - colorIndex && board.getPiece(col, row) != null) {
            return true;
        }
        // capture piece in front
        if (this.col == col && row == this.row - colorIndex && board.getPiece(col, row) != null) {
            return true;
        }
        // en passant left
        if (board.getTileNum(col, row) == board.enPassantTile && col == this.col - 1 && row == this.row - colorIndex && board.getPiece(col, row + colorIndex) != null) {
            return true;
        }
        // en passant right
        if (board.getTileNum(col, row) == board.enPassantTile && col == this.col + 1 && row == this.row - colorIndex && board.getPiece(col, row + colorIndex) != null) {
            return true;
        }
        return false;
    }


}
