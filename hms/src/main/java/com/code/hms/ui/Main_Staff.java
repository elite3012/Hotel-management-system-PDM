package com.code.hms.ui;

import javax.swing.*;

public class Main_Staff {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StaffUI();
            }
        });
    }
}