package Game;

import Board.Board;
import Pieces.*;
import Game.*;
import Board.*;
import Frames.*;
public class Player {
    static String color;
    String name;
    boolean inCheck;
    double totalTimeSpent;
    Piece piece;
    int score;

    public Player(String color, String name) {
        this.color = color;
        this.name = name;
        inCheck = false;
        totalTimeSpent = 0.0;
        score = 0;
    }
    public double getTotalTimeSpent() {
        return totalTimeSpent;
    }
    public void setTotalTimeSpent(double totalTimeSpent) {
        this.totalTimeSpent = totalTimeSpent;
    }

    public String getColor() {
        if(piece.is_white){
            return "White";
        }
        else
            return "Black";
    }
    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}