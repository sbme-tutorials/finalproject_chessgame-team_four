package Frames;

import Board.Board;
import Board.Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import Pieces.*;
import Game.*;
import Board.*;

class AnotherFrame2 extends JFrame {

    public AnotherFrame2() {

        // set the frame
        this.setSize(650,841);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Chess Game.Game");
        this.getContentPane().setBackground(new Color(0,26,0));
        ImageIcon image = new ImageIcon("src/Resources/chess_logo.jpg");
        this.setIconImage(image.getImage());
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        //set the background
        JLabel label1 = new JLabel();
        ImageIcon imageShort = new ImageIcon("src/Resources/talll.jpg");
        label1.setIcon(imageShort);
        label1.setBounds(1,1,648,841);
        this.add(label1);

        // player1 name
        JLabel label = new JLabel("Name of Player1:");
        label.setBounds(204,380,173 ,25);
        label.setForeground(Color.white);
        label.setFont(new Font("MV Boli",Font.PLAIN,15));
        label1.add(label);
        JTextField  usertext = new JTextField();
        usertext.setBounds(204,420,240,25);
        label1.add(usertext);

        //player2 name
        JLabel user2label = new JLabel("Name of Player2:");
        user2label.setBounds(204,460,160,25);
        user2label.setForeground(Color.white);
        user2label.setFont(new Font("MV Boli",Font.PLAIN,15));
        label1.add(user2label);
        JTextField user2Text = new JTextField();
        user2Text.setBounds(204,500,240,25);
        label1.add(user2Text);

        //play button
        JButton logIn = new JButton("Play");
        logIn.setBounds(260,560,100,35);
        logIn.setForeground(Color.white);
        logIn.setFont(new Font("MV Boli",Font.PLAIN,20));
        logIn.setBackground(new Color(0,26,0));
        logIn.setFocusable(false);
        logIn.setBorder(BorderFactory.createEtchedBorder());
        label1.add(logIn);

        //time
        JLabel timeLabel = new JLabel("Add Time:");
        timeLabel.setBounds(204,300,80,25);
        timeLabel.setForeground(Color.white);
        timeLabel.setFont(new Font("MV Boli",Font.PLAIN,15));
        label1.add(timeLabel);
        JTextField  timeText = new JTextField();
        timeText.setBounds(204,340,100,25);
        label1.add(timeText);
        this.setVisible(true);
        logIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                FileWriter fw = null;
                try {
                    fw = new FileWriter("player.txt", true);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    fw.write(timeText.getText() +", " + usertext.getText()+", "+user2Text.getText() + "\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    fw.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                try {
                    BufferedReader reader = new BufferedReader(new FileReader("player.txt"));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] fields = line.split(", ");
                    }
                    reader.close();


                    JFrame anotherFrame2 = (JFrame) SwingUtilities.getWindowAncestor(logIn);
                    anotherFrame2.dispose();
                    Frame panels = new Frame();
                    panels.setVisible(true);


                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

        });}}
