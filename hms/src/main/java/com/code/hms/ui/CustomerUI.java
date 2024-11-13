package com.code.hms.ui;

import javax.swing.*;

public class CustomerUI {
    public static class HotelInfoGUI {
        static JFrame frame;
        static JPanel panel;

        public HotelInfoGUI() {
            createMainGUI();
        }

        private void createMainGUI() {
            // Frame setup
            frame = new JFrame();
            frame.setSize(1440, 900);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setResizable(true);

            // Panel setup
            panel = new JPanel();
            panel.setLayout(null);
            frame.getContentPane().add(panel);
        }
        }
}
