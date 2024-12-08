package com.code.hms.loginwindow;

import javax.swing.*;

import com.code.hms.daoimpl.UserDaoImpl;
import com.code.hms.utils.ForgotPassword;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ForgotPasswordWindow extends JFrame {

    // Declare components
    public JTextField usernameField, emailField;
    public JButton button;
    public JPanel forgotPasswordPanel, panel;
    public JLabel title, usernameLbl, emailLbl, backgroundLbl;
    public ForgotPassword forgotPassword;
    public UserDaoImpl userdao;
    public String username, email;

    public ForgotPasswordWindow() {
        // Set up frame
        setTitle("Forgot Password");
        setSize(1280, 672);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create main panel
        panel = new JPanel();
        panel.setLayout(null);

        // Load and set the background
        LoadImage loader = new LoadImage("hms/src/main/java/com/code/hms/assets/Login_BG.png", getWidth(), getHeight());
        backgroundLbl = new JLabel(loader.getImageIcon());
        backgroundLbl.setBounds(0, 0, getWidth(), getHeight());
        panel.add(backgroundLbl);

        // Semi-transparent form panel
        forgotPasswordPanel = new JPanel();
        forgotPasswordPanel.setLayout(null);
        forgotPasswordPanel.setBackground(new Color(0, 0, 0, 150));
        forgotPasswordPanel.setBounds(0, 0, 500, 672);

        // Title
        title = new JLabel("Forgot Password");
        title.setFont(new Font("Serif", Font.BOLD, 30));
        title.setForeground(Color.WHITE);
        title.setBounds(150, 70, 300, 40);
        forgotPasswordPanel.add(title);

        // Username Label
        usernameLbl = new JLabel("Username");
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
        emailLbl = new JLabel("Email");
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
        button = new JButton("Send verification code");
        button.setBounds(150, 380, 200, 50);
        button.setBackground(Color.decode("#847966"));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("SansSerif", Font.BOLD, 18));
        button.setFocusable(false);
        forgotPasswordPanel.add(button);

        // Add panels
        backgroundLbl.add(forgotPasswordPanel);
        add(panel);

        // Add ActionListener for reset password button
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                username = usernameField.getText();
                email = emailField.getText();

                if (username.isEmpty() || email.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields!");
                } else {
                    userdao = new UserDaoImpl();
                    if (userdao.getUserIDByUsername(username) > 0) {
                        System.out.println(userdao.getUserIDByUsername(username));
                        System.out.println(userdao.getUserByID(userdao.getUserIDByUsername(username)).getEmail());
                        System.out.println(email);
                        if (userdao.getUserByID(userdao.getUserIDByUsername(username)).getEmail().equals(email)) {
                            createVerificationUI();
                            forgotPassword.sendPasswordResetCode(email);
                        } else {
                            System.out.println("Incorrect email");
                        }
                    } else {
                        System.out.println("Cannot find user with username: " + username);
                    }
                    // JOptionPane.showMessageDialog(null, "Reset link sent to: " + email);
                }
            }
        });
    }

    public void createVerificationUI() {
        title.setVisible(false);
        usernameLbl.setVisible(false);
        usernameField.setVisible(false);
        emailLbl.setVisible(false);
        emailField.setVisible(false);
        button.setVisible(false);
        
        title.setText("Verify");
        usernameLbl.setText("Verification code:");
        usernameField.setText("");
        button.setText("Verify code");
        removeActionListeners(button);
        
        title.setVisible(true);
        usernameLbl.setVisible(true);
        usernameField.setVisible(true);
        button.setVisible(true);
        
        forgotPassword = new ForgotPassword();
        
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (forgotPassword.isValidResetCode(usernameField.getText())) {
                    createResetPasswordUI();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Wrong Code");
                }
            }
        });
        
        backgroundLbl.repaint();
        backgroundLbl.revalidate();
    }

    public void createResetPasswordUI() {
        title.setVisible(false);
        usernameLbl.setVisible(false);
        usernameField.setVisible(false);
        button.setVisible(false);

        title.setText("Change password");
        emailLbl.setText("Enter new password");
        emailField.setText("");
        usernameLbl.setText("Re-enter new password");
        usernameField.setText("");
        button.setText("Confirm new password");
        removeActionListeners(button);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (emailField.getText().equals(usernameField.getText())) {
                    String newPassword = emailField.getText();
                    int userId = userdao.getUserIDByUsername(username);
                    userdao.changePassword(userId, newPassword);
                    JOptionPane.showMessageDialog(rootPane, "Changed password successfully");
                    dispose();
                    SwingUtilities.invokeLater(() -> new LoginWindow().setVisible(true));
                }
            }
        });

        title.setVisible(true);
        usernameLbl.setVisible(true);
        usernameField.setVisible(true);
        emailLbl.setVisible(true);
        emailField.setVisible(true);
        button.setVisible(true);

        backgroundLbl.repaint();
        backgroundLbl.revalidate();
    }

    public void removeActionListeners(AbstractButton button) {
        if (button == null) {
            return;
        }
        ActionListener[] listeners = button.getActionListeners();
        if (listeners == null) {
            return;
        }
        for (ActionListener listener : listeners) {
            button.removeActionListener(listener);
        }
    }

    public static void main(String[] args) {
        new ForgotPasswordWindow().setVisible(true);
    }
}
