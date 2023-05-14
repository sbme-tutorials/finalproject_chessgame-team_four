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



    public boolean isInChecked(Move move) {
        return inCheck;
    }

    public boolean hasWone( Move move) {
        if(isInChecked(move))
            return true;
        return false;
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


    public int getScore() {
        return score;
    }

    public void incrementScore(){
        // if the player win
        score+=100;
    }

    public void resetScore() {
        score=0;
    }

    public void getPlayerPieces(){
        for(Piece p:Board.piecelist){
            if(p.is_white){
                Board.whitePieceList.add(p);
            }
            else
                Board.blackPieceList.add(p);
        }
    }

}