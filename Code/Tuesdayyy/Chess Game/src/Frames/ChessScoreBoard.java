package Frames;
import java.awt.*;
import java.io.*;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
public class ChessScoreBoard extends JFrame {
    private JLabel player1NameLabel;
    private JLabel player2NameLabel;
    private JLabel player1ScoreLabel;
    private JLabel player2ScoreLabel;
    private JLabel winnerLabel;

    public ChessScoreBoard(String player1Name, String player2Name) throws FileNotFoundException {
        super("Chess Score Board.Board");

        setSize(new Dimension(2000, 900));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the main panel for the score board
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(Color.darkGray);
        add(mainPanel);

        // Create the panels for the player names and scores
        JPanel player1Panel = createPlayerPanel(player1Name, true);
        JPanel player2Panel = createPlayerPanel(player2Name, false);

        // Add the player panels to the main panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(player1Panel, gbc);
        gbc.gridx = 2;
        mainPanel.add(player2Panel, gbc);

        // Create the winner label and add it to the main panel
        winnerLabel = new JLabel();
        winnerLabel.setHorizontalAlignment(JLabel.CENTER);
        winnerLabel.setVerticalAlignment(SwingConstants.CENTER);
        winnerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0;
        mainPanel.add(winnerLabel, gbc);

        // Set the background image of the score board
        /*try {
            final Image backgroundImage = javax.imageio.ImageIO.read(new File("C:\\Users\\user\\Downloads\\X5UcUYz.jpeg"));
            setContentPane(new JPanel(new BorderLayout()) {
                @Override public void paintComponent(Graphics g) {
                    g.drawImage(backgroundImage, 0, 0, null);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
    }

    private JPanel createPlayerPanel(String playerName, boolean isPlayer1) {
        // Create the panel and set its layout
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(255, 255, 255, 255)));
        panel.setBackground(new Color(211, 211, 211, 249));
        panel.setPreferredSize(new Dimension(150, 100));

        // Add the player's name label
        JLabel nameLabel = new JLabel(playerName);
        nameLabel.setHorizontalAlignment(JLabel.CENTER);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        panel.add(nameLabel, gbc);

        // Add the player's score label
        JLabel scoreLabel = new JLabel("Score: 0");
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridy = 1;
        panel.add(scoreLabel, gbc);

        // Set instance variables for the player's name and score labels
        if (isPlayer1) {
            player1NameLabel = nameLabel;
            player1ScoreLabel = scoreLabel;
        } else {
            player2NameLabel = nameLabel;
            player2ScoreLabel = scoreLabel;
        }

        return panel;
    }

    public void updateScore(String winner, int whiteScore, int blackScore) {
        // Display the winner of the game with the color of the winning player
        if (winner.equals("White")) {
            winnerLabel.setText(player1NameLabel.getText() + " wins!");
            winnerLabel.setForeground(Color.WHITE);
        } else if (winner.equals("Black")) {
            winnerLabel.setText(player2NameLabel.getText() + " wins!");
            winnerLabel.setForeground(Color.BLACK);
        } else {
            winnerLabel.setText("Draw!");
            winnerLabel.setForeground(Color.GRAY);
        }

        // Update the scores for each player
        player1ScoreLabel.setText("Score: " + whiteScore);
        player2ScoreLabel.setText("Score: " + blackScore);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("player.txt"));
        String line;
        String lastLine = "";
        String[] fields = new String[0];
        while ((line = br.readLine()) != null) {
            fields = line.split(", ");
            lastLine = line;
        }
        br.close();


        String[] finalFields = fields;
        SwingUtilities.invokeLater(() -> {
            ChessScoreBoard scoreBoard = null;
            try {
                scoreBoard = new ChessScoreBoard(finalFields[1], finalFields[2]);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            scoreBoard.setVisible(true);
            scoreBoard.updateScore("White", 2, 1);
        });
    }
}