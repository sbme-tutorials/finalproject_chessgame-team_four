import java.awt.image.BufferedImage;

public class Bishop extends Piece{
    public Bishop(Board board,int col,int row,boolean is_white){
        super(board);
        this.col=col;
        this.row=row;
        this.xPos=col*board.tilesize;
        this.yPos=row* board.tilesize;
        this.is_white=is_white;
        this.name="Bishop";
        this.sprite=sheet.getSubimage(2*x_image,is_white?0:y_image,x_image,y_image).getScaledInstance(board.tilesize,board.tilesize, BufferedImage.SCALE_SMOOTH);
    }
    public boolean isValidMovement(int col, int row) {
        int colDiff = Math.abs(this.col - col);
        int rowDiff = Math.abs(this.row - row);
        if (colDiff != rowDiff || colDiff > 3) {
            return false;
        }
        if (moveCollidesWithPiece(col, row)) {
            return false;
        }
        return true;
    }

    public boolean moveCollidesWithPiece(int col, int row) {
        int colDirection = col > this.col ? 1 : -1;
        int rowDirection = row > this.row ? 1 : -1;
        int currentCol = this.col + colDirection;
        int currentRow = this.row + rowDirection;
        while (currentCol != col && currentRow != row) {
            if (board.getPiece(currentCol, currentRow) != null) {
                return true;
            }
            currentCol += colDirection;
            currentRow += rowDirection;
        }
        return false;
    }

}

