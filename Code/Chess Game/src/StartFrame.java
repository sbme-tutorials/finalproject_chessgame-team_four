import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.io.*;

class StartFrame extends JFrame {
    public StartFrame() {

        //set the background
        JLabel startLabel = new JLabel();
        ImageIcon imageStart = new ImageIcon("src/start.jpg");
        startLabel.setIcon(imageStart);
        startLabel.setBounds(0,0,736,1061);
        add(startLabel);

        //set the start frame
        setSize(736,1061);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setTitle("Chess Game");
        ImageIcon imageLogo = new ImageIcon("logo.jpg");
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

class AnotherFrame extends JFrame {

    JButton logIn;
    JPasswordField passwardText;
    JTextField  usertext;
    public AnotherFrame() {

        //set the frame
        this.setSize(650,841);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Chess Game");
        this.getContentPane().setBackground(new Color(0,26,0));
        ImageIcon image = new ImageIcon("src/chess_logo.jpg");
        this.setIconImage(image.getImage());
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        // set the background
        JLabel label1 = new JLabel();
        ImageIcon imageShort = new ImageIcon("src/tall3.jpg");
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



class AnotherFrame2 extends JFrame {

    public AnotherFrame2() {

        // set the frame
        this.setSize(650,841);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Chess Game");
        this.getContentPane().setBackground(new Color(0,26,0));
        ImageIcon image = new ImageIcon("src/chess_logo.jpg");
        this.setIconImage(image.getImage());
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        //set the background
        JLabel label1 = new JLabel();
        ImageIcon imageShort = new ImageIcon("src/talll.jpg");
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



class creatAccount extends JFrame {
    JButton register;
    JPasswordField passwardText;
    JTextField usertext;
    JTextField emailtext;

    public creatAccount() {

        //set the frame
        this.setSize(650, 841);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Chess Game");
        this.getContentPane().setBackground(new Color(0, 26, 0));
        ImageIcon image = new ImageIcon("src/chess_logo.jpg");
        this.setIconImage(image.getImage());
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        //set the background
        JLabel label1 = new JLabel();
        ImageIcon imageShort = new ImageIcon("src/tall3.jpg");
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
