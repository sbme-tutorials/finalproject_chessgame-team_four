import java.util.LinkedList;

public class InitialPieces{
    public static LinkedList<Piece> ps;
    public InitialPieces(LinkedList<Piece> ps) {

        Piece wrook1 = new Piece(4, 7, true, "rook", ps);
        Piece wknight1 = new Piece(5, 7, true, "knight", ps);
        Piece wbishop1 = new Piece(6, 7, true, "bishop", ps);
        Piece wqueen = new Piece(7, 7, true, "queen", ps);
        Piece wking = new Piece(8, 7, true, "king", ps);
        Piece wbishop2 = new Piece(9, 7, true, "bishop", ps);
        Piece wknight2 = new Piece(10, 7, true, "knight", ps);
        Piece wrook2 = new Piece(11, 7, true, "rook", ps);
        Piece wpawn1 = new Piece(4, 6, true, "pawn", ps);
        Piece wpawn2 = new Piece(5, 6, true, "pawn", ps);
        Piece wpawn3 = new Piece(6, 6, true, "pawn", ps);
        Piece wpawn4 = new Piece(7, 6, true, "pawn", ps);
        Piece wpawn5 = new Piece(8, 6, true, "pawn", ps);
        Piece wpawn6 = new Piece(9, 6, true, "pawn", ps);
        Piece wpawn7 = new Piece(10, 6, true, "pawn", ps);
        Piece wpawn8 = new Piece(11, 6, true, "pawn", ps);

        Piece brook1 = new Piece(4, 0, false, "rook", ps);
        Piece bknight1 = new Piece(5, 0, false, "knight", ps);
        Piece bbishop1 = new Piece(6, 0, false, "bishop", ps);
        Piece bqueen = new Piece(7, 0, false, "queen", ps);
        Piece bking = new Piece(8, 0, false, "king", ps);
        Piece bbishop2 = new Piece(9, 0, false, "bishop", ps);
        Piece bknight2 = new Piece(10, 0, false, "knight", ps);
        Piece brook2 = new Piece(11, 0, false, "rook", ps);
        Piece bpawn1 = new Piece(4, 1, false, "pawn", ps);
        Piece bpawn2 = new Piece(5, 1, false, "pawn", ps);
        Piece bpawn3 = new Piece(6, 1, false, "pawn", ps);
        Piece bpawn4 = new Piece(7, 1, false, "pawn", ps);
        Piece bpawn5 = new Piece(8, 1, false, "pawn", ps);
        Piece bpawn6 = new Piece(9, 1, false, "pawn", ps);
        Piece bpawn7 = new Piece(10, 1, false, "pawn", ps);
        Piece bpawn8 = new Piece(11, 1, false, "pawn", ps);
    }
    public InitialPieces(){
    }
}
