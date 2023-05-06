import java.awt.image.BufferedImage;

public class Knight extends Piece{
    public Knight(Board board,int col,int row,boolean is_white){
        super(board);
        this.col=col;
        this.row=row;
        this.xPos=col*board.tilesize;
        this.yPos=row* board.tilesize;
        this.is_white=is_white;
        this.name="Knight";
        this.sprite=sheet.getSubimage(3*x_image,is_white?0:y_image,x_image,y_image).getScaledInstance(board.tilesize,board.tilesize, BufferedImage.SCALE_SMOOTH);
    }
    public boolean isValidMovement(int col, int row){
        int x_diff = Math.abs(col - this.col);
        int y_diff = Math.abs(row - this.row);

        if((x_diff == 2 && y_diff == 3) || (x_diff == 3 && y_diff == 2)){
            return true; // valid L-shaped move
        }

        return false; // invalid move
    }
}
