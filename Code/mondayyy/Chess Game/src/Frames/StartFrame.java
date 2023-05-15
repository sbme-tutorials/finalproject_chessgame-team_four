package Frames;
import Board.Frame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.io.*;
import Pieces.*;
import Game.*;
import Board.*;
public class StartFrame extends JFrame {
    public StartFrame() {

        //set the background
        JLabel startLabel = new JLabel();
        ImageIcon imageStart = new ImageIcon("src/Resources/start.jpg");
        startLabel.setIcon(imageStart);
        startLabel.setBounds(0,0,736,1061);
        add(startLabel);

        //set the start frame
        setSize(736,1061);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setTitle("Chess Game.Game");
        ImageIcon imageLogo = new ImageIcon("src/Resources/chess_logo.jpg");
        setIconImage(imageLogo.getImage());
        getContentPane().setBackground(new Color(0,26,0));

        // start button
        JButton  start = new JButton("Start");
        start.setBounds(220,580 ,150,80);
        start.setForeground(Color.white);
        start.setFont(new Font("MV Boli",Font.PLAIN,30));
        start.setBackground(new Color(0,26,0));
        start.setFocusable(false);
        start.setBorder(BorderFactory.createEtchedBorder());
        startLabel.add(start);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame startFrame = (JFrame) SwingUtilities.getWindowAncestor(start);
                startFrame.dispose();
                AnotherFrame anotherFrame = new AnotherFrame();
                anotherFrame.setVisible(true);
            }
        });
    }
    public static void main(String[] args) {
        StartFrame mainFrame = new StartFrame();
        mainFrame.setVisible(true);
    }
}