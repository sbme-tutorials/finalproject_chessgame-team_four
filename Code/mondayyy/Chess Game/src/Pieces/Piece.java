package Pieces;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import Pieces.*;
import Game.*;
import Board.*;
import Pieces.*;
import Game.*;
import Board.*;
import Frames.*;
public class Piece {
    public int col,row;
    public int xPos,yPos;
    public boolean is_white;
    public String name;
    public int value;
    public boolean isFirstMove=true;

    BufferedImage sheet;
    {
        try {
            sheet= ImageIO.read(ClassLoader.getSystemResourceAsStream("Resources/pieces.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    protected int x_image=sheet.getWidth()/6;
    protected int y_image=sheet.getHeight()/2;
    Image sprite;
    Board board;

    public  Piece(Board board){
        this.board=board;
    }


    public boolean isValidMovement(int col,int row){
        return true;
    }
    public boolean moveCollidesWithPiece(int col,int row){
        return false;
    }
    public void paint(Graphics2D g2d){

        g2d.drawImage(sprite,xPos,yPos,null);
    }
    Piece(){
    }

    
}
