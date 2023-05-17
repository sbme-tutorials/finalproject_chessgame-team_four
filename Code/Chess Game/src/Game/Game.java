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

    public static String[] fields;
    public static Player whitePlayer;
    public static Player blackPlayer;
    public static boolean whiteTurn=true;
    public Game() throws IOException {
        //new Frame();
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

}
