import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/* public class draft implements MouseListener {
    public draft() {

    this.addMouseMotionListener(new MouseMotionListener() {
        @Override
        public void mouseDragged (MouseEvent e){
            if (selectedPiece != null) {
                selectedPiece.x = e.getX() - 47;
                selectedPiece.y = e.getY() - 47;
                // this.repaint();
            }
        }

        @Override
        public void mouseMoved (MouseEvent e){

        }
    });
        this.

    addMouseListener(new MouseListener() {
        @Override
        public void mouseClicked (MouseEvent e){
            selectedPiece = get_piece(e.getX(), e.getY());
        }

        @Override
        public void mousePressed (MouseEvent e){

        }

        @Override
        public void mouseReleased (MouseEvent e){
            selectedPiece.move(e.getX() / 95, e.getY() / 95);
            //this.repaint();
        }

        @Override
        public void mouseEntered (MouseEvent e){

        }

        @Override
        public void mouseExited (MouseEvent e){

        }
    });
}
}
*/

// wKilled_lapel.setBounds(125,0,200,810);


// wKilled_panel.setBounds(125,0,200,810);

//wKilled_panel.add(wKilled_lapel);

//wKilled_panel.add(wKilled_lapel);



        /*//bKilled_lapel.setPreferredSize(new Dimension(120, 350));
        bKilled_lapel.setBounds(1190,0,100,100);
        bKilled_lapel.setLayout(new GridLayout(8,2));

        bKilled_panel.setPreferredSize(new Dimension(200, 800));
        bKilled_panel.setLayout(new FlowLayout(FlowLayout.RIGHT,10,200));
        bKilled_panel.setBackground(Color.LIGHT_GRAY);
        bKilled_lapel.setVisible(true);
        bKilled_panel.add(bKilled_lapel);
        bKilled_panel.setVisible(true);*/

// bKilled_lapel.setBounds(1190,0,200,810);
//bKilled_panel.setBounds(1190,0,200,810);
//bKilled_panel.setBackground(Color.LIGHT_GRAY);
//bKilled_panel.setPreferredSize(new Dimension(200, 810));
//bKilled_panel.setBackground(new Color(14, 104, 141, 255));
//bKilled_panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 10,200));

//bKilled_lapel.setPreferredSize(new Dimension(120, 350));
//bKilled_lapel.setLayout(new GridLayout(8,2));
//bKilled_panel.add(bKilled_lapel);
//bKilled_panel.setVisible(true);


/*
public static void kill( boolean iswhite,String name){
        //killed_pieces.add(ps);
        if (iswhite){
        switch (name) {
        case "king" : {
        //ImageIcon wking_icon = new ImageIcon("src/Wking.png");
        //Image img = wking_icon.getImage();
        Image temp_img = Board.imgs[1].getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        JLabel wking_label=new JLabel(new ImageIcon(temp_img));
        wking_label.setVisible(true);
        wKilled_lapel.add(wking_label);
        break;
        }
        case "queen" : {
        ImageIcon wqueen_icon = new ImageIcon("src/Wqueen.png");
        Image img = wqueen_icon.getImage();
        Image temp_img = img.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        JLabel wqueen_label=new JLabel(new ImageIcon(temp_img));
        wKilled_lapel.add(wqueen_label);
        break;
        }
        case "knight" : {
        ImageIcon wknight_icon = new ImageIcon("src/Wknight.jpeg");
        Image img = wknight_icon.getImage();
        Image temp_img = img.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        JLabel wknight_label=new JLabel(new ImageIcon(temp_img));
        wKilled_lapel.add(wknight_label);
        break;
        }
        case "rook" : {
        ImageIcon wrook_icon = new ImageIcon("src/Wrook.png");
        Image img = wrook_icon.getImage();
        Image temp_img = img.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        JLabel wrook_label=new JLabel(new ImageIcon(temp_img));
        wKilled_lapel.add(wrook_label);
        break;
        }
        case "bishop" : {
        ImageIcon wbishop_icon = new ImageIcon("src/Wbishop.png");
        Image img = wbishop_icon.getImage();
        Image temp_img = img.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        JLabel wbishop_label=new JLabel(new ImageIcon(temp_img));
        wKilled_lapel.add(wbishop_label);
        break;
        }
        case "pawn" : {
        ImageIcon wpawn_icon = new ImageIcon("src/Wpawn.jpeg");
        Image img = wpawn_icon.getImage();
        Image temp_img = img.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        JLabel wpawn_label=new JLabel(new ImageIcon(temp_img));
        wKilled_lapel.add(wpawn_label);
        break;
        }
        }
        }
        else {
        switch (name){
        case "king" : {
        ImageIcon bking_icon = new ImageIcon("src/Bking.png");
        Image img = bking_icon.getImage();
        Image temp_img = img.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        JLabel bking_label=new JLabel(new ImageIcon(temp_img));
        bKilled_lapel.add(bking_label);
        break;
        }
        case "queen" : {
        ImageIcon bqueen_icon = new ImageIcon("src/Bqueen.jpeg");
        Image img = bqueen_icon.getImage();
        Image temp_img = img.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        JLabel bqueen_label=new JLabel(new ImageIcon(temp_img));
        bKilled_lapel.add(bqueen_label);
        break;
        }
        case "knight" : {
        ImageIcon bknight_icon = new ImageIcon("src/Bknight.png");
        Image img = bknight_icon.getImage();
        Image temp_img = img.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        JLabel bknight_label=new JLabel(new ImageIcon(temp_img));
        bKilled_lapel.add(bknight_label);
        break;
        }
        case "rook" : {
        ImageIcon brook_icon = new ImageIcon("src/Brook.png");
        Image img = brook_icon.getImage();
        Image temp_img = img.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        JLabel brook_label=new JLabel(new ImageIcon(temp_img));
        bKilled_lapel.add(brook_label);
        break;
        }
        case "bishop" : {
        ImageIcon bbishop_icon = new ImageIcon("src/Bbishop.jpeg");
        Image img = bbishop_icon.getImage();
        Image temp_img = img.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        JLabel bbishop_label=new JLabel(new ImageIcon(temp_img));
        bbishop_label.setVisible(true);
        bKilled_lapel.add(bbishop_label);
        System.out.println("bishop killed");
        break;
        }
        case "pawn" : {
        ImageIcon bpawn_icon = new ImageIcon("src/Bpawn.jpeg");
        Image img = bpawn_icon.getImage();
        Image temp_img = img.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        JLabel bpawn_label=new JLabel(new ImageIcon(temp_img));
        bKilled_lapel.add(bpawn_label);
        break;
        }
        }
        }*/