
import java.io.IOException;
import java.util.LinkedList;
public class Main {
    public static LinkedList<Piece> ps=new LinkedList<>();
    public static void main(String[] args) throws IOException {
        new InitialPieces(ps);
        new Board(ps);

    }
}