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
    public boolean isValidMovement(int col,int row){
        return Math.abs(this.col-col)==Math.abs(this.row-row);
    }
    public boolean moveCollidesWithPiece(int col,int row){
        //up left
        if (this.col>col && this.row>row)
            for (int i = 1; i<Math.abs(this.col-col);i++)
                if (board.getPiece(this.col-i,this.row-i)!=null)
                    return true;

        // up right
        if (this.col<col && this.row>row)
            for (int i = 1; i<Math.abs(this.col-col);i++)
                if (board.getPiece(this.col+i,this.row-i)!=null)
                    return true;

        //down left
        if (this.col>col && this.row<row)
            for (int i = 1; i<Math.abs(this.col-col);i++)
                if (board.getPiece(this.col-i,this.row+i)!=null)
                    return true;

        // down right
        if (this.col<col && this.row<row)
            for (int i = 1; i<Math.abs(this.col-col);i++)
                if (board.getPiece(this.col+i,this.row+i)!=null)
                    return true;


        return false;

    }

}

