import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
public class Piece{
    int x,y,x_new,y_new;
    boolean iswhite;
    String name;
    public static LinkedList<Piece> ps;
    public static JLabel wKilled_lapel =new JLabel();
    public static JLabel bKilled_lapel=new JLabel();
    public static JPanel wKilled_panel=new JPanel();
    public static JPanel bKilled_panel=new JPanel();
    public Piece(){ }
    public Piece(int x, int y, boolean iswhite, String n , LinkedList<Piece> ps){
        this.x=x;
        this.y=y;
        x_new=x*95;
        y_new=y*95;
        this.iswhite=iswhite;
        name=n;
        this.ps=ps;
        ps.add(this);

        //white killed panel contains white killed lapel which will be added in Board class to our board screen
        wKilled_panel.setBounds(125,0,200,810);
        wKilled_panel.setPreferredSize(new Dimension(200, 800));
        wKilled_panel.setBackground(Color.LIGHT_GRAY);
        wKilled_panel.setLayout(new FlowLayout(FlowLayout.LEFT,10,200));

        //white killed lapel contains white killed pieces
        wKilled_lapel.setBounds(125,0,200,810);
        wKilled_lapel.setPreferredSize(new Dimension(200, 800));
        wKilled_lapel.setLayout(new GridLayout(8,2));
        wKilled_panel.add(wKilled_lapel);
        wKilled_panel.setVisible(true);


        //black killed panel contains black killed lapel which will be added in Board class to our board screen
        bKilled_panel.setBounds(1190,0,200,810);
        bKilled_panel.setPreferredSize(new Dimension(200, 800));
        bKilled_panel.setBackground(Color.LIGHT_GRAY);
        bKilled_panel.setLayout(new FlowLayout(FlowLayout.RIGHT,10,200));

        //black killed lapel contains black killed pieces
        bKilled_lapel.setBounds(1190,0,200,810);
        bKilled_lapel.setPreferredSize(new Dimension(200, 800));
        bKilled_lapel.setLayout(new GridLayout(8,2));
        bKilled_panel.add(bKilled_lapel);
        bKilled_panel.setVisible(true);
    }

    //kill method
   public static void kill( Piece p){

        //killed_pieces.add(ps);
        if (p.iswhite){
            switch (p.name) {
                case "king" : {
                    Image temp_img = Board.imgs[1].getScaledInstance(90, 90, Image.SCALE_SMOOTH);
                    JLabel wking_label=new JLabel(new ImageIcon(temp_img));
                    wking_label.setVisible(true);
                    wKilled_lapel.add(wking_label);
                    ps.remove(p);
                    break;
                }
                case "queen" : {
                    Image temp_img = Board.imgs[0].getScaledInstance(90, 90, Image.SCALE_SMOOTH);
                    JLabel wqueen_label=new JLabel(new ImageIcon(temp_img));
                    wKilled_lapel.add(wqueen_label);
                    ps.remove(p);
                    break;
                }
                case "knight" : {
                    Image temp_img = Board.imgs[3].getScaledInstance(90, 90, Image.SCALE_SMOOTH);
                    JLabel wknight_label=new JLabel(new ImageIcon(temp_img));
                    wKilled_lapel.add(wknight_label);
                    ps.remove(p);
                    break;
                }
                case "rook" : {
                    Image temp_img = Board.imgs[4].getScaledInstance(90, 90, Image.SCALE_SMOOTH);
                    JLabel wrook_label=new JLabel(new ImageIcon(temp_img));
                    wKilled_lapel.add(wrook_label);
                    ps.remove(p);
                    break;
                }
                case "bishop" : {
                    Image temp_img = Board.imgs[2].getScaledInstance(90, 90, Image.SCALE_SMOOTH);
                    JLabel wbishop_label=new JLabel(new ImageIcon(temp_img));
                    wKilled_lapel.add(wbishop_label);
                    ps.remove(p);
                    break;
                }
                case "pawn" : {
                    Image temp_img = Board.imgs[5].getScaledInstance(90, 90, Image.SCALE_SMOOTH);
                    JLabel wpawn_label=new JLabel(new ImageIcon(temp_img));
                    wKilled_lapel.add(wpawn_label);
                    ps.remove(p);
                    break;
                }
            }
        }
        else {
            switch (p.name){
                case "king" : {
                    Image temp_img = Board.imgs[7].getScaledInstance(90, 90, Image.SCALE_SMOOTH);
                    JLabel bking_label=new JLabel(new ImageIcon(temp_img));
                    bKilled_lapel.add(bking_label);
                    ps.remove(p);
                    break;
                }
                case "queen" : {
                    Image temp_img = Board.imgs[6].getScaledInstance(90, 90, Image.SCALE_SMOOTH);
                    JLabel bqueen_label=new JLabel(new ImageIcon(temp_img));
                    bKilled_lapel.add(bqueen_label);
                    ps.remove(p);
                    break;
                }
                case "knight" : {
                    Image temp_img = Board.imgs[9].getScaledInstance(90, 90, Image.SCALE_SMOOTH);
                    JLabel bknight_label=new JLabel(new ImageIcon(temp_img));
                    bKilled_lapel.add(bknight_label);
                    ps.remove(p);
                    break;
                }
                case "rook" : {
                    Image temp_img = Board.imgs[10].getScaledInstance(90, 90, Image.SCALE_SMOOTH);
                    JLabel brook_label=new JLabel(new ImageIcon(temp_img));
                    bKilled_lapel.add(brook_label);
                    ps.remove(p);
                    break;
                }
                case "bishop" : {
                    Image temp_img = Board.imgs[8].getScaledInstance(90, 90, Image.SCALE_SMOOTH);
                    JLabel bbishop_label=new JLabel(new ImageIcon(temp_img));
                    bKilled_lapel.add(bbishop_label);
                    ps.remove(p);
                    break;
                }
                case "pawn" : {
                    Image temp_img = Board.imgs[11].getScaledInstance(90, 90, Image.SCALE_SMOOTH);
                    JLabel bpawn_label=new JLabel(new ImageIcon(temp_img));
                    bKilled_lapel.add(bpawn_label);
                    ps.remove(p);
                    break;
                }
            }
        }
       bKilled_lapel.setVisible(true);
       wKilled_lapel.setVisible(true);
       bKilled_panel.add(bKilled_lapel);
       wKilled_panel.add(wKilled_lapel);
       bKilled_panel.setVisible(true);
       wKilled_panel.setVisible(true);
    }
}
