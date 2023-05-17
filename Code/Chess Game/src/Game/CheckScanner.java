package Game;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

            return true;  // Move does not protect the king, in check
        }
        else {
            System.out.println("un checked");
        }
        return false;  // King is not under attack
    }

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
        Boolean protect=false;
        for(Piece p: Board.piecelist) {
            if ( board.sameTeam(p, king)){
                for (int r = 0; r < 8; r++) {
                    for (int c = 0; c < 8; c++) {
                        Move newMove = new Move(board, board.selectedPiece, c, r);
                        if ( !isKingInCheck(move) && p.isValidMovement(c, r) && !isKingInCheck(newMove) ) {
                            System.out.println(p.name);
                            protect=true;
                        }
                    }
                }
            }
        }
        if (protect){
            return true;
        }
        else {
            BufferedReader br = new BufferedReader(new FileReader("player.txt"));
            String line;
            String lastLine = "";
            fields = new String[0];
            while ((line = br.readLine()) != null) {
                fields = line.split(", ");
                lastLine = line;
            }
            br.close();
            JOptionPane.showMessageDialog(null, "Game.Game over, " + (Game.whiteTurn == false ? "Black" : "White") + " wins!");
            Frame boardFrame = new Frame();
            boardFrame.dispose(); // close the board frame
            ChessScoreBoard chessScore = new ChessScoreBoard(fields[1], fields[2]);
            chessScore.setVisible(true);
        }
        return false;
    }

    private boolean hitByRock(int col, int row, Piece king, int kingCol, int kingRow, int colVal, int rowVal) {
        for (int i = 1; i < 8; i++) {
            if (kingCol + (i * colVal) == col && kingRow + (i * rowVal) == row)
                break;
            Piece piece = board.getPiece(kingCol + (i * colVal), kingRow + (i * rowVal));
            if (piece != null && piece != board.selectedPiece) {
                if (!board.sameTeam(piece, king) && (piece.name.equals("Rook") || (piece.name.equals("Queen")))) {
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
                checkPawnFirstMove(board.getPiece(kingCol, kingRow + colorValFM), king, col, row) ||
                checkPawnFirstMove(board.getPiece(kingCol+1, kingRow + colorValFM), king, col, row)||
                checkPawnFirstMove(board.getPiece(kingCol-1, kingRow + colorValFM), king, col, row);
    }

    private boolean checkPawn(Piece p, Piece k, int col, int row) {
        return p != null && !board.sameTeam(p, k) && p.name.equals("Pawn");
    }

    private boolean checkPawnFirstMove(Piece p, Piece k, int col, int row) {
        if (p!=null) {
            int colorVal=p.is_white?1:-1;
            return p != null && !board.sameTeam(p, k) && p.name.equals("Pawn") && p.isFirstMove && board.getPiece(col,row+colorVal)==null;
        }
        return false;
    }
}