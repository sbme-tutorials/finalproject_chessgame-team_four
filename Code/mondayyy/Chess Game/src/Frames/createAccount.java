package Frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import Pieces.*;
import Game.*;
import Board.*;

class creatAccount extends JFrame {
    JButton register;
    JPasswordField passwardText;
    JTextField usertext;
    JTextField emailtext;

    public creatAccount() {

        //set the frame
        this.setSize(650, 841);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Chess Game.Game");
        this.getContentPane().setBackground(new Color(0, 26, 0));
        ImageIcon image = new ImageIcon("src/Resources/chess_logo.jpg");
        this.setIconImage(image.getImage());
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        //set the background
        JLabel label1 = new JLabel();
        ImageIcon imageShort = new ImageIcon("src/Resources/tall3.jpg");
        label1.setIcon(imageShort);
        label1.setBounds(1, 1, 648, 841);
        this.add(label1);

        //set the text fields
        JLabel label = new JLabel("User Name:");
        label.setBounds(204, 360, 170, 25);
        label.setForeground(Color.white);
        label.setFont(new Font("MV Boli", Font.PLAIN, 15));
        label1.add(label);
        usertext = new JTextField();
        usertext.setBounds(204, 390, 240, 25);
        label1.add(usertext);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(204, 420, 170, 25);
        emailLabel.setForeground(Color.white);
        emailLabel.setFont(new Font("MV Boli", Font.PLAIN, 15));
        label1.add(emailLabel);
        emailtext = new JTextField();
        emailtext.setBounds(204, 450, 240, 25);
        label1.add(emailtext);

        JLabel passwardlabel = new JLabel("Password:");
        passwardlabel.setBounds(204, 480, 160, 25);
        passwardlabel.setForeground(Color.white);
        passwardlabel.setFont(new Font("MV Boli", Font.PLAIN, 15));
        label1.add(passwardlabel);
        passwardText = new JPasswordField();
        passwardText.setBounds(204, 510, 240, 25);
        label1.add(passwardText);

        //register button
        register = new JButton("Register");
        register.setBounds(260, 560, 100, 35);
        register.setForeground(Color.white);
        register.setFont(new Font("MV Boli", Font.PLAIN, 20));
        register.setBackground(new Color(0, 26, 0));
        register.setFocusable(false);
        register.setBorder(BorderFactory.createEtchedBorder());
        label1.add(register);
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usertext.getText();
                String email = emailtext.getText();
                char[] password = passwardText.getPassword();


                if (username.isEmpty() || email.isEmpty() || password.length == 0) {
                    JOptionPane.showMessageDialog(null, "Error: Please fill all the fields", "Registration Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (e.getSource() == register){
                    try {
                        FileWriter fw = new FileWriter("Registration data.txt", true);
                        fw.write(usertext.getText() +", " + emailtext.getText()+", "+new String(passwardText.getPassword()) + "\n");
                        fw.close();
                        JOptionPane.showMessageDialog(null, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        usertext.setText("");
                        emailtext.setText("");
                        passwardText.setText("");

                    } catch (IOException ex){
                        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

                    }
                    JFrame creatAccount = (JFrame) SwingUtilities.getWindowAncestor(register);
                    creatAccount.dispose();
                    AnotherFrame2 anotherFrame2 =new AnotherFrame2();
                    anotherFrame2.setVisible(true);

                }
            }

        });
    }}