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
        LoadImage loader = new LoadImage("hms/bg img/bg.png", getWidth(), getHeight());
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



    public static void main(String[] args) {
        new ForgotPasswordWindow().setVisible(true);
    }
}
