package Board;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Board.Board;
import Pieces.*;
import Game.*;
import Board.*;
import Frames.*;

public class Frame extends JFrame {
    public static JFrame frame = new JFrame();
    public Frame() throws IOException{

        BufferedReader br = new BufferedReader(new FileReader("player.txt"));
        String line;
        String lastLine = "";
        String[] fields = new String[0];
        while ((line = br.readLine()) != null) {
            fields = line.split(", ");
            lastLine = line;
        }
        br.close();

        frame.setLayout(new GridBagLayout());
        frame.setMinimumSize(new Dimension(1000, 1000));
        frame.setResizable(true);
        frame.setTitle("Chess Game.Game");
        ImageIcon logo = new ImageIcon("src/Resources/chess_logo.jpg");
        frame.setIconImage(logo.getImage());
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(0x4C514E));
        Board board=new Board();


        //black player panel
        JLabel black_player_label = new JLabel();
        black_player_label.setText(fields[2]);
        black_player_label.setFont(new Font("MV Boli", Font.PLAIN, 30));

        JPanel black_player_panel = new JPanel();
        black_player_panel.add(black_player_label);
        black_player_panel.setBackground(new Color(0x4C514E));

        //white player panel
        JLabel white_player_label = new JLabel();
        white_player_label.setText(fields[1]);
        white_player_label.setFont(new Font("MV Boli", Font.PLAIN, 30));

        JPanel white_player_panel = new JPanel();
        white_player_panel.add(white_player_label);
        white_player_panel.setBackground(new Color(0x4C514E));

        //timer panel
        BlackTimer blackTimer=new BlackTimer();
        blackTimer.timer.stop();
        JPanel bPanel= new JPanel();
        bPanel.setLayout(new BorderLayout());
        bPanel.add(blackTimer,BorderLayout.WEST);

        WhiteTimer timerDemo=new WhiteTimer();
        WhiteTimer.timer.start();
        JPanel timerPanel=new JPanel();
        timerPanel.setLayout(new BorderLayout());
        timerPanel.setBackground(new Color(0x4C514E));
        timerPanel.add(timerDemo,BorderLayout.EAST);
        timerPanel.add(blackTimer,BorderLayout.WEST);

        // panel el foo2
        JPanel player_panel = new JPanel();
        player_panel.setLayout(new BorderLayout());
        player_panel.setBackground(new Color(0x4C514E));
        player_panel.add(white_player_panel, BorderLayout.LINE_END);
        player_panel.add(timerPanel, BorderLayout.CENTER);
        player_panel.add(black_player_panel, BorderLayout.LINE_START);


        //Borders
        JLabel borders_label = new JLabel();
        ImageIcon icon = new ImageIcon("src/Resources/borders_chess.jpg");
        borders_label.setIcon(icon);
        JPanel borders_panel = new JPanel();
        borders_panel.add(borders_label);

        //Layered panel for borders
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(734, 734));
        layeredPane.add(borders_panel, JLayeredPane.DEFAULT_LAYER);
        borders_panel.setBounds(-1, -5, 735, 740);
        layeredPane.add(board, JLayeredPane.PALETTE_LAYER);
        board.setBounds(27, 27, 680, 680);
        layeredPane.setVisible(true);


        //last panel
        JPanel last_panel = new JPanel();
        last_panel.setLayout(new BorderLayout());
        last_panel.add(player_panel,BorderLayout.NORTH);
        last_panel.add(Board.wKilled_panel, BorderLayout.EAST);
        last_panel.add(layeredPane, BorderLayout.CENTER);
        last_panel.add(Board.bKilled_panel, BorderLayout.WEST);

        frame.add(last_panel);
        frame.pack();
        frame.setVisible(true);
    }
}
