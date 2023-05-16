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

public class CheckScanner {
    Board board;
    public static String[] fields;
    public CheckScanner(Board board) {
        this.board = board;
    }

    public boolean isKingChecked(Move move) {
        Piece king = board.findKing(move.piece.is_white);
        assert king != null;

        int kingCol;
        int kingRow;
        if (board.selectedPiece != null && board.selectedPiece.name.equals("King")) {
            kingCol = move.newCol;
            kingRow = move.newRow;
            if (hitByRock(move.newCol, move.newRow, king, kingCol, kingRow, 0, 1) ||
                    hitByRock(move.newCol, move.newRow, king, kingCol, kingRow, 1, 0) ||
                    hitByRock(move.newCol, move.newRow, king, kingCol, kingRow, 0, -1) ||
                    hitByRock(move.newCol, move.newRow, king, kingCol, kingRow, -1, 0) ||
                    hitByBishop(move.newCol, move.newRow, king, kingCol, kingRow, -1, -1) ||
                    hitByBishop(move.newCol, move.newRow, king, kingCol, kingRow, 1, -1) ||
                    hitByBishop(move.newCol, move.newRow, king, kingCol, kingRow, 1, 1) ||
                    hitByBishop(move.newCol, move.newRow, king, kingCol, kingRow, -1, 1) ||
                    hitByQueen(move.newCol, move.newRow, king, kingCol, kingRow, -1, -1) ||
                    hitByQueen(move.newCol, move.newRow, king, kingCol, kingRow, 1, -1) ||
                    hitByQueen(move.newCol, move.newRow, king, kingCol, kingRow, 1, 1) ||
                    hitByQueen(move.newCol, move.newRow, king, kingCol, kingRow, -1, 1) ||
                    hitByKnight(move.newCol, move.newRow, king, kingCol, kingRow) ||
                    hitByPawn(move.newCol, move.newRow, king, kingCol, kingRow) ||
                    hitByKing(king, kingCol, kingRow)) {
                kingCol = king.col;
                kingRow = king.row;
           /* if (hitByRock(move.newCol, move.newRow, king, kingCol, kingRow, 0, 1) ||
                    hitByRock(move.newCol, move.newRow, king, kingCol, kingRow, 1, 0) ||
                    hitByRock(move.newCol, move.newRow, king, kingCol, kingRow, 0, -1) ||
                    hitByRock(move.newCol, move.newRow, king, kingCol, kingRow, -1, 0) ||
                    hitByBishop(move.newCol, move.newRow, king, kingCol, kingRow, -1, -1) ||
                    hitByBishop(move.newCol, move.newRow, king, kingCol, kingRow, 1, -1) ||
                    hitByBishop(move.newCol, move.newRow, king, kingCol, kingRow, 1, 1) ||
                    hitByBishop(move.newCol, move.newRow, king, kingCol, kingRow, -1, 1) ||
                    hitByQueen(move.newCol, move.newRow, king, kingCol, kingRow, -1, -1) ||
                    hitByQueen(move.newCol, move.newRow, king, kingCol, kingRow, 1, -1) ||
                    hitByQueen(move.newCol, move.newRow, king, kingCol, kingRow, 1, 1) ||
                    hitByQueen(move.newCol, move.newRow, king, kingCol, kingRow, -1, 1) ||
                    hitByKnight(move.newCol, move.newRow, king, kingCol, kingRow) ||
                    //hitByPawn(move.newCol, move.newRow, king, kingCol, kingRow) ||
                    hitByKing(king, kingCol, kingRow)) {
                return true;
            }*/
                return true;
            }

        }
        return false;
    }
    public boolean isKingInCheck(Move move) {
        Piece king = board.findKing(move.piece.is_white);
        assert king != null;
        int kingCol = king.col;
        int kingRow = king.row;

        if (hitByRock(move.newCol, move.newRow, king, kingCol, kingRow, 0, 1) ||
                hitByRock(move.newCol, move.newRow, king, kingCol, kingRow, 1, 0) ||
                hitByRock(move.newCol, move.newRow, king, kingCol, kingRow, 0, -1) ||
                hitByRock(move.newCol, move.newRow, king, kingCol, kingRow, -1, 0) ||
                hitByBishop(move.newCol, move.newRow, king, kingCol, kingRow, -1, -1) ||
                hitByBishop(move.newCol, move.newRow, king, kingCol, kingRow, 1, -1) ||
                hitByBishop(move.newCol, move.newRow, king, kingCol, kingRow, 1, 1) ||
                hitByBishop(move.newCol, move.newRow, king, kingCol, kingRow, -1, 1) ||
                hitByQueen(move.newCol, move.newRow, king, kingCol, kingRow, -1, -1) ||
                hitByQueen(move.newCol, move.newRow, king, kingCol, kingRow, 1, -1) ||
                hitByQueen(move.newCol, move.newRow, king, kingCol, kingRow, 1, 1) ||
                hitByQueen(move.newCol, move.newRow, king, kingCol, kingRow, -1, 1) ||
                hitByKnight(move.newCol, move.newRow, king, kingCol, kingRow) ||
                hitByPawn(move.newCol, move.newRow, king, kingCol, kingRow) ||
                hitByKing(king, kingCol, kingRow)) {
            // The king is under attack
            // Check if the move protects the king
            /*if (isMoveProtectingKing(move, kingCol, kingRow)) {
                return false;  // Move protects the king, not in check
            }*/
            System.out.println("checked");
            return true;  // Move does not protect the king, in check

        }

        return false;  // King is not under attack
    }
//boolean temp=isKingInCheck(move);
    public boolean check (Move move) throws IOException {
        Piece king = board.findKing(move.piece.is_white);
        assert king != null;
        int kingCol = king.col;
        int kingRow = king.row;
        if (isMoveProtectingKing(move, kingCol, kingRow)) {
            return false;  // Move protects the king, not in check
        }
        return true;
    }
    public boolean isMoveProtectingKing(Move move, int kingCol, int kingRow) throws IOException {
        Piece king = board.findKing(move.piece.is_white);
        assert king != null;
        for(Piece p: Board.piecelist) {
            if ( board.sameTeam(p, king)){
                for (int r = 0; r < 8; r++) {
                    for (int c = 0; c < 8; c++) {
                        if (p.isValidMovement(c, r) && !isKingInCheck(move)) {
                            return true;
                            //p.Board.isValidMove(move)==true;

                        }
                    }
                }
            }
        }
        BufferedReader br = new BufferedReader(new FileReader("player.txt"));
        String line;
        String lastLine = "";
        fields = new String[0];
        while ((line = br.readLine()) != null) {
            fields = line.split(", ");
            lastLine = line;
        }
        br.close();
        JOptionPane.showMessageDialog(null, "Game.Game over, " + (Game.whiteTurn == true ? "Black" : "White") + " wins!");
        Frame boardFrame = new Frame();
        boardFrame.dispose(); // close the board frame
        ChessScoreBoard chessScore = new ChessScoreBoard(fields[1],fields[2]);
        chessScore.setVisible(true);
        return false;
    }

 /*   private boolean isMoveProtectingKing(Move move, int kingCol, int kingRow) {
        int destCol = move.newCol;
        int destRow = move.newRow;

        // Check if the move blocks the attack path of a sliding piece (rook, bishop, queen)
        if (isSlidingPieceAttack(move.piece, kingCol, kingRow, destCol, destRow)) {
            if (!isPathObstructed(move.piece, kingCol, kingRow, destCol, destRow)) {
                return true;  // Move blocks the attack path, protects the king
            }
        }

        // Check if the move captures the attacking piece
        if (isCapturingAttacker(move.piece, destCol, destRow)) {
            return true;  // Move captures the attacking piece, protects the king
        }

        // Check if the move interposes between the attacking piece and the king
        if (isInterposing(move.piece, kingCol, kingRow, destCol, destRow)) {
            return true;  // Move interposes, protects the king
        }

        // Move does not protect the king
        return false;
    }
    private boolean isSlidingPieceAttack(Piece piece, int kingCol, int kingRow, int destCol, int destRow) {
        if (piece instanceof Rook || piece instanceof Bishop || piece instanceof Queen) {
            return (kingCol == destCol || kingRow == destRow || Math.abs(kingCol - destCol) == Math.abs(kingRow - destRow));
        }
        return false;
    }
    private boolean isPathObstructed(Piece piece, int kingCol, int kingRow, int destCol, int destRow) {
        int colDiff = Integer.compare(destCol, kingCol);
        int rowDiff = Integer.compare(destRow, kingRow);

        int col = kingCol + colDiff;
        int row = kingRow + rowDiff;

        while (col != destCol || row != destRow) {
            if (board.getPiece(col, row) != null) {
                return true;  // Path is obstructed
            }
            col += colDiff;
            row += rowDiff;
        }

        return false;  // Path is not obstructed
    }
    private boolean isCapturingAttacker(Piece piece, int destCol, int destRow) {
        Piece attacker = board.getPiece(destCol, destRow);
        return (attacker != null && attacker.is_white != piece.is_white);
    }
    private boolean isInterposing(Piece piece, int kingCol, int kingRow, int destCol, int destRow) {
        int colDiff = Integer.compare(destCol, kingCol);
        int rowDiff = Integer.compare(destRow, kingRow);

        int col = kingCol + colDiff;
        int row = kingRow + rowDiff;

        while (col != destCol || row != destRow) {
            if (isPieceAttacking(piece, col, row, kingCol, kingRow)) {
                return true;  // Piece can interpose, protects the king
            }
            col += colDiff;
            row += rowDiff;
        }

        return false;  // Piece cannot interpose
    }
    private boolean isPieceAttacking(Piece piece, int pieceCol, int pieceRow, int kingCol, int kingRow) {
        Move move = new Move( board, piece,  kingCol,  kingRow); //Move(Board board, Piece piece, int newCol, int newRow){
        return board.isValidMove(move);
    }*/
    static void KingIsDead (Move move) throws IOException {
        //  Game.checkKingStatus(move);
        // King king = null;
  /*  for (Piece piece : Board.piecelist) {
        if (piece instanceof King) {
            king = (King) piece;
            break;
        }
    } */
        if (move.capture != null && move.capture.name.equals("King")) {
            Game.gameOver= true;
        }

  /*  if (king == null) {
        // No king found, do something else
        return;
    } */

    }
    private boolean hitByRock(int col, int row, Piece king, int kingCol, int kingRow, int colVal, int rowVal) {
        for (int i = 1; i < 8; i++) {
            if (kingCol + (i * colVal) == col && kingRow + (i * rowVal) == row)
                break;
            Piece piece = board.getPiece(kingCol + (i * colVal), kingRow + (i * rowVal));
            if (piece != null && piece != board.selectedPiece) {
                if (!board.sameTeam(piece, king) && (piece.name.equals("Rock") || (piece.name.equals("Queen")))) {
                    return true;
                }
                break;
            }


        }
        return false;
    }

    private boolean hitByBishop(int col, int row, Piece king, int kingCol, int kingRow, int colVal, int rowVal) {
        for (int i = 1; i < 4; i++) {
            if (kingCol - (i * colVal) == col && kingRow - (i * rowVal) == row)
                break;
            Piece piece = board.getPiece(kingCol - (i * colVal), kingRow - (i * rowVal));
            if (piece != null && piece != board.selectedPiece) {
                if (!board.sameTeam(piece, king) && (piece.name.equals("Bishop"))) {
                    return true;
                }
            }


        }
        if (kingCol - 1 == col || kingCol + 1 == col) {
            Piece piece = board.getPiece(col, row);
            if (piece != null && piece != board.selectedPiece && board.sameTeam(piece, king) && piece.name.equals("Bishop")) {
                return true;
            }
        }
        return false;
    }

    private boolean hitByQueen(int col, int row, Piece king, int kingCol, int kingRow, int colVal, int rowVal) {
        for (int i = 1; i < 8; i++) {
            if (kingCol - (i * colVal) == col && kingRow - (i * rowVal) == row)
                break;
            Piece piece = board.getPiece(kingCol - (i * colVal), kingRow - (i * rowVal));
            if (piece != null && piece != board.selectedPiece) {
                if (!board.sameTeam(piece, king) && (piece.name.equals("Queen"))) {
                    return true;
                }
                break;
            }


        }
        return false;
    }

    private boolean hitByKnight(int col, int row, Piece king, int kingCol, int kingRow) {
        return checkKnight(board.getPiece(kingCol - 2, kingRow - 3), king, col, row) ||
                checkKnight(board.getPiece(kingCol - 3, kingRow - 2), king, col, row) ||
                checkKnight(board.getPiece(kingCol + 3, kingRow - 2), king, col, row) ||
                checkKnight(board.getPiece(kingCol + 2, kingRow - 3), king, col, row) ||
                checkKnight(board.getPiece(kingCol + 2, kingRow + 3), king, col, row) ||
                checkKnight(board.getPiece(kingCol + 3, kingRow + 2), king, col, row) ||
                checkKnight(board.getPiece(kingCol - 3, kingRow + 2), king, col, row) ||
                checkKnight(board.getPiece(kingCol - 2, kingRow + 3), king, col, row);

    }

    private boolean checkKnight(Piece p, Piece k, int col, int row) {
        return p != null && !board.sameTeam(p, k) && p.name.equals("Knight") && !(p.col == col && p.row == row);
    }

    private boolean hitByKing(Piece king, int kingCol, int kingRow) {
        return checkKing(board.getPiece(kingCol - 1, kingRow - 1), king) ||
                checkKing(board.getPiece(kingCol + 1, kingRow - 1), king) ||
                checkKing(board.getPiece(kingCol, kingRow - 1), king) ||
                checkKing(board.getPiece(kingCol - 1, kingRow), king) ||
                checkKing(board.getPiece(kingCol + 1, kingRow), king) ||
                checkKing(board.getPiece(kingCol - 1, kingRow + 1), king) ||
                checkKing(board.getPiece(kingCol + 1, kingRow + 1), king) ||
                checkKing(board.getPiece(kingCol, kingRow + 1), king);


    }

    private boolean checkKing(Piece p, Piece k) {
        return p != null && !board.sameTeam(p, k) && p.name.equals("King");

    }

    private boolean hitByPawn(int col, int row, Piece king, int kingCol, int kingRow) {
        int colorVal = king.is_white ? -1 : 1;
        int colorValFM = king.is_white ? -2 : 2;
        return checkPawn(board.getPiece(kingCol + 1, kingRow + colorVal), king, col, row) ||
                checkPawn(board.getPiece(kingCol - 1, kingRow + colorVal), king, col, row) ||
                checkPawn(board.getPiece(kingCol, kingRow + colorVal), king, col, row) ||
                checkPawnFirstMove(board.getPiece(kingCol + 1, kingRow + colorValFM), king, col, row) ||
                checkPawnFirstMove(board.getPiece(kingCol - 1, kingRow + colorValFM), king, col, row) ||
                checkPawnFirstMove(board.getPiece(kingCol, kingRow + colorVal), king, col, row) ;


    }

    private boolean checkPawn(Piece p, Piece k, int col, int row) {
        return p != null && !board.sameTeam(p, k) && p.name.equals("Pawn");

    }

    private boolean checkPawnFirstMove(Piece p, Piece k, int col, int row) {
        return p != null && !board.sameTeam(p, k) && p.name.equals("Pawn") && p.isFirstMove;

    }
}