import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame();
        frame.setLayout(new GridBagLayout());
        frame.setPreferredSize(new Dimension(1000, 1000));
        frame.setTitle("Chess Game");
        frame.setMinimumSize(new Dimension(1000, 1000));
        ImageIcon logo= new ImageIcon("src/chess_logo.jpg");
        frame.setIconImage(logo.getImage());
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        Board board=new Board();

        /*JLabel black_player_label=new JLabel();
        black_player_label.setText("BLACK PLAYER");
        black_player_label.setFont(new Font("MV Boli",Font.PLAIN,25));

        JPanel black_player_panel=new JPanel();
        black_player_panel.setBounds(0,0,400,30);
        black_player_panel.add(black_player_label);

        JLabel white_player_label=new JLabel();
        white_player_label.setText("WHITE PLAYER ");
        white_player_label.setFont(new Font("MV Boli",Font.PLAIN,25));

        JPanel white_player_panel=new JPanel();
        white_player_panel.setBounds(800,0,400,30);
        white_player_panel.add(white_player_label);

        JPanel player_panel=new JPanel();
        player_panel.add(white_player_panel);
        player_panel.add(black_player_panel,BorderLayout.LINE_START);*/


        JLabel borders_label=new JLabel();
        ImageIcon icon=new ImageIcon("src/borders_chess.jpg");
        borders_label.setIcon(icon);
        JPanel borders_panel=new JPanel();
        borders_panel.add(borders_label);


        JLayeredPane layeredPane =new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(734, 734));
        layeredPane.add(borders_panel,JLayeredPane.DEFAULT_LAYER);
        borders_panel.setBounds(-1,-5,735,740);
        layeredPane.add(board,JLayeredPane.PALETTE_LAYER);
        board.setBounds(27,27,680,680);
        layeredPane.setVisible(true);


        JPanel last_panel = new JPanel();
        last_panel.setLayout(new BorderLayout());
        last_panel.add(Board.wKilled_panel,BorderLayout.EAST);
        last_panel.add(layeredPane,BorderLayout.CENTER);
        last_panel.add(Board.bKilled_panel,BorderLayout.WEST);
        //last_panel.add(player_panel,BorderLayout.NORTH);


        frame.add(last_panel);
        frame.setVisible(true);

    }
}

