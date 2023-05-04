import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
public class Board extends JFrame{
    public static LinkedList<Piece> ps;
    public static Image[] imgs=new Image[12];
    public Image[] bords4 = new Image[4];
    Board newFrame;
    public Board(LinkedList<Piece> ps)throws IOException{
        this.ps=ps;
        getBordersPhotos (bords4);
        getPiecesPhotos( imgs);
        panel.setBounds(200,0,800,810);
        panel.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(0, 0, 2000, 880);
        ImageIcon logo= new ImageIcon("src/chess_logo.jpg");
        this.setIconImage(logo.getImage());
        this.setTitle("Chess Game");
        this.setBackground(Color.LIGHT_GRAY);
        this.add(Piece.wKilled_panel);
        this.add(Piece.bKilled_panel);
        this.add(panel);
        this.setVisible(true);


        newFrame=this;
        Piece wrook1 = new Piece(4, 7, true, "rook", ps);
        Piece []killed_pieces={wrook1};
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                for (Piece p : killed_pieces) {
                    Piece.kill(p);
                }
                System.out.println("Clicked");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                for (Piece p : killed_pieces) {
                    ps.remove(p);
                }
                newFrame.repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    // cut 12 photos for pieces
    public static void getPiecesPhotos (Image[] imgs)throws IOException {
        BufferedImage all= ImageIO.read(new File("src/chess.png"));
        int ind=0;
        for(int y=0;y<400;y+=200){
            for(int x=0;x<1200;x+=200){
                imgs[ind]=all.getSubimage(x, y, 200, 200).getScaledInstance(95, 95, BufferedImage.SCALE_SMOOTH);
                ind++;
            }
        }
    }

    //Cut 4 photos for borders
    public static void getBordersPhotos (Image[] bords4) throws IOException {
        BufferedImage bords = ImageIO.read(new File("src/borders_chess.jpg"));
        bords4[0] = bords.getSubimage(0, 10, 20, 530).getScaledInstance(20, 800, BufferedImage.SCALE_SMOOTH);
        bords4[1] = bords.getSubimage(10, 0, 530, 20).getScaledInstance(800, 20, BufferedImage.SCALE_SMOOTH);
        bords4[2] = bords.getSubimage(533, 10, 20, 530).getScaledInstance(20, 800, BufferedImage.SCALE_SMOOTH);
        bords4[3] = bords.getSubimage(10, 533, 530, 20).getScaledInstance(800, 20, BufferedImage.SCALE_SMOOTH);
    }


    //panel which have black&white squares and draw borders and pieces
    JPanel panel =new JPanel() {
        boolean iswhite = true;
        @Override
        public void paint(Graphics g) {
            for (int y = 0; y < 8; y++) {
                for (int x = 4; x < 12; x++) {
                    if (iswhite) g.setColor(new Color(245,255,250));
                    else g.setColor(new Color(95, 158, 160));
                    g.fillRect(x * 95, y * 95 + 20, 95, 95);
                    iswhite = !iswhite;
                }
                iswhite = !iswhite;
            }
            for (Piece p : ps) {
                int ind = 0;
                if (p.name.equalsIgnoreCase("king")) ind = 0;
                if (p.name.equalsIgnoreCase("queen")) ind = 1;
                if (p.name.equalsIgnoreCase("knight")) ind = 3;
                if (p.name.equalsIgnoreCase("bishop")) ind = 2;
                if (p.name.equalsIgnoreCase("rook")) ind = 4;
                if (p.name.equalsIgnoreCase("pawn")) ind = 5;
                if (!p.iswhite) ind += 6;
                g.drawImage(imgs[ind], p.x * 95, p.y * 95 + 20, this);
            }
            g.drawImage(bords4[0], 360, -5, this);
            g.drawImage(bords4[1], 360, 0, this);
            g.drawImage(bords4[2], 1140, -5, this);
            g.drawImage(bords4[3], 360, 780, this);
        }
    };
    public Board(){
    }
}

