package com.code.hms.loginwindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ForgotPasswordWindow extends JFrame {

    // Declare components
    static JTextField usernameField, emailField;
    static JButton resetPasswordButton;



    public static void main(String[] args) {
        new ForgotPasswordWindow().setVisible(true);
    }
}
