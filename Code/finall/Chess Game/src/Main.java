import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame();
        frame.setLayout(new GridBagLayout());
        frame.setMinimumSize(new Dimension(1000, 1000));
        frame.setTitle("Chess Game");
        ImageIcon logo= new ImageIcon("src/chess_logo.jpg");
        frame.setIconImage(logo.getImage());
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        Board board=new Board();


        //black player panel
        JLabel black_player_label=new JLabel();
        black_player_label.setText("BLACK PLAYER");
        black_player_label.setFont(new Font("MV Boli",Font.PLAIN,30));

        JPanel black_player_panel=new JPanel();
        black_player_panel.add(black_player_label);
        black_player_panel.setBackground(Color.LIGHT_GRAY);

        //white player panel
        JLabel white_player_label=new JLabel();
        white_player_label.setText("WHITE PLAYER ");
        white_player_label.setFont(new Font("MV Boli",Font.PLAIN,30));

        JPanel white_player_panel=new JPanel();
        white_player_panel.add(white_player_label);
        white_player_panel.setBackground(Color.LIGHT_GRAY);

        //VS panel
        JLabel vs_label=new JLabel();
        vs_label.setText("VS ");
        vs_label.setFont(new Font("MV Boli",Font.PLAIN,30));

        JPanel vs_panel=new JPanel();
        vs_panel.add(vs_label);
        vs_panel.setBackground(Color.LIGHT_GRAY);

        // panel el foo2
        JPanel player_panel=new JPanel();
        player_panel.setLayout(new BorderLayout());
        player_panel.setBackground(Color.LIGHT_GRAY);
        player_panel.add(white_player_panel,BorderLayout.LINE_END);
        player_panel.add(vs_panel,BorderLayout.CENTER);
        player_panel.add(black_player_panel,BorderLayout.BEFORE_LINE_BEGINS);


        //Borders
        JLabel borders_label=new JLabel();
        ImageIcon icon=new ImageIcon("src/borders_chess.jpg");
        borders_label.setIcon(icon);
        JPanel borders_panel=new JPanel();
        borders_panel.add(borders_label);

        //Layered panel for borders
        JLayeredPane layeredPane =new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(734, 734));
        layeredPane.add(borders_panel,JLayeredPane.DEFAULT_LAYER);
        borders_panel.setBounds(-1,-5,735,740);
        layeredPane.add(board,JLayeredPane.PALETTE_LAYER);
        board.setBounds(27,27,680,680);
        layeredPane.setVisible(true);

        //last panel
        JPanel last_panel = new JPanel();
        last_panel.setLayout(new BorderLayout());
        last_panel.add(Board.wKilled_panel,BorderLayout.EAST);
        last_panel.add(layeredPane,BorderLayout.CENTER);
        last_panel.add(Board.bKilled_panel,BorderLayout.WEST);

        //a5er panel wallahy
        JPanel last_final_panel = new JPanel();
        last_final_panel.setLayout(new BorderLayout());
        last_final_panel.add(player_panel,BorderLayout.NORTH);
        last_final_panel.add(last_panel,BorderLayout.SOUTH);

        frame.add(last_final_panel);
        frame.setVisible(true);
    }
}

