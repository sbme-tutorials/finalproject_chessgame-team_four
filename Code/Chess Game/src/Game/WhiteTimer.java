package Game;


import Board.Board;
import Frames.ChessScoreBoard;
import Pieces.Piece;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import static Game.Game.fields;

public class WhiteTimer extends JPanel {
    public static JLabel timeLabel;
    public static Timer timer;
    private static int secondsLeft;
    static boolean iswhiteturn;

    public WhiteTimer() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("player.txt"));
        String line;
        String lastLine = "";
        String[] fields = new String[0];
        while ((line = br.readLine()) != null) {
            fields = line.split(", ");
            lastLine = line;
        }
        br.close();
        timeLabel = new JLabel("00:00");
        this.add(timeLabel);
        timeLabel.setForeground(Color.white);
        timeLabel.setFont(new Font("MV Boli",Font.PLAIN,30));
        this.setBackground(new Color(0xBDB7A7));
        int time = Integer.parseInt(fields[0])*60;
        secondsLeft = time;
        startTimer();
    }

    private static void startTimer() {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secondsLeft--;
                if (secondsLeft <= 0) {
                    try {
                        theTimeEnd();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                } else {
                    int min = secondsLeft / 60;
                    int sec = secondsLeft % 60;
                    timeLabel.setText(String.format("%02d:%02d", min, sec));
                    iswhiteturn = true;
                }
            }
        };
        timer = new Timer(1000, listener);
        timer.start();
    }

    public static void theTimeEnd() throws IOException {
        WhiteTimer.timer.stop();
        JOptionPane.showMessageDialog(null, "Game.Game over, " + (fields[2]) + " wins!");
        Frame boardFrame = new Frame();
        boardFrame.dispose(); // close the board frame
        ChessScoreBoard chessScore = new ChessScoreBoard(fields[1],fields[2]);
        chessScore.setVisible(true);
    }
}
