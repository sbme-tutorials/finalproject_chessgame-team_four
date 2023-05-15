package Frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import Pieces.*;
import Game.*;
import Board.*;
import Frames.*;
class AnotherFrame extends JFrame {

    JButton logIn;
    JPasswordField passwardText;
    JTextField  usertext;
    public AnotherFrame() {

        //set the frame
        this.setSize(650,841);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Chess Game.Game");
        this.getContentPane().setBackground(new Color(0,26,0));
        ImageIcon image = new ImageIcon("src/Resources/chess_logo.jpg");
        this.setIconImage(image.getImage());
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        // set the background
        JLabel label1 = new JLabel();
        ImageIcon imageShort = new ImageIcon("src/Resources/tall3.jpg");
        label1.setIcon(imageShort);
        label1.setBounds(1,1,648,841);
        this.add(label1);

        //creat Username and password text field
        JLabel label = new JLabel("Username:");
        label.setBounds(204,380,170,25);
        label.setForeground(Color.white);
        label.setFont(new Font("MV Boli",Font.PLAIN,15));
        label1.add(label);

        usertext = new JTextField();
        usertext.setBounds(204,420,240,25);
        label1.add(usertext);


        JLabel passwardlabel = new JLabel("Password:");
        passwardlabel.setBounds(204,460,160,25);
        passwardlabel.setForeground(Color.white);
        passwardlabel.setFont(new Font("MV Boli",Font.PLAIN,15));
        label1.add(passwardlabel);

        passwardText = new JPasswordField();
        passwardText.setBounds(204,500,240,25);
        label1.add(passwardText);

        //log in button
        logIn = new JButton("Log In");
        logIn.setBounds(210,560,100,35);
        logIn.setForeground(Color.white);
        logIn.setFont(new Font("MV Boli",Font.PLAIN,20));
        logIn.setBackground(new Color(0,26,0));
        logIn.setFocusable(false);
        logIn.setBorder(BorderFactory.createEtchedBorder());

        // create account button
        JButton create = new JButton("Create Account");
        create.setBounds(325,560,150,35);
        create.setForeground(Color.white);
        create.setFont(new Font("MV Boli",Font.PLAIN,20));
        create.setBackground(new Color(0,26,0));
        create.setFocusable(false);
        create.setBorder(BorderFactory.createEtchedBorder());
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame anotherFrame = (JFrame) SwingUtilities.getWindowAncestor(create);
                anotherFrame.dispose();
                creatAccount anotherFrame2 = new creatAccount();
                anotherFrame2.setVisible(true);
            }
        });
        label1.add(create);
        logIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String username = usertext.getText();
                char[] password =passwardText.getPassword();

                // Check if the username or password fields are empty
                if (username.isEmpty() || password.length == 0) {
                    JOptionPane.showMessageDialog(null, "Error: All fields are required", "Login Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Check if the username and password match the registration data
                try {
                    BufferedReader reader = new BufferedReader(new FileReader("Registration data.txt"));
                    String line;
                    boolean found = false;
                    while ((line = reader.readLine()) != null) {
                        String[] fields = line.split(", ");
                        if (fields[0].equals(username) && fields[2].equals(new String(password))) {
                            found = true;
                            break;
                        }
                    }
                    reader.close();
                    if (found) {
                        JOptionPane.showMessageDialog(null, "Login successful", "Success", JOptionPane.INFORMATION_MESSAGE);

                        JFrame anotherFrame = (JFrame) SwingUtilities.getWindowAncestor(logIn);
                        anotherFrame.dispose();
                        AnotherFrame2 anotherFrame2 = new AnotherFrame2();
                        anotherFrame2.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: Invalid username or password", "Login Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        label1.add(logIn);
        this.setVisible(true);
    }
}
