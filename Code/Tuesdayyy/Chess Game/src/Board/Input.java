package Board;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

import Board.Board;
import Pieces.*;
import Pieces.*;
import Game.*;
import Board.*;
import Frames.*;

public class Input extends MouseAdapter {
    Board board;
    public  boolean cond=true;
    int pressedCol,pressedRow;
    int releasedCol,releasedRow;
    public static ArrayList<Piece> hardPieces=new ArrayList<>();
    public Piece pieceXY;
    int ind=0;
    public  CheckScanner checkScanner;
    public Input(Board board) throws IOException {

        this.board=board;
        checkScanner=new CheckScanner(board);
        this.cond=cond;
        this.ind=ind;
    }
    @Override
    public void mousePressed(MouseEvent e) {


        pressedCol=e.getX()/ board.tilesize;
        pressedRow=e.getY()/ board.tilesize;
        pieceXY= board.getPiece(pressedCol,pressedRow);

        if (pieceXY!=null ) {
            if (Game.isTurn(pieceXY, cond) && cond) {
                board.selectedPiece = pieceXY;
                hardPieces.add(pieceXY);
                ind++;

            } else if (!cond) {
                if ((Game.isTurn(hardPieces.get(ind - 1), cond))) {
                    board.selectedPiece = pieceXY;
                    hardPieces.add(pieceXY);
                    ind++;
                }
            }
        }
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        if (board.selectedPiece != null){
            Move move = new Move(board, board.selectedPiece, pressedCol, pressedRow);
            checkScanner.isKingInCheck(move);
            try {
                checkScanner.check(move);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            board.selectedPiece.xPos=e.getX()- board.tilesize/2;
            board.selectedPiece.yPos=e.getY()- board.tilesize/2;
            board.repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        releasedCol=e.getX()/ board.tilesize;
        releasedRow=e.getY()/ board.tilesize;
        if (board.selectedPiece != null) {
            Move move = new Move(board, board.selectedPiece, releasedCol, releasedRow);

            if (board.isValidMove(move)) {
                try {
                    board.makeMove(move);
                } catch (UnsupportedAudioFileException ex) {
                    throw new RuntimeException(ex);
                } catch (LineUnavailableException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            } else {
                board.selectedPiece.xPos = board.selectedPiece.col * board.tilesize;
                board.selectedPiece.yPos = board.selectedPiece.row * board.tilesize;
            }

          /*  if (( releasedCol == pressedCol ) && ( releasedRow == pressedRow )) {
                cond = false;
            }
            else {
                cond=true;
            }*/
            if (( pieceXY.col == pressedCol ) && ( pieceXY.row == pressedRow )) {
                cond=false;
            }
            else{
                cond=true;
            }

        }

        board.selectedPiece=null;
        board.repaint();
    }
}