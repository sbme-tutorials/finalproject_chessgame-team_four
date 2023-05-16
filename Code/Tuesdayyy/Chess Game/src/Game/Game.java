package Game;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Board.Board;
import Pieces.*;
import Board.*;
import Frames.*;

public class Game {
    public static ArrayList<Piece> piecelist = new ArrayList<>();
    static boolean gameOver=false;
    //static Board board;
    public static CheckScanner checkScanner;
    public static String[] fields;
    static int turn=1;
    public static Player whitePlayer;
    public static Player blackPlayer;
    public static boolean whiteTurn=true;
    public Game() throws IOException {
        new Frame();
        BufferedReader br = new BufferedReader(new FileReader("player.txt"));
        String line;
        String lastLine = "";
        fields = new String[0];
        while ((line = br.readLine()) != null) {
            fields = line.split(", ");
            lastLine = line;
        }
        br.close();
        whitePlayer=new Player("White",fields[1]);
        blackPlayer=new Player("Black",fields[2]);
    }

    public static boolean isTurn(Piece p , boolean cond){

        if(!cond) {
            whiteTurn = !whiteTurn;
        }
        if ( p.is_white && whiteTurn) {
            whiteTurn=false;
            return true;
        }
        else if( !p.is_white && !whiteTurn ) {
            whiteTurn=true;
            return true;
        }
        return false;
    }

    /*public static void checkKingStatus() throws IOException {

        Pieces.King king = null;
        for (Pieces.Piece piece : piecelist) {
            if (piece instanceof Pieces.King ) {
                king = (Pieces.King) piece;
                break;
            }
        }

        if (king == null) {
            // No king found, do something else
            return;
        }


        boolean canMoveKing ;

        if (checkScanner.isKingChecked(new Board.Move(board,king, king.col, king.row))) {
            // Pieces.King is checked

            canMoveKing = false;

            // Check if king can move to a safe location
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    int newCol = king.col + i;
                    int newRow = king.row + j;
                    if (newCol >= board.BOARD_SIZE || newRow >= board.BOARD_SIZE || newCol < 0 || newRow < 0) {
                        continue;
                    }
                    Board.Move newMove = new Board.Move(board, king, newCol, newRow);
                    if (!checkScanner.isKingChecked(newMove)) {
                        canMoveKing = true;
                        break;
                    }
                }
                if (canMoveKing) {
                    break;
                }
            }
        }
        else canMoveKing= true;
        if (!canMoveKing) {
            // Pieces.King cannot move to a safe location, game over
            gameOver = true;
            Board.Frame frame=new Board.Frame();
            frame.dispose();
            System.out.println("Game.Game over, " + (Game.Game.turn==1? "Black" : "White") + " wins!");
        }*/


 /*   public static boolean isKingCanBeKilled(Move move) {
        Piece king = Board.findKing(move.piece.is_white);
        assert king != null;

        int kingCol;
        int kingRow;
        if (CheckScanner.board.selectedPiece != null && CheckScanner.board.selectedPiece.name.equals("King")) {
            kingCol = move.newCol;
            kingRow = move.newRow;
            if (checkScanner.hitByRock(move.newCol, move.newRow, king, kingCol, kingRow, 0, 1) ||
                    checkScanner.hitByRock(move.newCol, move.newRow, king, kingCol, kingRow, 1, 0) ||
                    checkScanner.hitByRock(move.newCol, move.newRow, king, kingCol, kingRow, 0, -1) ||
                    checkScanner.hitByRock(move.newCol, move.newRow, king, kingCol, kingRow, -1, 0) ||
                    checkScanner.hitByBishop(move.newCol, move.newRow, king, kingCol, kingRow, -1, -1) ||
                    checkScanner.hitByBishop(move.newCol, move.newRow, king, kingCol, kingRow, 1, -1) ||
                    checkScanner.hitByBishop(move.newCol, move.newRow, king, kingCol, kingRow, 1, 1) ||
                    checkScanner.hitByBishop(move.newCol, move.newRow, king, kingCol, kingRow, -1, 1) ||
                    checkScanner.hitByQueen(move.newCol, move.newRow, king, kingCol, kingRow, -1, -1) ||
                    checkScanner.hitByQueen(move.newCol, move.newRow, king, kingCol, kingRow, 1, -1) ||
                    checkScanner.hitByQueen(move.newCol, move.newRow, king, kingCol, kingRow, 1, 1) ||
                    checkScanner.hitByQueen(move.newCol, move.newRow, king, kingCol, kingRow, -1, 1) ||
                    checkScanner.hitByKnight(move.newCol, move.newRow, king, kingCol, kingRow) ||
                    //hitByPawn(move.newCol, move.newRow, king, kingCol, kingRow) ||
                    checkScanner.hitByKing(king, kingCol, kingRow)) {
                System.out.println("heree");
                return true;
            }
        }
        return false;
    }
*/
    /*public static void checkMate(Move move){
        System.out.println("innn");
        Boolean checked=CheckScanner.isKingInCheck(move);
        if (checked){
            System.out.println("theree");
            for(Piece p: piecelist){
                if (whiteTurn) {
                    for (int r = 0; r < 8; r++) {
                        for (int c = 0; c < 8; c++) {
                            if (p.isValidMovement(c, r)) {

                                checked = isKingCanBeKilled(move);

                                if (checked == false)
                                    break;

                            }
                        }
                    }
                }
            }

            if (checked) {
                //then king can't save himself and his team can't save him "GAMEOVER"
                System.out.println("game over");
            }

        }
    }
*/




    public static void checkKingStatus(Move move) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("player.txt"));
        String line;
        String lastLine = "";
        fields = new String[0];
        while ((line = br.readLine()) != null) {
            fields = line.split(", ");
            lastLine = line;
        }
        br.close();
        CheckScanner.KingIsDead(move);
        // check if the game is over
        if (Game.gameOver) {
            JOptionPane.showMessageDialog(null, "Game.Game over, " + (Game.whiteTurn == true ? "Black" : "White") + " wins!");
            Frame boardFrame = new Frame();
            boardFrame.dispose(); // close the board frame
            ChessScoreBoard chessScore = new ChessScoreBoard(fields[1],fields[2]);
            chessScore.setVisible(true);
        }
    }
}
