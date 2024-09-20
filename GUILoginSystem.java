// WAP in java to do the following.
// A login page which use GUI and  will allow incorrect  user id and password maximum 3 times.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUILoginSystem extends JFrame {
    private static final String CORRECT_USER_ID = "Avinash";
    private static final String CORRECT_PASSWORD = "ad1234";
    private static final int MAX_ATTEMPTS = 3;

    private JTextField userIdField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel messageLabel;
    private int attempts = 0;

    public GUILoginSystem() {
        setTitle("Login System");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        JPanel userIdPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        userIdPanel.add(new JLabel("User ID:"));
        userIdField = new JTextField(15);
        userIdPanel.add(userIdField);

        JPanel passwordPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        passwordPanel.add(new JLabel("Password:"));
        passwordField = new JPasswordField(15);
        passwordPanel.add(passwordField);

        loginButton = new JButton("Login");
        messageLabel = new JLabel("", JLabel.CENTER);

        add(userIdPanel);
        add(passwordPanel);
        add(loginButton);
        add(messageLabel);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userId = userIdField.getText();
                String password = new String(passwordField.getPassword());

                if (userId.equals(CORRECT_USER_ID) && password.equals(CORRECT_PASSWORD)) {
                    JOptionPane.showMessageDialog(GUILoginSystem.this, 
                        "Login successful. Welcome, " + userId + "!");
                    System.exit(0);
                } else {
                    attempts++;
                    int remainingAttempts = MAX_ATTEMPTS - attempts;
                    if (remainingAttempts > 0) {
                        messageLabel.setText("Incorrect credentials. Attempts left: " + remainingAttempts);
                    } else {
                        messageLabel.setText("Account locked. Too many failed attempts.");
                        loginButton.setEnabled(false);
                        JOptionPane.showMessageDialog(GUILoginSystem.this, 
                            "Maximum login attempts reached. Account locked.");
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GUILoginSystem().setVisible(true);
            }
        });
    }
}