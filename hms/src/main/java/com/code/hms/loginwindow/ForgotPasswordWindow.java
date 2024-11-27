package com.code.hms.loginwindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ForgotPasswordWindow extends JFrame {

    // Declare components
    static JTextField usernameField, emailField;
    static JButton resetPasswordButton;

    public ForgotPasswordWindow() {
        // Set up frame
        setTitle("Forgot Password");
        setSize(1280, 672);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create main panel
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Load and set the background
        LoadImage loader = new LoadImage("hms/src/main/java/com/code/hms/assets/bg.png", getWidth(), getHeight());
        JLabel backgroundLbl = new JLabel(loader.getImageIcon());
        backgroundLbl.setBounds(0, 0, getWidth(), getHeight());
        panel.add(backgroundLbl);

        // Semi-transparent form panel
        JPanel forgotPasswordPanel = new JPanel();
        forgotPasswordPanel.setLayout(null);
        forgotPasswordPanel.setBackground(new Color(0, 0, 0, 150));
        forgotPasswordPanel.setBounds(0, 0, 500, 672);

        // Title
        JLabel title = new JLabel("Forgot Password");
        title.setFont(new Font("Serif", Font.BOLD, 30));
        title.setForeground(Color.WHITE);
        title.setBounds(150, 70, 300, 40);
        forgotPasswordPanel.add(title);

        // Username Label
        JLabel usernameLbl = new JLabel("Username");
        usernameLbl.setFont(new Font("SansSerif", Font.PLAIN, 16));
        usernameLbl.setForeground(Color.WHITE);
        usernameLbl.setBounds(50, 150, 200, 30);
        forgotPasswordPanel.add(usernameLbl);

        // Username Text Field
        usernameField = new JTextField();
        usernameField.setBounds(50, 180, 400, 40);
        usernameField.setFont(new Font("SansSerif", Font.PLAIN, 16));
        forgotPasswordPanel.add(usernameField);

        // Email/Phone Label
        JLabel emailLbl = new JLabel("Email / Phone Number");
        emailLbl.setFont(new Font("SansSerif", Font.PLAIN, 16));
        emailLbl.setForeground(Color.WHITE);
        emailLbl.setBounds(50, 250, 200, 30);
        forgotPasswordPanel.add(emailLbl);

        // Email/Phone Text Field
        emailField = new JTextField();
        emailField.setBounds(50, 280, 400, 40);
        emailField.setFont(new Font("SansSerif", Font.PLAIN, 16));
        forgotPasswordPanel.add(emailField);

        // Reset Password Button
        resetPasswordButton = new JButton("Reset Password");
        resetPasswordButton.setBounds(150, 380, 200, 50);
        resetPasswordButton.setBackground(Color.decode("#847966"));
        resetPasswordButton.setForeground(Color.WHITE);
        resetPasswordButton.setFont(new Font("SansSerif", Font.BOLD, 18));
        forgotPasswordPanel.add(resetPasswordButton);

        // Add panels
        backgroundLbl.add(forgotPasswordPanel);
        add(panel);

        // Add ActionListener for reset password button
        resetPasswordButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String emailOrPhone = emailField.getText();

                if (username.isEmpty() || emailOrPhone.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields!");
                } else {
                    JOptionPane.showMessageDialog(null, "Reset link sent to: " + emailOrPhone);
                }
            }
        });
    }

    public static void main(String[] args) {
        new ForgotPasswordWindow().setVisible(true);
    }
}
