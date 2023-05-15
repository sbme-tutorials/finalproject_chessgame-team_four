package Pieces;

import Board.Board;
import Pieces.Piece;
import Pieces.*;
import Game.*;
import Board.*;
import Frames.*;

import java.awt.image.BufferedImage;
public class King extends Piece{
    public King(Board board, int col, int row, boolean is_white){
        super(board);
        this.col=col;
        this.row=row;
        this.xPos=col*board.tilesize;
        this.yPos=row* board.tilesize;
        this.is_white=is_white;
        this.name="Pieces.King";
        this.sprite=sheet.getSubimage(0,is_white?0:y_image,x_image,y_image).getScaledInstance(board.tilesize,board.tilesize, BufferedImage.SCALE_SMOOTH);
    }
    public boolean isValidMovement(int col,int row){
        return Math.abs((col-this.col)*(row-this.row)) == 1 || Math.abs(col-this.col)+Math.abs(row-this.row) == 1 || canCastle(col,row);
    }
    private boolean canCastle(int col,int row){
        if (this.row==row){
            if (col==6){
                Piece rock=board.getPiece(7,row);
                if (rock!=null&& rock.isFirstMove && isFirstMove){
                    return board.getPiece(5,row)==null &&
                            board.getPiece(6,row)==null &&
                            board.checkScanner.isKingChecked(new Move(board,this,5,row));
                }
            }else if (col==2){
                Piece rock=board.getPiece(0,row);
                if (rock!=null&& rock.isFirstMove && isFirstMove){
                    return board.getPiece(3,row)==null &&
                            board.getPiece(2,row)==null &&
                            board.getPiece(1,row)==null &&
                            board.checkScanner.isKingChecked(new Move(board,this,3,row));
                }
            }
        }
        return false;
    }
}

