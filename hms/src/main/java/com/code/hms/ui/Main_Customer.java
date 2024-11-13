package com.code.hms.ui;

import javax.swing.*;

public class Main_Customer {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CustomerUI();
            }
        });
    }
}
